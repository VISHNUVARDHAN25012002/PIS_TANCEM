package com.Tancem.PIS.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "problem")
public class Problem {

    @Id
    private Integer id;

   // @Column(name = "problem", nullable = false, length = 45)
    private String problem;

    @ManyToOne
    @JoinColumn(name = "plant_department_id", nullable = false)
    @JsonBackReference
    private PlantDepartment plantDepartment;

    //@Column(name = "created_at", updatable = false)
    private LocalDateTime created_At;

   // @Column(name = "updated_at")
    private LocalDateTime updated_At;

    @PrePersist
    protected void onCreate() {
        created_At = LocalDateTime.now();
        updated_At = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        created_At = LocalDateTime.now();
        updated_At = LocalDateTime.now();
    }

    // Default constructor
    public Problem() {}

    public Problem(Integer id, String problem, PlantDepartment plantDepartment, LocalDateTime created_At, LocalDateTime updated_At) {
        this.id = id;
        this.problem = problem;
        this.plantDepartment = plantDepartment;
        this.created_At = created_At;
        this.updated_At = updated_At;
    }

    public Problem(String problem) {

    }

    // Constructor without id
    public Problem(String problem, PlantDepartment plantDepartment) {
        this.problem = problem;
        this.plantDepartment = plantDepartment;
    }

    // Getter and Setter methods
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

    public PlantDepartment getPlantDepartment() {
        return plantDepartment;
    }

    public void setPlantDepartment(PlantDepartment plantDepartment) {
        this.plantDepartment = plantDepartment;
    }
}
