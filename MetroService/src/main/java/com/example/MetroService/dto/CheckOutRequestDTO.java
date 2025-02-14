package com.example.MetroService.dto;


import lombok.Data;

@Data
public class CheckOutRequestDTO {
    // The ID of the user checking out (provided by the client)
    private Long userId;

    public CheckOutRequestDTO(Long userId, String stationId) {
        this.userId = userId;
        this.stationId = stationId;
    }
    public CheckOutRequestDTO() {

    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    // The station ID where the user is checking out
    private String stationId;
}

