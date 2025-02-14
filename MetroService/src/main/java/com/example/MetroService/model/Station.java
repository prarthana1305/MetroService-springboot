package com.example.MetroService.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "stations")
@Data

public class Station {
    public Station(String id, String name, boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }

    public Station() {

    }

    @Id
    private String id;
    private String name;
    private boolean active;  // true if the station is active

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
}
