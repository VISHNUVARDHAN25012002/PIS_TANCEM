package com.Tancem.PIS.Controller.AnalysisController;

import com.Tancem.PIS.Model.AnalysisModel.LabAnalysis;

import com.Tancem.PIS.Service.AnalysisService.LabAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/lab-analysis")
public class LabAnalysisController {

    @Autowired
    private LabAnalysisService labAnalysisService;

    private static final Logger logger = LoggerFactory.getLogger(LabAnalysisController.class);

    @PostMapping
    public ResponseEntity<Map<String, Object>> createLabAnalysis(@RequestBody LabAnalysis labAnalysis) {
        Map<String, Object> response = new HashMap<>();
        try {
            LabAnalysis savedLabAnalysis = labAnalysisService.saveLabAnalysis(labAnalysis);
            response.put("status", HttpStatus.OK.value());
            response.put("message", "Lab Analysis created successfully");
            response.put("data", savedLabAnalysis);
        } catch (Exception e) {
            logger.error("Error creating Lab Analysis: {}", e.getMessage());
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.put("message", "Error creating Lab Analysis");
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<LabAnalysis>> getAllLabAnalyses() {
        List<LabAnalysis> labAnalyses = labAnalysisService.getAllLabAnalyses();
        return ResponseEntity.ok(labAnalyses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getLabAnalysisById(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();
        try {
            LabAnalysis labAnalysis = labAnalysisService.getLabAnalysisById(id);
            response.put("status", HttpStatus.OK.value());
            response.put("message", "Lab Analysis retrieved successfully");
            response.put("data", labAnalysis);
        } catch (Exception e) {
            logger.error("Error retrieving Lab Analysis with id {}: {}", id, e.getMessage());
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.put("message", "Error retrieving Lab Analysis");
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateLabAnalysis(@PathVariable int id, @RequestBody LabAnalysis labAnalysis) {
        Map<String, Object> response = new HashMap<>();
        try {
            labAnalysis.setId(id);
            LabAnalysis updatedLabAnalysis = labAnalysisService.updateLabAnalysis(labAnalysis);
            response.put("status", HttpStatus.OK.value());
            response.put("message", "Lab Analysis updated successfully");
            response.put("data", updatedLabAnalysis);
            logUserAction("update", id);
        } catch (Exception e) {
            logger.error("Error updating Lab Analysis with id {}: {}", id, e.getMessage());
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.put("message", "Error updating Lab Analysis");
        }
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteLabAnalysis(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();
        try {
            labAnalysisService.deleteLabAnalysis(id);
            response.put("status", HttpStatus.NO_CONTENT.value());
            response.put("message", "Lab Analysis deleted successfully");
            logUserAction("delete", id);
        } catch (Exception e) {
            logger.error("Error deleting Lab Analysis with id {}: {}", id, e.getMessage());
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.put("message", "Error deleting Lab Analysis");
        }
        return ResponseEntity.ok(response);
    }

    private void logUserAction(String action, int id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = (authentication != null) ? authentication.getName() : "Unknown User";
        logger.info("User '{}' performed '{}' on Lab Analysis with id {}", username, action, id);
    }
}
