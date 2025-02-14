package com.example.MetroService.service;


import com.example.MetroService.exception.InvalidUserException;
import com.example.MetroService.model.CheckInRecord;
import com.example.MetroService.model.CheckInRequest;
import com.example.MetroService.repository.CheckInRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service

public class CheckInService {

    private static final Logger log = LoggerFactory.getLogger(CheckInService.class);
    //
    private final CheckInRepository checkInRepository;

    public CheckInService(CheckInRepository checkInRepository) {
        this.checkInRepository = checkInRepository;
    }

    public void processCheckIn(CheckInRequest request) {
        log.info("Processing check-in for user: {}", request.getUserId());

        // Validate credentials (placeholder logic)
        if (!validateUser(request)) {
            log.error("Validation failed for user: {} with credential: {}", request.getUserId(), request.getCredential());
            throw new InvalidUserException("Invalid QR code or metro card for user: " + request.getUserId());
        }

        // Create and persist a check-in record
        CheckInRecord record = new CheckInRecord();
        record.setUserId(request.getUserId());
        record.setStationId(request.getStationId());
        record.setCheckInTime(LocalDateTime.now());
        checkInRepository.save(record);
        log.info("Check-in successful for user: {} at station: {}", request.getUserId(), request.getStationId());
    }

    public LocalDateTime getCheckInTime(Long userId) {
        log.debug("Retrieving check-in time for user: {}", userId);
        return checkInRepository.findByUserId(userId)
                .map(CheckInRecord::getCheckInTime)
                .orElse(null);
    }

    public void removeCheckIn(Long userId) {
        log.info("Removing check-in record for user: {}", userId);
        checkInRepository.deleteByUserId(userId);
    }

    private boolean validateUser(CheckInRequest request) {
        log.debug("Validating user with id: {} and credential: {}", request.getUserId(), request.getCredential());
        // Add actual validation logic here (placeholder returns true)
        return true;
    }
}
