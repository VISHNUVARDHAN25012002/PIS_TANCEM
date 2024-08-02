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

    private boolean isActive = true;

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

    public PlantDepartment() {
    }

    public PlantDepartment(int id, String plant_Department_Description, LocalDateTime created_At, LocalDateTime updated_At, boolean isActive, Set<Problem> problems) {
        this.id = id;
        this.plant_Department_Description = plant_Department_Description;
        this.created_At = created_At;
        this.updated_At = updated_At;
        this.isActive = isActive;
        this.problems = problems;
    }

    public PlantDepartment(int id, String plant_Department_Description, LocalDateTime created_At, LocalDateTime updated_At, Set<Problem> problems, boolean isActive) {

    }

    public PlantDepartment(String plant_Department_Description) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlant_Department_Description() {
        return plant_Department_Description;
    }

    public void setPlant_Department_Description(String plant_Department_Description) {
        this.plant_Department_Description = plant_Department_Description;
    }

    public LocalDateTime getCreated_At() {
        return created_At;
    }

    public void setCreated_At(LocalDateTime created_At) {
        this.created_At = created_At;
    }

    public LocalDateTime getUpdated_At() {
        return updated_At;
    }

    public void setUpdated_At(LocalDateTime updated_At) {
        this.updated_At = updated_At;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Set<Problem> getProblems() {
        return problems;
    }

    public void setProblems(Set<Problem> problems) {
        this.problems = problems;
    }
}
