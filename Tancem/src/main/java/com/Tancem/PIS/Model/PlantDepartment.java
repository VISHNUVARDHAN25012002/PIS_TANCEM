package com.Tancem.PIS.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "plant_department")
public class PlantDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Changed from int to Integer

    private String plantDepartmentDescription;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "plantDepartment", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Problem> problems;

    // Getters and Setters

    public PlantDepartment() {}

    public PlantDepartment(Integer id, String plantDepartmentDescription, LocalDateTime createdAt, LocalDateTime updatedAt, Set<Problem> problems) {
        this.id = id;
        this.plantDepartmentDescription = plantDepartmentDescription;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.problems = problems;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlantDepartmentDescription() {
        return plantDepartmentDescription;
    }

    public void setPlantDepartmentDescription(String plantDepartmentDescription) {
        this.plantDepartmentDescription = plantDepartmentDescription;
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

    public Set<Problem> getProblems() {
        return problems;
    }

    public void setProblems(Set<Problem> problems) {
        this.problems = problems;
    }
}
