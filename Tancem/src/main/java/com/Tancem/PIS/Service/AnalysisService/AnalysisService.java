package com.Tancem.PIS.Service.AnalysisService;

import com.Tancem.PIS.Model.AnalysisModel.Analysis;

import java.util.List;

public interface AnalysisService {
    Analysis saveAnalysis(Analysis analysis);
    List<Analysis> getAllAnalyses();
    Analysis getAnalysisById(int id);
    Analysis updateAnalysis(Analysis analysis);
    void deleteAnalysis(int id);
}
