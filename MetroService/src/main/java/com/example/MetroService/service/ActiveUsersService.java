package com.example.MetroService.service;

import com.example.MetroService.dto.UserStatusDTO;
import com.example.MetroService.model.CheckInRecord;
import com.example.MetroService.repository.CheckInRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ActiveUsersService {

    private static final Logger log = LoggerFactory.getLogger(ActiveUsersService.class);

    private final CheckInRepository checkInRepository;

    public ActiveUsersService(CheckInRepository checkInRepository) {
        this.checkInRepository = checkInRepository;
    }

    public List<UserStatusDTO> getActiveUsers() {
        log.info("Retrieving active check-in records.");
        List<CheckInRecord> activeCheckIns = checkInRepository.findAll();
        log.info("Found {} active check-ins.", activeCheckIns.size());

        List<UserStatusDTO> userStatuses = activeCheckIns.stream()
                .map(record -> {
                    UserStatusDTO dto = new UserStatusDTO();
                    dto.setUserId(record.getUserId());
                    dto.setCheckInTime(record.getCheckInTime().toString());
                    return dto;
                })
                .collect(Collectors.toList());

        log.debug("Active user statuses: {}", userStatuses);
        return userStatuses;
    }
}
