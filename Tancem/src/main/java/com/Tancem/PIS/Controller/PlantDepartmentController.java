package com.Tancem.PIS.Controller;


import com.Tancem.PIS.Model.PlantDepartment;
import com.Tancem.PIS.Service.PlantDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tancem/pis/plant_department")
public class PlantDepartmentController {

    @Autowired
    private PlantDepartmentService plantDepartmentService;

    @GetMapping("/readall")
    public ResponseEntity<List<PlantDepartment>> getAllPlantDepartments() {
        List<PlantDepartment> plantDepartments = plantDepartmentService.getAllPlantDepartments();
        return new ResponseEntity<>(plantDepartments, HttpStatus.OK);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<PlantDepartment> getPlantDepartmentById(@PathVariable Integer id) {
        PlantDepartment plantDepartment = plantDepartmentService.getPlantDepartmentById(id);
        return new ResponseEntity<>(plantDepartment, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<PlantDepartment> createPlantDepartment(@RequestBody PlantDepartment plantDepartment) {
        PlantDepartment newPlantDepartment = plantDepartmentService.savePlantDepartment(plantDepartment);
        return new ResponseEntity<>(newPlantDepartment, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePlantDepartment(@PathVariable Integer id) {
        plantDepartmentService.deletePlantDepartment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}