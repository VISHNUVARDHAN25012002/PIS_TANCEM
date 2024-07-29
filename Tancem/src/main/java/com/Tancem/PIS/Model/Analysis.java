package com.Tancem.PIS.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
//@Table(name = "analyses")
public class Analysis {

    @Id

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @Column(name = "analysis_type", nullable = false)
    private String analysisType;

//    @Column(name = "description")
    private String description;

//    @Column(name = "created_At", updatable = false)
    private LocalDateTime createdAt;

//    @Column(name = "updated_At")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnalysisType() {
        return analysisType;
    }

    public void setAnalysisType(String analysisType) {
        this.analysisType = analysisType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Analysis{" +
                "id=" + id +
                ", analysisType='" + analysisType + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
        }
}


