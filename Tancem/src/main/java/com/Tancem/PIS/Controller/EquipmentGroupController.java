package com.Tancem.PIS.Controller;

import com.Tancem.PIS.Model.EquipmentGroup;
import com.Tancem.PIS.Service.EquipmentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tancem/pis/equipment_group")
public class EquipmentGroupController {

    @Autowired
    private EquipmentGroupService service;

    @GetMapping("/readall")
    public ResponseEntity<List<EquipmentGroup>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<EquipmentGroup> getById(@PathVariable Integer id) {
        EquipmentGroup equipmentGroup = service.findById(id);
        return equipmentGroup != null ? ResponseEntity.ok(equipmentGroup) : ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<EquipmentGroup> create(@RequestBody EquipmentGroup equipmentGroup) {
        return new ResponseEntity<>(service.save(equipmentGroup), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EquipmentGroup> update(@PathVariable Integer id, @RequestBody EquipmentGroup equipmentGroup) {
        if (service.findById(id) != null) {
            equipmentGroup.setId(id);
            return ResponseEntity.ok(service.save(equipmentGroup));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (service.findById(id) != null) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
