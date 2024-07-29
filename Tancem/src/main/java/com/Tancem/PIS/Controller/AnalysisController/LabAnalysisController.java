package com.Tancem.PIS.Controller.AnalysisController;

import com.Tancem.PIS.Model.AnalysisModel.LabAnalysis;
import com.Tancem.PIS.Service.AnalysisService.LabAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lab-analysis")
public class LabAnalysisController {

    @Autowired
    private LabAnalysisService labAnalysisService;

    @PostMapping
    public ResponseEntity<LabAnalysis> createLabAnalysis(@RequestBody LabAnalysis labAnalysis) {
        LabAnalysis savedLabAnalysis = labAnalysisService.saveLabAnalysis(labAnalysis);
        return ResponseEntity.ok(savedLabAnalysis);
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
}
