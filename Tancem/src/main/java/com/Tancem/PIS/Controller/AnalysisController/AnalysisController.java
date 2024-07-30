package com.Tancem.PIS.Controller.AnalysisController;

import com.Tancem.PIS.Model.AnalysisModel.Analysis;
import com.Tancem.PIS.Service.AnalysisService.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/analysis")
public class AnalysisController {

    @Autowired
    private AnalysisService analysisService;

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
        analysis.setId(id);
        Analysis updatedAnalysis = analysisService.updateAnalysis(analysis);
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Analysis updated successfully");
        response.put("data", updatedAnalysis);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteAnalysis(@PathVariable int id) {
        analysisService.deleteAnalysis(id);
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.NO_CONTENT.value());
        response.put("message", "Analysis deleted successfully");
        return ResponseEntity.ok(response);
    }
}
