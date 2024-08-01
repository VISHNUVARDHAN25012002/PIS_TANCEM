package com.Tancem.PIS.ServiceImpl.AnalysisServiceImpl;

import com.Tancem.PIS.Model.AnalysisModel.Analysis;
import com.Tancem.PIS.Repository.AnalysisRepository.AnalysisRepository;
import com.Tancem.PIS.Service.AnalysisService.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return analysisRepository.findAll(); // You may want to filter for active analyses here
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
    public void deactivateAnalysis(int id) {
        Optional<Analysis> analysisOpt = analysisRepository.findById(id);
        if (analysisOpt.isPresent()) {
            Analysis analysis = analysisOpt.get();
            analysis.setActive(false);  // Correct method call
            analysisRepository.save(analysis);
        }
    }

}

