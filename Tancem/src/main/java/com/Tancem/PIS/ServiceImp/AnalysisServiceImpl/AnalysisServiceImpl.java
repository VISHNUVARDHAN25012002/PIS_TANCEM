package com.Tancem.PIS.ServiceImp.AnalysisServiceImpl;

import com.Tancem.PIS.Model.AnalysisModel.Analysis;
import com.Tancem.PIS.Repository.AnalysisRepository.AnalysisRepository;
import com.Tancem.PIS.Service.AnalysisService.AnalysisService;
import com.Tancem.PIS.Service.AnalysisService.LabAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnalysisServiceImpl implements AnalysisService {

    @Autowired
    private AnalysisRepository analysisRepository;

    @Override
    public Analysis saveAnalysis(Analysis analysis) {
        return analysisRepository.save(analysis);
    }

    @Override
    public List<Analysis> getAllAnalyses() {
        return analysisRepository.findAll();
    }

    @Override
    public Analysis getAnalysisById(int id) {
        return analysisRepository.findById(id).orElse(null);
    }

    @Override
    public Analysis updateAnalysis(Analysis analysis) {
        return analysisRepository.save(analysis);
    }

    @Override
    public void deleteAnalysis(int id) {
        analysisRepository.deleteById(id);
    }
}