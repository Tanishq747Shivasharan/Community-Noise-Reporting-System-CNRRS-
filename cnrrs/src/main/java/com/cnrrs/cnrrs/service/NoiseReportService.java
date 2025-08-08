package com.cnrrs.cnrrs.service;

import com.cnrrs.cnrrs.model.NoiseReport;
import com.cnrrs.cnrrs.repository.NoiseReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoiseReportService {

    @Autowired
    private NoiseReportRepository repository;

    public List<NoiseReport> getAllReports() {
        return repository.findAll();
    }

    public NoiseReport saveReport(NoiseReport report) {
        return repository.save(report);
    }

    public List<NoiseReport> getByCategory(String category) {
        return repository.findByCategory(category);
    }

    public void deleteReportById(Long id) {
        repository.deleteById(id);
    }

}
