package com.example.MetroService.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class FareResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    // The ID of the user
    private Long userId;

    public FareResponseDTO(Long userId, double fareAmount, String message) {
        this.userId = userId;
        this.fareAmount = fareAmount;
        this.message = message;
    }

    public FareResponseDTO() {

    }

    // The total fare calculated
    private double fareAmount;
    // A message indicating the result (e.g., "Check-out successful")
    private String message;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public double getFareAmount() {
        return fareAmount;
    }

    public void setFareAmount(double fareAmount) {
        this.fareAmount = fareAmount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
