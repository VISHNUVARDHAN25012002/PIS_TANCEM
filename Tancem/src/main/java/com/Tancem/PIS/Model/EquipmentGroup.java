package com.Tancem.PIS.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
//@Table(name = "equipment_group")
public class EquipmentGroup {

    @Id
    private int id;

    //@Column(name = "equipment_group", nullable = false, length = 100)
    private String equipment_Group;

    //@Column(name = "created_at", updatable = false)
    private LocalDateTime created_At;

    //@Column(name = "updated_at")
    private LocalDateTime updated_At;

    @PrePersist
    protected void onCreate() {
        created_At = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updated_At = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "equipmentGroup", cascade = CascadeType.ALL)
    private Set<Equipment> equipmentSet;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipmentGroup() {
        return equipment_Group;
    }

    public void setEquipmentGroup(String equipmentGroup) {
        this.equipment_Group = equipmentGroup;
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
