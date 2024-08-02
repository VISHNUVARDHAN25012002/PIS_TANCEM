package com.Tancem.PIS.Controller;


import com.Tancem.PIS.Model.PlantDepartment;
import com.Tancem.PIS.Service.PlantDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tancem/pis/plant_department")
public class PlantDepartmentController {

    @Autowired
    private PlantDepartmentService plantDepartmentService;

    @GetMapping("/readall")
    public ResponseEntity<Map<String, Object>> getAllPlantDepartments() {
        List<PlantDepartment> plantDepartments = plantDepartmentService.getAllPlantDepartments();
        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", HttpStatus.OK.value());
        response.put("statusMessage", "Successfully retrieved all plant departments");
        response.put("data", plantDepartments);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Map<String, Object>> getPlantDepartmentById(@PathVariable Integer id) {
        PlantDepartment plantDepartment = plantDepartmentService.getPlantDepartmentById(id);
        Map<String, Object> response = new HashMap<>();
        if (plantDepartment != null) {
            response.put("statusCode", HttpStatus.OK.value());
            response.put("statusMessage", "Successfully retrieved plant department");
            response.put("data", plantDepartment);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("statusCode", HttpStatus.NOT_FOUND.value());
            response.put("statusMessage", "Plant department not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createPlantDepartment(@RequestBody PlantDepartment plantDepartment) {
        PlantDepartment newPlantDepartment = plantDepartmentService.savePlantDepartment(plantDepartment);
        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", HttpStatus.CREATED.value());
        response.put("statusMessage", "Plant department successfully created");
        response.put("data", newPlantDepartment);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updatePlantDepartment(@PathVariable Integer id, @RequestBody PlantDepartment plantDepartment) {
        Map<String, Object> response = new HashMap<>();
        PlantDepartment existingPlantDepartment = plantDepartmentService.getPlantDepartmentById(id);
        if (existingPlantDepartment != null) {
            plantDepartment.setId(id);
            // Handle activation/deactivation based on the provided data
            if (plantDepartment.isActive()==false) {
                plantDepartment.setActive(true);  // Mark as active
            } else {
                plantDepartment.setActive(false); // Mark as inactive
            }
            PlantDepartment updatedPlantDepartment = plantDepartmentService.savePlantDepartment(plantDepartment);
            response.put("statusCode", HttpStatus.OK.value());
            response.put("statusMessage", "Plant department successfully updated");
            response.put("data", updatedPlantDepartment);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("statusCode", HttpStatus.NOT_FOUND.value());
            response.put("statusMessage", "Plant department not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}