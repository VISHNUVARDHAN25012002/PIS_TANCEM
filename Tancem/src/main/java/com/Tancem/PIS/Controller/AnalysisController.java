package com.Tancem.PIS.Controller;

import com.Tancem.PIS.Model.Analysis;
import com.Tancem.PIS.Service.AnalysisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tancem/pis")
public class AnalysisController {

    @Autowired
    private AnalysisService analysisService;

    private static final Logger logger = LoggerFactory.getLogger(AnalysisController.class);

    @GetMapping

    public List<Analysis> getAllAnalyses() {
        logger.info("Fetching all analyses");
        List<Analysis> analyses = analysisService.getAllAnalyses();
        logger.info("Fetched {} analyses", analyses.size());
        return analyses;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Analysis> getAnalysisById(@PathVariable Integer id) {
        logger.info("Fetching analysis with id {}", id);
        Analysis analysis = analysisService.getAnalysisById(id);
        if (analysis != null) {
            logger.info("Found analysis with id {}", id);
            return new ResponseEntity<>(analysis, HttpStatus.OK);
        } else {
            logger.warn("Analysis with id {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createAnalysis(@RequestBody Analysis analysis) {
        logger.info("Creating new analysis with data: {}", analysis);
        Analysis savedAnalysis = analysisService.createAnalysis(analysis);
        logger.info("Analysis created successfully with id {}", savedAnalysis.getId());
        return new ResponseEntity<>("Analysis created successfully: " + savedAnalysis.toString(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Analysis> updateAnalysis(@PathVariable Integer id, @RequestBody Analysis analysis) {
        logger.info("Updating analysis with id {}", id);
        Analysis updatedAnalysis = analysisService.updateAnalysis(id, analysis);
        if (updatedAnalysis != null) {
            logger.info("Updated analysis with id {}", id);
            return new ResponseEntity<>(updatedAnalysis, HttpStatus.OK);
        } else {
            logger.warn("Failed to update analysis with id {}. Analysis not found.", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAnalysis(@PathVariable Integer id) {
        logger.info("Deleting analysis with id {}", id);
        try {
            analysisService.deleteAnalysis(id);
            logger.info("Analysis with id {} deleted successfully", id);
            return new ResponseEntity<>("Analysis deleted successfully", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            logger.error("Error deleting analysis with id {}: {}", id, e.getMessage());
            return new ResponseEntity<>("Failed to delete analysis", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
