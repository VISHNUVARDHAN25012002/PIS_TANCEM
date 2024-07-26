package com.Tancem.PIS.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Equipment {

    @Id

    private Integer id;

    private String equipment_Description;

    private LocalDateTime created_At;

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
    @JsonBackReference
    private EquipmentGroup equipmentGroup;

    @OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SubEquipment> subEquipments = new HashSet<>();

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

    public EquipmentGroup getEquipmentGroup() {
        return equipmentGroup;
    }

    public void setEquipmentGroup(EquipmentGroup equipmentGroup) {
        this.equipmentGroup = equipmentGroup;
    }

    public Set<SubEquipment> getSubEquipments() {
        return subEquipments;
    }

    public void setSubEquipments(Set<SubEquipment> subEquipments) {
        this.subEquipments = subEquipments;
    }
}
