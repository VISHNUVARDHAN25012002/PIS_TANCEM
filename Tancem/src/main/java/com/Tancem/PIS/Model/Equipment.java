package com.Tancem.PIS.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Table(name = "equipment")
public class Equipment {

    @Id
    private int id;

   // @Column(name = "equipment_description", nullable = false, length = 100)
    private String equipment_Description;

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
        updated_At = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "equipment_group_id", nullable = false)
    private EquipmentGroup equipmentGroup;

    @OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL)
    private Set<SubEquipment> subEquipments;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipmentDescription() {
        return equipment_Description;
    }

    public void setEquipmentDescription(String equipmentDescription) {
        this.equipment_Description = equipmentDescription;
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
}
