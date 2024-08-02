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

    private boolean isActive = true;

    @PrePersist
    protected void onCreate() {
        created_At = LocalDateTime.now();
        updated_At = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updated_At = LocalDateTime.now();
        created_At = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "equipment_group_id", nullable = false)
    @JsonBackReference
    private EquipmentGroup equipmentGroup;

    @OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SubEquipment> subEquipments = new HashSet<>();

    // Getters and Setters

    public Equipment() {
    }

    public Equipment(Integer id, String equipment_Description, LocalDateTime created_At, LocalDateTime updated_At, boolean isActive, EquipmentGroup equipmentGroup, Set<SubEquipment> subEquipments) {
        this.id = id;
        this.equipment_Description = equipment_Description;
        this.created_At = created_At;
        this.updated_At = updated_At;
        this.isActive = isActive;
        this.equipmentGroup = equipmentGroup;
        this.subEquipments = subEquipments;
    }

    public Equipment(Integer id, String equipment_Description, LocalDateTime created_At, LocalDateTime updated_At, boolean isActive) {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipment_Description() {
        return equipment_Description;
    }

    public void setEquipment_Description(String equipment_Description) {
        this.equipment_Description = equipment_Description;
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