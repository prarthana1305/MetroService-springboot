package com.example.MetroService.util;


import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

public class FareCalculator implements Serializable {

    public static double calculate(LocalDateTime checkInTime, LocalDateTime checkOutTime) {
        if (checkInTime == null) {
            throw new IllegalStateException("Check-in time is null");
        }
        long minutes = Duration.between(checkInTime, checkOutTime).toMinutes();
        double baseFare = 10.0;
        double additionalFare = minutes * 0.5; // 50 cents per minute
        return baseFare + additionalFare;
    }
}
