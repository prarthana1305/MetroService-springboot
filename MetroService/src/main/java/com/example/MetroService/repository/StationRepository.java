package com.example.MetroService.repository;


import com.example.MetroService.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StationRepository extends JpaRepository<Station, String> {
    List<Station> findByActiveTrue();
}
