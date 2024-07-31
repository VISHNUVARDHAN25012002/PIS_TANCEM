package com.Tancem.PIS.Repository.AnalysisRepository;

import com.Tancem.PIS.Model.AnalysisModel.Analysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalysisRepository extends JpaRepository<Analysis, Integer> {
}
