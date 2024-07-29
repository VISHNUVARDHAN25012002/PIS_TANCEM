package com.Tancem.PIS.DAO;

import com.Tancem.PIS.Model.Analysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalysisRepository extends JpaRepository<Analysis, Integer> {

}