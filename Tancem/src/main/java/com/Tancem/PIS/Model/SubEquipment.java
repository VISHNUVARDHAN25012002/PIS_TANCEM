package com.Tancem.PIS.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sub_equipment")
public class SubEquipment {

    @Id
    private int id;

   // @Column(name = "sub_equipment_description", nullable = false, length = 100)
    private String sub_Equipment_Description;

   // @Column(name = "created_at", updatable = false)
    private LocalDateTime created_At;

   // @Column(name = "updated_at")
    private LocalDateTime updated_At;

    @ManyToOne
    @JoinColumn(name = "equipment_id", nullable = false)
    @JsonBackReference
    private Equipment equipment;


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

    public SubEquipment() {}

    public SubEquipment(int id, String sub_Equipment_Description, LocalDateTime created_At, LocalDateTime updated_At, Equipment equipment) {
        this.id = id;
        this.sub_Equipment_Description = sub_Equipment_Description;
        this.created_At = created_At;
        this.updated_At = updated_At;
        this.equipment = equipment;
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubEquipmentDescription() {
        return sub_Equipment_Description;
    }

    public void setSubEquipmentDescription(String subEquipmentDescription) {
        this.sub_Equipment_Description = subEquipmentDescription;
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

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}

