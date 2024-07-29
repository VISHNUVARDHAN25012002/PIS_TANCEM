package com.Tancem.PIS.Model.Material;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Material {
    @Id

    private int id;

    private String material;
    private BigDecimal unitOfMeasure;
    private BigDecimal unitPrice;
    private LocalDateTime createdAt;
    private String glCode;

    @ManyToOne
    @JoinColumn(name = "source_id")
    private Source source;

    @ManyToOne
    @JoinColumn(name = "material_type_id")
    private Material_Type materialType;

    @ManyToOne
    @JoinColumn(name = "material_status_id")
    private Material_Status materialStatus;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public BigDecimal getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(BigDecimal unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getGlCode() {
        return glCode;
    }

    public void setGlCode(String glCode) {
        this.glCode = glCode;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Material_Type getMaterialType() {
        return materialType;
    }

    public void setMaterialType(Material_Type materialType) {
        this.materialType = materialType;
    }

    public Material_Status getMaterialStatus() {
        return materialStatus;
    }

    public void setMaterialStatus(Material_Status materialStatus) {
        this.materialStatus = materialStatus;
    }
}
