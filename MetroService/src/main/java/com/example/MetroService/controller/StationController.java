package com.example.MetroService.controller;

import com.example.MetroService.dto.StationDTO;
import com.example.MetroService.service.StationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stations")

public class StationController {

    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping
    public ResponseEntity<List<StationDTO>> getActiveStations() {
        List<StationDTO> stations = stationService.getActiveStations();
        return ResponseEntity.ok(stations);
    }
}
