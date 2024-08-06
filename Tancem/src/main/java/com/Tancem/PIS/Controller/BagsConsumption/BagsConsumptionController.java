package com.Tancem.PIS.Controller.BagsConsumption;
import com.Tancem.PIS.Exceptions.ResourceNotFoundException;


import com.Tancem.PIS.Model.BagsConsumption;
import com.Tancem.PIS.Service.BagsConsumption.BagsConsumptionService;
import com.Tancem.PIS.Service.logService.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("tancem/pis/BagsConsumptionController")
public class BagsConsumptionController {
    //LOG
    @Autowired
    private LogService logService;



    @Autowired
    private BagsConsumptionService bagsConsumptionService;

    @GetMapping("/readall")
    public ResponseEntity<Map<String, Object>> getAllBags() {
        List<BagsConsumption> bags = bagsConsumptionService.getAllBags();
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("message", "All bags retrieved successfully.");
        response.put("data", bags);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Map<String, Object>> getBagById(@PathVariable int id) {
        BagsConsumption bag = bagsConsumptionService.getBagById(id);
        if (bag == null) {
            throw new ResourceNotFoundException("Bag not found with id: " + id);
        }
        Map<String, Object> response = new HashMap<>();
        response.put("id", bag.getId());
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Bag retrieved successfully.");
        response.put("data", bag);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createBag( @RequestBody BagsConsumption bag) {
        // Check if ID already exists
        if (bagsConsumptionService.getBagById(bag.getId()) != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("status", HttpStatus.BAD_REQUEST.value());
            response.put("message", "ID already exists. Cannot use this ID.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        BagsConsumption savedBag = bagsConsumptionService.saveBag(bag);
        Map<String, Object> response = new HashMap<>();
        response.put("id", savedBag.getId());
        response.put("status", HttpStatus.CREATED.value());
        response.put("message", "Bag created successfully.");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateBag(@PathVariable int id,  @RequestBody BagsConsumption bag) {
        BagsConsumption existingBag = bagsConsumptionService.getBagById(id);
        if (existingBag == null) {
            throw new ResourceNotFoundException("Bag not found with id: " + id);
        }

        bag.setId(id);
        bagsConsumptionService.updateBag(id, bag);
        Map<String, Object> response = new HashMap<>();
        response.put("id", id);
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Bag updated successfully.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteBag(@PathVariable int id) {
        BagsConsumption existingBag = bagsConsumptionService.getBagById(id);
        if (existingBag == null) {
            throw new ResourceNotFoundException("Bag not found with id: " + id);
        }

        bagsConsumptionService.deleteBag(id);
        Map<String, Object> response = new HashMap<>();
        response.put("id", id);
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Bag deleted successfully.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}