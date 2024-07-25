package com.Tancem.PIS.Controller;

import com.Tancem.PIS.Model.Problem;
import com.Tancem.PIS.Service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tancem/pis/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @GetMapping("/readall")
    public ResponseEntity<List<Problem>> getAllProblems() {
        List<Problem> problems = problemService.getAllProblems();
        return new ResponseEntity<>(problems, HttpStatus.OK);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Problem> getProblemById(@PathVariable Integer id) {
        Problem problem = problemService.getProblemById(id);
        return new ResponseEntity<>(problem, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Problem> createProblem(@RequestBody Problem problem) {
        Problem newProblem = problemService.saveProblem(problem);
        return new ResponseEntity<>(newProblem, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProblem(@PathVariable Integer id) {
        problemService.deleteProblem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}