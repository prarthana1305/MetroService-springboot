package com.example.MetroService.model;

import java.time.LocalDateTime;

public class CheckOutRequest {
    private Long userId;
    private String stationId;
    private LocalDateTime checkOutTime;

    public Long getUserId() {
        return userId;
    }

    public CheckOutRequest(Long userId, String stationId, LocalDateTime checkOutTime) {
        this.userId = userId;
        this.stationId = stationId;
        this.checkOutTime = checkOutTime;
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

    public LocalDateTime getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalDateTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }
}
