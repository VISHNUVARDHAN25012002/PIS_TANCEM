package com.Tancem.PIS.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class EquipmentGroup {

    @Id
    private Integer id;

    private String equipment_Group;

    private LocalDateTime created_At;

    private LocalDateTime updated_At;

    private Boolean isActive = true;

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

    @OneToMany(mappedBy = "equipmentGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private Set<Equipment> equipmentSet = new HashSet<>();

    public EquipmentGroup() {
    }

    public EquipmentGroup(Integer id, String equipment_Group, LocalDateTime created_At, LocalDateTime updated_At, Boolean isActive, Set<Equipment> equipmentSet) {
        this.id = id;
        this.equipment_Group = equipment_Group;
        this.created_At = created_At;
        this.updated_At = updated_At;
        this.isActive = isActive;
        this.equipmentSet = equipmentSet;
    }

    public EquipmentGroup(Integer id, String equipment_Group, LocalDateTime created_At, LocalDateTime updated_At, Set<Equipment> equipmentSet, boolean isActive) {

    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipment_Group() {
        return equipment_Group;
    }

    public void setEquipment_Group(String equipment_Group) {
        this.equipment_Group = equipment_Group;
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Set<Equipment> getEquipmentSet() {
        return equipmentSet;
    }

    public void setEquipmentSet(Set<Equipment> equipmentSet) {
        this.equipmentSet = equipmentSet;
    }
}