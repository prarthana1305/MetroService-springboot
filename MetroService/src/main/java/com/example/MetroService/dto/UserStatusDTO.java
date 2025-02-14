package com.example.MetroService.dto;


import lombok.Data;

@Data
public class UserStatusDTO {
    public UserStatusDTO(Long userId, String checkInTime) {
        this.userId = userId;
        this.checkInTime = checkInTime;
    }

    public UserStatusDTO() {

    }

    // The ID of the user who is checked in
    private Long userId;
    // The check-in time as a formatted String
    private String checkInTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }
}
