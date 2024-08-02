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

    private boolean isActive = true;

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

    public SubEquipment(int id, String sub_Equipment_Description, LocalDateTime created_At, LocalDateTime updated_At, boolean isActive, Equipment equipment) {
        this.id = id;
        this.sub_Equipment_Description = sub_Equipment_Description;
        this.created_At = created_At;
        this.updated_At = updated_At;
        this.isActive = isActive;
        this.equipment = equipment;
    }

    public SubEquipment(int id, String sub_Equipment_Description, LocalDateTime created_At, LocalDateTime updated_At, Equipment equipment, boolean isActive) {

    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSub_Equipment_Description() {
        return sub_Equipment_Description;
    }

    public void setSub_Equipment_Description(String sub_Equipment_Description) {
        this.sub_Equipment_Description = sub_Equipment_Description;
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

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}

