package com.Tancem.PIS.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "problem")
public class Problem {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String problem;

    @ManyToOne
    @JoinColumn(name = "plant_department_id", nullable = false)
    private PlantDepartment plantDepartment;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Default constructor
    public Problem() {}

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
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

    public PlantDepartment getPlantDepartment() {
        return plantDepartment;
    }

    public void setPlantDepartment(PlantDepartment plantDepartment) {
        this.plantDepartment = plantDepartment;
    }
}
