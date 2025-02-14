package com.example.MetroService.repository;



import com.example.MetroService.model.CheckInRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CheckInRepository extends JpaRepository<CheckInRecord, Long> {
    Optional<CheckInRecord> findByUserId(Long userId);

    void deleteByUserId(Long userId);
}
