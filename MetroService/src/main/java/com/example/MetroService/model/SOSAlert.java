package com.example.MetroService.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "sos_alerts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SOSAlert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String stationId;
    private String message;  // e.g., "Emergency! Assistance required immediately."
}
