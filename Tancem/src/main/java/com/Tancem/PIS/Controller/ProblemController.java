package com.Tancem.PIS.Controller;

import com.Tancem.PIS.Model.Problem;
import com.Tancem.PIS.Service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tancem/pis/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @GetMapping("/readall")
    public ResponseEntity<Map<String, Object>> getAllProblems() {
        List<Problem> problems = problemService.getAllProblems();
        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", HttpStatus.OK.value());
        response.put("statusMessage", "Success");
        response.put("data", problems);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Map<String, Object>> getProblemById(@PathVariable Integer id) {
        Problem problem = problemService.getProblemById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", HttpStatus.OK.value());
        response.put("statusMessage", "Success");
        response.put("data", problem);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createProblem(@RequestBody Problem problem) {
        Problem newProblem = problemService.saveProblem(problem);
        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", HttpStatus.CREATED.value());
        response.put("statusMessage", "Created");
        response.put("data", newProblem);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteProblem(@PathVariable Integer id) {
        problemService.deleteProblem(id);
        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", HttpStatus.NO_CONTENT.value());
        response.put("statusMessage", "Deleted");
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }
}