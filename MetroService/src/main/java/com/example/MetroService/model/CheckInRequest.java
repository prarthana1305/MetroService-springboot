package com.example.MetroService.model;



public class CheckInRequest {
    private Long userId;
    private String credential;  // QR code or metro card number
    private String stationId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public CheckInRequest(Long userId, String credential, String stationId) {
        this.userId = userId;
        this.credential = credential;
        this.stationId = stationId;
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


}
