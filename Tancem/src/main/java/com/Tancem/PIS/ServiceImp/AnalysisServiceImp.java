package com.Tancem.PIS.ServiceImp;

import com.Tancem.PIS.DAO.AnalysisRepository;
import com.Tancem.PIS.Model.Analysis;
import com.Tancem.PIS.Service.AnalysisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnalysisServiceImp implements AnalysisService {

    @Autowired
    public AnalysisRepository analysisRepository;

    private static final Logger logger = LoggerFactory.getLogger(AnalysisServiceImp.class);

    @Override
    public List<Analysis> getAllAnalyses() {
        logger.info("Fetching all analyses");
        List<Analysis> analyses = analysisRepository.findAll();
        logger.info("Fetched {} analyses", analyses.size());
        return analyses;
    }

    @Override
    public Analysis getAnalysisById(Integer id) {
        logger.info("Fetching analysis with id {}", id);
        Optional<Analysis> analysis = analysisRepository.findById(id);
        if (analysis.isPresent()) {
            logger.info("Found analysis with id {}", id);
            return analysis.get();
        } else {
            logger.warn("Analysis not found with id {}", id);
            throw new RuntimeException("Analysis not found with id: " + id);
        }
    }

    @Override
    public Analysis createAnalysis(Analysis analysis) {
        logger.info("Creating new analysis: {}", analysis);
        Analysis savedAnalysis = analysisRepository.save(analysis);
        logger.info("Created analysis with id {}", savedAnalysis.getId());
        return savedAnalysis;
    }

    @Override
    public Analysis updateAnalysis(Integer id, Analysis analysis) {
        logger.info("Updating analysis with id {}", id);
        if (!analysisRepository.existsById(id)) {
            logger.warn("Analysis not found with id {}", id);
            throw new RuntimeException("Analysis not found with id: " + id);
        }
        analysis.setId(id);
        Analysis updatedAnalysis = analysisRepository.save(analysis);
        logger.info("Updated analysis with id {}", id);
        return updatedAnalysis;
    }

    @Override
    public void deleteAnalysis(Integer id) {
        logger.info("Deleting analysis with id {}", id);
        if (!analysisRepository.existsById(id)) {
            logger.warn("Analysis not found with id {}", id);
            throw new RuntimeException("Analysis not found with id: " + id);
        }
        analysisRepository.deleteById(id);
        logger.info("Deleted analysis with id {}", id);
    }
}
