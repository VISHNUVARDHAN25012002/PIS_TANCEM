package com.Tancem.PIS.Repository.AnalysisRepository;

import com.Tancem.PIS.Model.AnalysisModel.LabAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabAnalysisRepository extends JpaRepository<LabAnalysis, Integer> {
}
