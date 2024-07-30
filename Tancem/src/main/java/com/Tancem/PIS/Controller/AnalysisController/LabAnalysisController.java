package com.Tancem.PIS.Controller.AnalysisController;

import com.Tancem.PIS.Model.AnalysisModel.LabAnalysis;
import com.Tancem.PIS.Service.AnalysisService.AnalysisService;
import com.Tancem.PIS.Service.AnalysisService.LabAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/lab-analysis")
public class LabAnalysisController {

    @Autowired
    private LabAnalysisService labAnalysisService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createLabAnalysis(@RequestBody LabAnalysis labAnalysis) {
        LabAnalysis savedLabAnalysis = labAnalysisService.saveLabAnalysis(labAnalysis);
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Lab Analysis created successfully");
        response.put("data", savedLabAnalysis);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<LabAnalysis>> getAllLabAnalyses() {
        List<LabAnalysis> labAnalyses = labAnalysisService.getAllLabAnalyses();
        return ResponseEntity.ok(labAnalyses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LabAnalysis> getLabAnalysisById(@PathVariable int id) {
        LabAnalysis labAnalysis = labAnalysisService.getLabAnalysisById(id);
        return ResponseEntity.ok(labAnalysis);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateLabAnalysis(@PathVariable int id, @RequestBody LabAnalysis labAnalysis) {
        labAnalysis.setId(id);
        LabAnalysis updatedLabAnalysis = labAnalysisService.updateLabAnalysis(labAnalysis);
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Lab Analysis updated successfully");
        response.put("data", updatedLabAnalysis);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteLabAnalysis(@PathVariable int id) {
        labAnalysisService.deleteLabAnalysis(id);
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.NO_CONTENT.value());
        response.put("message", "Lab Analysis deleted successfully");
        return ResponseEntity.ok(response);
    }
}
