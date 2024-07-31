package com.Tancem.PIS.Model.Material;


import com.Tancem.PIS.Model.Material_Type.Material_Type;
import com.Tancem.PIS.Model.Source.Source;
import com.Tancem.PIS.Model.Status.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Material {

    @Id

    private int id;

    private String material_Name;

    private String gl_Code;

    private Timestamp created_at;

    private Timestamp updated_at;

    @ManyToOne
    @JoinColumn(name = "source_id")
    private Source source;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "material_type_id")
    private Material_Type material_Type;


}
