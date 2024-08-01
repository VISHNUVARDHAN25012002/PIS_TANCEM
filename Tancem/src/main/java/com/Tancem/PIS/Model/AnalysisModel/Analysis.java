package com.Tancem.PIS.Model.AnalysisModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "analysis")
@EntityListeners(AuditingEntityListener.class)
public class Analysis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String analysisType;
    private String description;

    @Column(name = "is_active", nullable = false)
    private boolean isActive = true; // Default to true

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    // Lombok will automatically generate the getters and setters if @Data is used
    // No need for a manual setIsActive method
}
