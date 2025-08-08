package com.cnrrs.cnrrs.controller;

import com.cnrrs.cnrrs.model.NoiseReport;
import com.cnrrs.cnrrs.service.NoiseReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class NoiseReportController {

    @Autowired
    private NoiseReportService service;

    @GetMapping("/")
    public String home(Model model) {
        List<NoiseReport> reports = service.getAllReports();
        model.addAttribute("reports", reports);
        return "index";
    }

    @GetMapping("/report")
    public String reportForm(Model model) {
        model.addAttribute("noiseReport", new NoiseReport());
        return "report";
    }

    @PostMapping("/submit")
    public String submitReport(@ModelAttribute NoiseReport noiseReport) {
        noiseReport.setReportTime(LocalDateTime.now());
        service.saveReport(noiseReport);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteReport(@PathVariable("id") Long id) {
        service.deleteReportById(id);
        return "redirect:/";
    }
    
}
