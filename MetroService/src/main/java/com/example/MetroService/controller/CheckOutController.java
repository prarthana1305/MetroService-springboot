package com.example.MetroService.controller;

import com.example.MetroService.dto.FareResponseDTO;
import com.example.MetroService.model.CheckOutRequest;
import com.example.MetroService.service.CheckOutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/checkout")

public class CheckOutController {
    public CheckOutController(CheckOutService checkOutService) {
        this.checkOutService = checkOutService;
    }

    private final CheckOutService checkOutService;

    @PostMapping
    public ResponseEntity<FareResponseDTO> checkOut(@RequestBody CheckOutRequest request) {
        FareResponseDTO fare = checkOutService.processCheckOut(request);
        return ResponseEntity.ok(fare);
    }
}
