package com.Tancem.PIS.Controller;

import com.Tancem.PIS.Model.SubEquipment;
import com.Tancem.PIS.Service.SubEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tancem/pis/sub_equipment")
public class SubEquipmentController {

    @Autowired
    private SubEquipmentService subEquipmentService;

    @GetMapping("/readall")
    public ResponseEntity<List<SubEquipment>> getAllSubEquipments() {
        List<SubEquipment> subEquipments = subEquipmentService.getAllSubEquipments();
        return new ResponseEntity<>(subEquipments, HttpStatus.OK);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<SubEquipment> getSubEquipmentById(@PathVariable Integer id) {
        SubEquipment subEquipment = subEquipmentService.getSubEquipmentById(id);
        return new ResponseEntity<>(subEquipment, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<SubEquipment> createSubEquipment(@RequestBody SubEquipment subEquipment) {
        SubEquipment newSubEquipment = subEquipmentService.saveSubEquipment(subEquipment);
        return new ResponseEntity<>(newSubEquipment, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSubEquipment(@PathVariable Integer id) {
        subEquipmentService.deleteSubEquipment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}