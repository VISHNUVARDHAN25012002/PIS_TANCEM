package com.Tancem.PIS.Controller;

import com.Tancem.PIS.Model.Equipment;
import com.Tancem.PIS.Model.EquipmentGroup;
import com.Tancem.PIS.Service.EquipmentGroupService;
import com.Tancem.PIS.Service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tancem/pis/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private EquipmentGroupService equipmentGroupService;

    @GetMapping("/readall")
    public ResponseEntity<Map<String, Object>> getAllEquipments() {
        List<Equipment> equipments = equipmentService.getAllEquipments();
        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", HttpStatus.OK.value());
        response.put("statusMessage", "Successfully retrieved all equipments");
        response.put("data", equipments);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Map<String, Object>> getEquipmentById(@PathVariable Integer id) {
        Equipment equipment = equipmentService.getEquipmentById(id);
        Map<String, Object> response = new HashMap<>();
        if (equipment != null) {
            response.put("statusCode", HttpStatus.OK.value());
            response.put("statusMessage", "Successfully retrieved equipment");
            response.put("data", equipment);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("statusCode", HttpStatus.NOT_FOUND.value());
            response.put("statusMessage", "Equipment not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createEquipment(@RequestBody Equipment equipment) {
        if (equipment.getEquipmentGroup() != null && equipment.getEquipmentGroup().getId() != null) {
            EquipmentGroup equipmentGroup = equipmentGroupService.findById(equipment.getEquipmentGroup().getId());
            if (equipmentGroup != null) {
                equipment.setEquipmentGroup(equipmentGroup);
            }
        }
        Equipment newEquipment = equipmentService.saveEquipment(equipment);
        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", HttpStatus.CREATED.value());
        response.put("statusMessage", "Equipment successfully created");
        response.put("data", newEquipment);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateEquipment(@PathVariable Integer id, @RequestBody Equipment equipment) {
        Equipment existingEquipment = equipmentService.getEquipmentById(id);
        if (existingEquipment != null) {
            if (equipment.getEquipmentGroup() != null && equipment.getEquipmentGroup().getId() != null) {
                EquipmentGroup equipmentGroup = equipmentGroupService.findById(equipment.getEquipmentGroup().getId());
                if (equipmentGroup != null) {
                    equipment.setEquipmentGroup(equipmentGroup);
                }
            }
            equipment.setId(id);
            Equipment updatedEquipment = equipmentService.saveEquipment(equipment);
            Map<String, Object> response = new HashMap<>();
            response.put("statusCode", HttpStatus.OK.value());
            response.put("statusMessage", "Equipment successfully updated");
             response.put("data", updatedEquipment);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("statusCode", HttpStatus.NOT_FOUND.value());
            response.put("statusMessage", "Equipment not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteEquipment(@PathVariable Integer id) {
        equipmentService.deleteEquipment(id);
        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", HttpStatus.NO_CONTENT.value());
        response.put("statusMessage", "Equipment successfully deleted");
        response.put("data", null);
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }
}
