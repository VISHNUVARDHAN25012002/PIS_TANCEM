package com.Tancem.PIS.Model.Status;

import com.Tancem.PIS.Material.Entity.Material;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Setter
@Getter

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Status {

    @Id
    private int id;
    private String status;
    private Timestamp created_At;
    private Timestamp updated_At;

    @OneToMany(mappedBy = "status")
    private Set<Material> materials;
}
