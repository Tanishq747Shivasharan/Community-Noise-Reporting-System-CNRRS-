package com.cnrrs.cnrrs.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class NoiseReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reporterName;
    private String category; // "Traffic", "Loud Music", etc.
    private String location;
    private LocalDateTime reportTime;

    @Column(length = 1000)
    private String description;

    private int upvotes;
    private boolean escalatedToAdmin;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getReporterName() { return reporterName; }
    public void setReporterName(String reporterName) { this.reporterName = reporterName; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public LocalDateTime getReportTime() { return reportTime; }
    public void setReportTime(LocalDateTime reportTime) { this.reportTime = reportTime; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getUpvotes() { return upvotes; }
    public void setUpvotes(int upvotes) { this.upvotes = upvotes; }

    public boolean isEscalatedToAdmin() { return escalatedToAdmin; }
    public void setEscalatedToAdmin(boolean escalatedToAdmin) { this.escalatedToAdmin = escalatedToAdmin; }
}
