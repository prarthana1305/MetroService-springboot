package com.example.MetroService.controller;



import com.example.MetroService.model.CheckInRequest;
import com.example.MetroService.service.CheckInService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/checkin")

public class CheckInController {
    public CheckInController(CheckInService checkInService) {
        this.checkInService = checkInService;
    }

    private final CheckInService checkInService;

    @PostMapping
    public ResponseEntity<String> checkIn(@RequestBody CheckInRequest request) {
        checkInService.processCheckIn(request);
        return ResponseEntity.ok("Check-in successful");
    }
}

