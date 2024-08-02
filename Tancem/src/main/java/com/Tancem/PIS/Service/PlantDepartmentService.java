package com.Tancem.PIS.Service;

import com.Tancem.PIS.Model.PlantDepartment;

import java.util.List;

public interface PlantDepartmentService {
    List<PlantDepartment> getAllPlantDepartments();
    PlantDepartment getPlantDepartmentById(Integer id);
    PlantDepartment savePlantDepartment(PlantDepartment plantDepartment);
    void deactivatePlantDepartment(Integer id);
    void activatePlantDepartment(Integer id);
}
