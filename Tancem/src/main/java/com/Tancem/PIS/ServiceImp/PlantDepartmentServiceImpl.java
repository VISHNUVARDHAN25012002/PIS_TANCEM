package com.Tancem.PIS.ServiceImp;

import com.Tancem.PIS.DAO.PlantDepartmentRepository;
import com.Tancem.PIS.Model.PlantDepartment;
import com.Tancem.PIS.Service.PlantDepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PlantDepartmentServiceImpl implements PlantDepartmentService {
    private static final Logger logger = LoggerFactory.getLogger(PlantDepartmentServiceImpl.class);


    @Autowired
    private PlantDepartmentRepository plantDepartmentRepository;

    @Override
    public List<PlantDepartment> getAllPlantDepartments() {
        logger.info("Fetching all plant departments");
        return plantDepartmentRepository.findAll();
    }

    @Override
    public PlantDepartment getPlantDepartmentById(Integer id) {
        logger.info("Fetching plant department with id: {}", id);
        return plantDepartmentRepository.findById(id).orElse(null);
    }

    @Override
    public PlantDepartment savePlantDepartment(PlantDepartment plantDepartment) {
        if (plantDepartment.getId() == null) {
            plantDepartment.setCreatedAt(LocalDateTime.now());
        } else {
            plantDepartment.setUpdatedAt(LocalDateTime.now());
        }
        logger.info("Saving plant department: {}", plantDepartment);
        return plantDepartmentRepository.save(plantDepartment);
    }

    @Override
    public void deletePlantDepartment(Integer id) {
        logger.info("Deleting plant department with id: {}", id);
        plantDepartmentRepository.deleteById(id);
    }
}