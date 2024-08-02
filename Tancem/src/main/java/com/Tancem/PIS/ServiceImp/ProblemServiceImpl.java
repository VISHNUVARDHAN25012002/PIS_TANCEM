package com.Tancem.PIS.ServiceImp;

import com.Tancem.PIS.DAO.ProblemRepository;
import com.Tancem.PIS.Model.Problem;
import com.Tancem.PIS.Service.ProblemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemServiceImpl implements ProblemService {
    private static final Logger logger = LoggerFactory.getLogger(ProblemServiceImpl.class);

    @Autowired
    private ProblemRepository problemRepository;

    @Override
    public List<Problem> getAllProblems() {
        logger.info("Fetching all problems");
        return problemRepository.findAll();
    }

    @Override
    public Problem getProblemById(Integer id) {
        logger.info("Fetching problem with id: {}", id);
        return problemRepository.findById(id).orElse(null);
    }

    @Override
    public Problem saveProblem(Problem problem) {
        logger.info("Saving problem: {}", problem);
        return problemRepository.save(problem);
    }

    @Override
    public void deactivateProblem(Integer id) {
        logger.info("Deactivating problem with id: {}", id);
        Problem problem = problemRepository.findById(id).orElse(null);
        if (problem != null) {
            problem.setActive(false);
            saveProblem(problem);
        } else {
            logger.warn("Problem with id: {} not found for deactivation", id);
        }
    }

    @Override
    public void activateProblem(Integer id) {
        logger.info("Activating problem with id: {}", id);
        Problem problem = problemRepository.findById(id).orElse(null);
        if (problem != null) {
            problem.setActive(true);
            saveProblem(problem);
        } else {
            logger.warn("Problem with id: {} not found for activation", id);
        }
    }
}