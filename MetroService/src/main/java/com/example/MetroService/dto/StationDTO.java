package com.example.MetroService.dto;


import lombok.Data;

@Data
public class StationDTO {
    // The unique station ID
    private String id;

    public StationDTO(String id, String name, boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }
    public StationDTO() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // The name of the station
    private String name;
    // Whether the station is active
    private boolean active;
}
