package com.Tancem.PIS.Model.AnalysisModel;


import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "lab_analysis")
public class LabAnalysis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "transaction_date")
    private Timestamp transactionDate;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name = "analysis_id", referencedColumnName = "id")
    private Analysis analysis;

    // Getters and Setters
}
