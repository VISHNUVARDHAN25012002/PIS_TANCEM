package com.Tancem.PIS.Controller.AnalysisController;

import com.Tancem.PIS.Model.AnalysisModel.Analysis;
import com.Tancem.PIS.Service.AnalysisService.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/analysis")
public class AnalysisController {

    @Autowired
    private AnalysisService analysisService;

    private static final Logger logger = LoggerFactory.getLogger(AnalysisController.class);

    @PostMapping
    public ResponseEntity<Map<String, Object>> createAnalysis(@RequestBody Analysis analysis) {
        Analysis savedAnalysis = analysisService.saveAnalysis(analysis);
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Analysis created successfully");
        response.put("data", savedAnalysis);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<Analysis>> getAllAnalyses() {
        List<Analysis> analyses = analysisService.getAllAnalyses();
        return ResponseEntity.ok(analyses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Analysis> getAnalysisById(@PathVariable int id) {
        Analysis analysis = analysisService.getAnalysisById(id);
        return ResponseEntity.ok(analysis);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateAnalysis(@PathVariable int id, @RequestBody Analysis analysis) {
        Map<String, Object> response = new HashMap<>();
        try {
            analysis.setId(id);
            Analysis updatedAnalysis = analysisService.updateAnalysis(analysis);
            response.put("status", HttpStatus.OK.value());
            response.put("message", "Analysis updated successfully");
            response.put("data", updatedAnalysis);
            logUserAction("update", id);
        } catch (Exception e) {
            logger.error("Error updating analysis with id {}: {}", id, e.getMessage());
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.put("message", "Error updating analysis");
        }
        return ResponseEntity.ok(response);
    }


    @PutMapping("/deactivate/{id}")
    public ResponseEntity<Map<String, Object>> deactivateAnalysis(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();
        try {
            logger.info("Deactivating analysis with ID: {}", id);
            analysisService.deactivateAnalysis(id);
            logger.info("Successfully deactivated analysis with ID: {}", id);

            response.put("status", HttpStatus.OK.value());
            response.put("message", "Analysis deactivated successfully");
            logUserAction("deactivate", id);
        } catch (Exception e) {
            logger.error("Error deactivating analysis with id {}: {}", id, e.getMessage());
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.put("message", "Error deactivating analysis: " + e.getMessage());
        }
        return ResponseEntity.ok(response);
    }

    private void logUserAction(String action, int id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = (authentication != null) ? authentication.getName() : "Unknown User";
        logger.info("User '{}' performed '{}' on analysis with id {}", username, action, id);
    }
}