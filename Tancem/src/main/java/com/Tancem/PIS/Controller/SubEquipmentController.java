package com.Tancem.PIS.Controller;

import com.Tancem.PIS.Model.SubEquipment;
import com.Tancem.PIS.Service.SubEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tancem/pis/sub_equipment")
public class SubEquipmentController {

    @Autowired
    private SubEquipmentService subEquipmentService;

    @GetMapping("/readall")
    public ResponseEntity<Map<String, Object>> getAllSubEquipments() {
        List<SubEquipment> subEquipments = subEquipmentService.getAllSubEquipments();
        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", HttpStatus.OK.value());
        response.put("statusMessage", "Success");
        response.put("data", subEquipments);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Map<String, Object>> getSubEquipmentById(@PathVariable Integer id) {
        SubEquipment subEquipment = subEquipmentService.getSubEquipmentById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", HttpStatus.OK.value());
        response.put("statusMessage", "Success");
        response.put("data", subEquipment);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createSubEquipment(@RequestBody SubEquipment subEquipment) {
        SubEquipment newSubEquipment = subEquipmentService.saveSubEquipment(subEquipment);
        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", HttpStatus.CREATED.value());
        response.put("statusMessage", "Created");
        response.put("data", newSubEquipment);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteSubEquipment(@PathVariable Integer id) {
        subEquipmentService.deleteSubEquipment(id);
        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", HttpStatus.NO_CONTENT.value());
        response.put("statusMessage", "Deleted");
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }
}