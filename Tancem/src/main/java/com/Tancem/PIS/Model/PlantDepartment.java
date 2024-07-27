package com.Tancem.PIS.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "plant_department")
public class PlantDepartment {

    @Id
    private int id;

    //@Column(name = "plant_department_description", nullable = false, length = 100)
    private String plant_Department_Description;

    //@Column(name = "created_at", updatable = false)
    private LocalDateTime created_At;

    //@Column(name = "updated_at")
    private LocalDateTime updated_At;

    @PrePersist
    protected void onCreate() {
        updated_At = LocalDateTime.now();
        created_At = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        created_At = LocalDateTime.now();
        updated_At = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "plantDepartment", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Problem> problems;

    // Getters and Setters

    public PlantDepartment() {}

    public PlantDepartment(int id, String plant_Department_Description, LocalDateTime created_At, LocalDateTime updated_At, Set<Problem> problems) {
        this.id = id;
        this.plant_Department_Description = plant_Department_Description;
        this.created_At = created_At;
        this.updated_At = updated_At;
        this.problems = problems;
    }

    public PlantDepartment(String plant_Department_Description) {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlantDepartmentDescription() {
        return plant_Department_Description;
    }

    public void setPlantDepartmentDescription(String plantDepartmentDescription) {
        this.plant_Department_Description = plantDepartmentDescription;
    }

    public LocalDateTime getCreatedAt() {
        return created_At;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.created_At = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updated_At;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updated_At = updatedAt;
    }

    public Set<Problem> getProblems() {
        return problems;
    }

    public void setProblems(Set<Problem> problems) {
        this.problems = problems;
    }
}


