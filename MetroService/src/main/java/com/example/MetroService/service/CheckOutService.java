package com.example.MetroService.service;


import com.example.MetroService.dto.FareResponseDTO;
import com.example.MetroService.exception.InvalidCheckOutTimeException;
import com.example.MetroService.exception.UserNotCheckedInException;
import com.example.MetroService.model.CheckOutRequest;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

@Service
@Transactional


public class CheckOutService implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(CheckOutService.class);
    private final RabbitTemplate rabbitTemplate;
    private final CheckInService checkInService;

    public CheckOutService(RabbitTemplate rabbitTemplate, CheckInService checkInService) {
        this.rabbitTemplate = rabbitTemplate;
        this.checkInService = checkInService;
    }

    public FareResponseDTO processCheckOut(CheckOutRequest request) {
        log.info("Processing check-out for user: {}", request.getUserId());

        // Retrieve the check-in time for the user
        LocalDateTime checkInTime = checkInService.getCheckInTime(request.getUserId());
        if (checkInTime == null) {
            log.error("User did not check in, userId: {}", request.getUserId());
            throw new UserNotCheckedInException("User did not check in: " + request.getUserId());
        }

        // Use current time as the check-out time
        LocalDateTime checkOutTime = LocalDateTime.now();
        log.info("Using current time {} as check-out time for user: {}", checkOutTime, request.getUserId());

        // Validate that the check-out time is after the check-in time (safeguard)
        if (checkOutTime.isBefore(checkInTime)) {
            log.error("Invalid check-out time: {} is before check-in time: {} for user: {}",
                    checkOutTime, checkInTime, request.getUserId());
            throw new InvalidCheckOutTimeException("Check-out time must be after check-in time for user: " + request.getUserId());
        }

        // Inline fare calculation logic
        long minutes = Duration.between(checkInTime, checkOutTime).toMinutes();
        double baseFare = 10.0;
        double additionalFare = minutes * 0.5;  // 50 cents per minute
        double fareAmount = baseFare + additionalFare;
        log.info("Calculated fare amount: {} for user: {}", fareAmount, request.getUserId());

        // Build FareResponseDTO
        FareResponseDTO fareResponse = new FareResponseDTO();
        fareResponse.setUserId(request.getUserId());
        fareResponse.setFareAmount(fareAmount);
        fareResponse.setMessage("Check-out successful");

        // Remove the check-in record after checkout
        checkInService.removeCheckIn(request.getUserId());
        log.info("Removed check-in record for user: {}", request.getUserId());

        // Publish the fare details to the Payment Service via RabbitMQ
        rabbitTemplate.convertAndSend("metro.exchange", "metro.checkout", fareResponse);
        log.info("Published fare response to RabbitMQ for user: {}", request.getUserId());

        return fareResponse;
    }
}
