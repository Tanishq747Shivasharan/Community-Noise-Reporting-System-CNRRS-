package com.cnrrs.cnrrs.repository;

import com.cnrrs.cnrrs.model.NoiseReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoiseReportRepository extends JpaRepository<NoiseReport, Long> {
    List<NoiseReport> findByCategory(String category);
}

