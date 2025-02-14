package com.example.MetroService.controller;

import com.example.MetroService.model.SOSAlert;
import com.example.MetroService.service.SOSService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sos")

public class SOSController {

    private final SOSService sosService;

    public SOSController(SOSService sosService) {
        this.sosService = sosService;
    }

    @PostMapping
    public ResponseEntity<String> triggerSOS(@RequestBody SOSAlert alert) {
        sosService.processSOS(alert);
        return ResponseEntity.ok("SOS alert triggered");
    }
}

