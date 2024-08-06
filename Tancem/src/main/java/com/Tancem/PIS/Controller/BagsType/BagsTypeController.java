package com.Tancem.PIS.Controller.BagsType;
import com.Tancem.PIS.Exceptions.ResourceNotFoundException;

import  com.Tancem.PIS.Model.BagsType;
import com.Tancem.PIS.Service.BagsType.BagsTypeService;
import com.Tancem.PIS.Service.logService.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("tancem/pis/BagsTypeController")
public class BagsTypeController {
    //LOG
    @Autowired
    private LogService logService;

    @Autowired
    private BagsTypeService bagsTypeService;


    @GetMapping("/readall")
    public ResponseEntity<Map<String, Object>> getAllBagTypes() {
        List<BagsType> bagTypes = bagsTypeService.getAllBagTypes();
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("message", "All bag types retrieved successfully.");
        response.put("data", bagTypes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Map<String, Object>> getBagTypeById(@PathVariable int id) {
        BagsType bagType = bagsTypeService.getBagTypeById(id);
        if (bagType == null) {
            throw new ResourceNotFoundException("Bag type not found with id: " + id);
        }
        Map<String, Object> response = new HashMap<>();
        response.put("id", bagType.getId());
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Bag type retrieved successfully.");
        response.put("data", bagType);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createBagType(@RequestBody BagsType bagType) {
        // Check if ID already exists
        BagsType existingBagType = bagsTypeService.getBagTypeById(bagType.getId());
        if (existingBagType != null) {
            // ID already exists, return a message indicating this
            Map<String, Object> response = new HashMap<>();
            response.put("status", HttpStatus.BAD_REQUEST.value());
            response.put("message", "ID already exists. Cannot use this ID.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }


        // Save the new bag type
        BagsType savedBagType = bagsTypeService.saveBagType(bagType);

        // Prepare the response
        Map<String, Object> response = new HashMap<>();
        response.put("id", savedBagType.getId());
        response.put("status", HttpStatus.CREATED.value());
        response.put("message", "Bag type created successfully.");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateBagType(@PathVariable int id,  @RequestBody BagsType bagType) {
        BagsType existingBagType = bagsTypeService.getBagTypeById(id);
        if (existingBagType == null) {
            throw new ResourceNotFoundException("Bag type not found with id: " + id);
        }

        bagType.setId(id);
        bagsTypeService.updateBagType(id, bagType);
        Map<String, Object> response = new HashMap<>();
        response.put("id", id);
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Bag type updated successfully.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteBagType(@PathVariable int id) {
        BagsType existingBagType = bagsTypeService.getBagTypeById(id);
        if (existingBagType == null) {
            throw new ResourceNotFoundException("Bag type not found with id: " + id);
        }

        bagsTypeService.deleteBagType(id);
        Map<String, Object> response = new HashMap<>();
        response.put("id", id);
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Bag type deleted successfully.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
