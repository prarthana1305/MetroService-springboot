package com.example.MetroService.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class UserStatus {
    private Long userId;
    private String checkInTime;
    public UserStatus(Long userId, String checkInTime) {
        this.userId = userId;
        this.checkInTime = checkInTime;
    }
    public UserStatus() {

    }
    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }




}
