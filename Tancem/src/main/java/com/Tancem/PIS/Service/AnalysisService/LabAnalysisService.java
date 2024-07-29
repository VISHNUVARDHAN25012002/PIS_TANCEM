package com.Tancem.PIS.Service.AnalysisService;

import com.Tancem.PIS.Model.AnalysisModel.LabAnalysis;

import java.util.List;

public interface LabAnalysisService {
    LabAnalysis saveLabAnalysis(LabAnalysis labAnalysis);
    List<LabAnalysis> getAllLabAnalyses();
    LabAnalysis getLabAnalysisById(int id);
}
