package com.example.MetroService.service;

import com.example.MetroService.dto.StationDTO;
import com.example.MetroService.model.Station;
import com.example.MetroService.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StationService {

    private static final Logger log = LoggerFactory.getLogger(StationService.class);
    //
    private final StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public List<StationDTO> getActiveStations() {
        log.info("Fetching active stations from repository");
        List<Station> stations = stationRepository.findByActiveTrue();
        log.info("Retrieved {} active stations", stations.size());
        // Convert Station entities to StationDTOs
        List<StationDTO> stationDTOs = stations.stream().map(station -> {
            StationDTO dto = new StationDTO();
            dto.setId(station.getId());
            dto.setName(station.getName());
            dto.setActive(station.isActive());
            return dto;
        }).collect(Collectors.toList());
        return stationDTOs;
    }
}
