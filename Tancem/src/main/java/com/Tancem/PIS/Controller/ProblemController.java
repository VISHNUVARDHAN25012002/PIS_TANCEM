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
        response.put("statusMessage", "Problem successfully created");
        response.put("data", newProblem);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateProblem(@PathVariable Integer id, @RequestBody Problem problem) {
        Problem existingProblem = problemService.getProblemById(id);
        Map<String, Object> response = new HashMap<>();
        if (existingProblem != null) {
            problem.setId(id); // Ensure the ID is set for the update
            Problem updatedProblem = problemService.saveProblem(problem);
            response.put("statusCode", HttpStatus.OK.value());
            response.put("statusMessage", "Problem successfully updated");
            response.put("data", updatedProblem);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("statusCode", HttpStatus.NOT_FOUND.value());
            response.put("statusMessage", "Problem not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteProblem(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        if (problemService.getProblemById(id) != null) {
            problemService.deleteProblem(id);
            response.put("statusCode", HttpStatus.NO_CONTENT.value());
            response.put("statusMessage", "Problem successfully deleted");
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        } else {
            response.put("statusCode", HttpStatus.NOT_FOUND.value());
            response.put("statusMessage", "Problem not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}