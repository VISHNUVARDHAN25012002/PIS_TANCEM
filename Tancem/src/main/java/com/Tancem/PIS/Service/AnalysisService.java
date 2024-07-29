package com.Tancem.PIS.Service;

import com.Tancem.PIS.Model.Analysis;

import java.util.List;

public interface AnalysisService {

    List<Analysis> getAllAnalyses();
    Analysis getAnalysisById(Integer id);
    Analysis createAnalysis(Analysis analysis);
    Analysis updateAnalysis(Integer id, Analysis analysis);
    void deleteAnalysis(Integer id);
}
