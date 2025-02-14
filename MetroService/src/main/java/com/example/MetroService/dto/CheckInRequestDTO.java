package com.example.MetroService.dto;


import lombok.Data;

@Data
public class CheckInRequestDTO {
    public CheckInRequestDTO(Long userId, String credential, String stationId) {
        this.userId = userId;
        this.credential = credential;
        this.stationId = stationId;
    }

    public CheckInRequestDTO() {

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    // The ID of the user checking in (provided by the client)
    private Long userId;
    // The credential (e.g., QR code or metro card number)
    private String credential;
    // The station ID where the user is checking in
    private String stationId;
}

