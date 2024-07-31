package com.Tancem.PIS.Model.BagsType;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class BagsType {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Bag type is required.")
    private String types_Of_Bags;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp created_At;


    @LastModifiedDate
    @Column(name = "updated_at")
    private Timestamp updated_At;

    // Getters and Setters
}
