package com.Tancem.PIS.ServiceImp.AnalysisServiceImpl;

import com.Tancem.PIS.Model.AnalysisModel.LabAnalysis;
import com.Tancem.PIS.Repository.AnalysisRepository.LabAnalysisRepository;
import com.Tancem.PIS.Service.AnalysisService.AnalysisService;
import com.Tancem.PIS.Service.AnalysisService.LabAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabAnalysisServiceImpl implements LabAnalysisService {

    @Autowired
    private LabAnalysisRepository labAnalysisRepository;

    @Override
    public LabAnalysis saveLabAnalysis(LabAnalysis labAnalysis) {
        return labAnalysisRepository.save(labAnalysis);
    }

    @Override
    public List<LabAnalysis> getAllLabAnalyses() {
        return labAnalysisRepository.findAll();
    }

    @Override
    public LabAnalysis getLabAnalysisById(int id) {
        return labAnalysisRepository.findById(id).orElse(null);
    }

    @Override
    public LabAnalysis updateLabAnalysis(LabAnalysis labAnalysis) {
        return labAnalysisRepository.save(labAnalysis);
    }

    @Override
    public void deleteLabAnalysis(int id) {
        labAnalysisRepository.deleteById(id);
    }
}