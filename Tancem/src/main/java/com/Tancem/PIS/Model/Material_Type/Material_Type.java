package com.Tancem.PIS.Model.Material_Type;

import com.Tancem.PIS.Material.Entity.Material;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;


@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Material_Type {

    @Id
    private int id;

    private String material_Type;

    private Timestamp created_At;

    private Timestamp updated_At;

    @OneToMany(mappedBy = "material_Type")
    private Set<Material> materials;






}
