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
        response.put("statusMessage", "Successfully retrieved all equipments");
        response.put("data", subEquipments);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Map<String, Object>> getSubEquipmentById(@PathVariable Integer id) {
        SubEquipment subEquipment = subEquipmentService.getSubEquipmentById(id);
        Map<String, Object> response = new HashMap<>();
        if (subEquipment != null) {
            response.put("statusCode", HttpStatus.OK.value());
            response.put("statusMessage", "Success");
            response.put("data", subEquipment);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("statusCode", HttpStatus.NOT_FOUND.value());
            response.put("statusMessage", "sub_Equipment not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createSubEquipment(@RequestBody SubEquipment subEquipment) {
        SubEquipment newSubEquipment = subEquipmentService.saveSubEquipment(subEquipment);
        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", HttpStatus.CREATED.value());
        response.put("statusMessage", "Sub-equipment successfully created");
        response.put("data", newSubEquipment);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<Map<String, Object>> updateSubEquipment(@PathVariable Integer id, @RequestBody SubEquipment subEquipment) {
//        Map<String, Object> response = new HashMap<>();
//        SubEquipment existingSubEquipment = subEquipmentService.getSubEquipmentById(id);
//        if (existingSubEquipment != null) {
//            subEquipment.setId(id);
//
//            // Handle activation and deactivation logic
//            if (subEquipment.isActive()==false) {
//                subEquipment.setActive(true);
//            } else {
//                subEquipment.setActive(false);
//            }
//
//            SubEquipment updatedSubEquipment = subEquipmentService.saveSubEquipment(subEquipment);
//            response.put("statusCode", HttpStatus.OK.value());
//            response.put("statusMessage", "Sub-equipment successfully updated");
//            response.put("data", updatedSubEquipment);
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } else {
//            response.put("statusCode", HttpStatus.NOT_FOUND.value());
//            response.put("statusMessage", "Sub-equipment not found");
//            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//        }
//    }
//}

    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateSubEquipment(@PathVariable Integer id, @RequestBody SubEquipment subEquipment) {
        Map<String, Object> response = new HashMap<>();
        SubEquipment existingSubEquipment = subEquipmentService.getSubEquipmentById(id);
        if (existingSubEquipment != null) {
            subEquipment.setId(id);

            // Handle activation and deactivation logic
            subEquipment.setActive(!existingSubEquipment.isActive());

            SubEquipment updatedSubEquipment = subEquipmentService.saveSubEquipment(subEquipment);
            response.put("statusCode", HttpStatus.OK.value());
            response.put("statusMessage", "Sub-equipment successfully updated");
            response.put("data", updatedSubEquipment);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("statusCode", HttpStatus.NOT_FOUND.value());
            response.put("statusMessage", "Sub-equipment not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}