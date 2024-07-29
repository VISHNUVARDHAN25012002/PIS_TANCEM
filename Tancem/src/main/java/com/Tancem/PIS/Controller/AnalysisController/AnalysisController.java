package com.Tancem.PIS.Controller.AnalysisController;

import com.Tancem.PIS.Model.AnalysisModel.Analysis;
import com.Tancem.PIS.Service.AnalysisService.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analysis")
public class AnalysisController {

    @Autowired
    private AnalysisService analysisService;

    @PostMapping
    public ResponseEntity<Analysis> createAnalysis(@RequestBody Analysis analysis) {
        Analysis savedAnalysis = analysisService.saveAnalysis(analysis);
        return ResponseEntity.ok(savedAnalysis);
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
}
