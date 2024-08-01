package com.Tancem.PIS.Service;
import com.Tancem.PIS.Model.Problem;
import java.util.List;
public interface ProblemService {
    List<Problem> getAllProblems();
    Problem getProblemById(Integer id);
    Problem saveProblem(Problem problem);
    void deleteProblem(Integer id);
}
