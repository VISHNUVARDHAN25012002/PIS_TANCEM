package com.Tancem.PIS.ServiceImpl.AnalysisServiceImpl;

import com.Tancem.PIS.Model.AnalysisModel.LabAnalysis;
import com.Tancem.PIS.Repository.AnalysisRepository.LabAnalysisRepository;
import com.Tancem.PIS.Service.AnalysisService.LabAnalysisService;
import com.Tancem.PIS.Service.logService.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabAnalysisServiceImpl implements LabAnalysisService {

    @Autowired
    private LabAnalysisRepository labAnalysisRepository;

    @Autowired
    private LogService logService;

    @Override
    public LabAnalysis saveLabAnalysis(LabAnalysis labAnalysis) {
        LabAnalysis savedLabAnalysis = labAnalysisRepository.save(labAnalysis);
        logService.logDbOperation("Saved Lab Analysis with ID: " + savedLabAnalysis.getId());
        return savedLabAnalysis;
    }

    @Override
    public List<LabAnalysis> getAllLabAnalyses() {
        List<LabAnalysis> labAnalyses = labAnalysisRepository.findAll();
        logService.logDbOperation("Fetched all Lab Analyses");
        return labAnalyses;
    }

    @Override
    public LabAnalysis getLabAnalysisById(int id) {
        LabAnalysis labAnalysis = labAnalysisRepository.findById(id).orElse(null);
        if (labAnalysis != null) {
            logService.logDbOperation("Fetched Lab Analysis with ID: " + id);
        } else {
            logService.logDbOperation("Lab Analysis with ID: " + id + " not found");
        }
        return labAnalysis;
    }

    @Override
    public LabAnalysis updateLabAnalysis(LabAnalysis labAnalysis) {
        LabAnalysis updatedLabAnalysis = labAnalysisRepository.save(labAnalysis);
        logService.logDbOperation("Updated Lab Analysis with ID: " + updatedLabAnalysis.getId());
        return updatedLabAnalysis;
    }

    @Override
    public void toggleActiveState(int id) {
        LabAnalysis labAnalysis = labAnalysisRepository.findById(id).orElseThrow(() -> new RuntimeException("Lab Analysis not found"));
        labAnalysis.setIsActive(!labAnalysis.isActive());
        labAnalysisRepository.save(labAnalysis);
        logService.logDbOperation("Toggled active state for Lab Analysis with ID: " + id);
    }
}
