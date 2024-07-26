package com.Tancem.PIS.Controller;

import com.Tancem.PIS.Model.EquipmentGroup;
import com.Tancem.PIS.Service.EquipmentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/tancem/pis/equipment_group")
public class EquipmentGroupController {

    @Autowired
    private EquipmentGroupService service;

    @GetMapping("/readall")
    public ResponseEntity<Map<String, Object>> getAll() {
        List<EquipmentGroup> equipmentGroups = service.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", HttpStatus.OK.value());
        response.put("statusMessage", "Successfully retrieved all equipment groups");
        response.put("data", equipmentGroups);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable Integer id) {
        EquipmentGroup equipmentGroup = service.findById(id);
        Map<String, Object> response = new HashMap<>();
        if (equipmentGroup != null) {
            response.put("statusCode", HttpStatus.OK.value());
            response.put("statusMessage", "Successfully retrieved equipment group");
            response.put("data", equipmentGroup);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("statusCode", HttpStatus.NOT_FOUND.value());
            response.put("statusMessage", "Equipment group not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> create(@RequestBody EquipmentGroup equipmentGroup) {
        EquipmentGroup newEquipmentGroup = service.save(equipmentGroup);
        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", HttpStatus.CREATED.value());
        response.put("statusMessage", "Equipment group successfully created");
        response.put("data", newEquipmentGroup);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable Integer id, @RequestBody EquipmentGroup equipmentGroup) {
        Map<String, Object> response = new HashMap<>();
        if (service.findById(id) != null) {
            equipmentGroup.setId(id);
            EquipmentGroup updatedEquipmentGroup = service.save(equipmentGroup);
            response.put("statusCode", HttpStatus.OK.value());
            response.put("statusMessage", "Equipment group successfully updated");
            response.put("data", updatedEquipmentGroup);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("statusCode", HttpStatus.NOT_FOUND.value());
            response.put("statusMessage", "Equipment group not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        if (service.findById(id) != null) {
            service.deleteById(id);
            response.put("statusCode", HttpStatus.NO_CONTENT.value());
            response.put("statusMessage", "Equipment group successfully deleted");
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        } else {
            response.put("statusCode", HttpStatus.NOT_FOUND.value());
            response.put("statusMessage", "Equipment group not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}