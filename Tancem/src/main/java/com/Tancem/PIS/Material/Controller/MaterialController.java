package com.Tancem.PIS.Material.Controller;

import com.Tancem.PIS.DTO.ErrorResponse;
import com.Tancem.PIS.Exceptions.CustomException;
import com.Tancem.PIS.Material.Entity.Material;
import com.Tancem.PIS.Material.Service.MaterialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tancem/pis/materials")
public class MaterialController {
    private static final Logger logger = LoggerFactory.getLogger(MaterialController.class);

    @Autowired
    private MaterialService materialService;

    @GetMapping
    public ResponseEntity<?> getAllMaterials() {
        try {
            List<Material> materials = materialService.getAllMaterials();
            logger.info("Retrieved all materials successfully");
            return new ResponseEntity<>(materials, HttpStatus.OK);
        } catch (CustomException e) {
            logger.error("Error retrieving materials: {}", e.getMessage());
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMaterialById(@PathVariable Integer id) {
        try {
            Material material = materialService.getMaterialById(id);
            logger.info("Retrieved material with id: {}", id);
            return new ResponseEntity<>(material, HttpStatus.OK);
        } catch (CustomException e) {
            logger.error("Error retrieving material with id {}: {}", id, e.getMessage());
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createMaterial(@RequestBody Material material) {
        try {
            Material savedMaterial = materialService.saveMaterial(material);
            logger.info("Created new material with id: {}", savedMaterial.getId());
            return new ResponseEntity<>(savedMaterial, HttpStatus.CREATED);
        } catch (CustomException e) {
            logger.error("Error creating material: {}", e.getMessage());
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMaterial(@PathVariable Integer id, @RequestBody Material material) {
        try {
            material.setId(id);
            Material updatedMaterial = materialService.saveMaterial(material);
            logger.info("Updated material with id: {}", id);
            return new ResponseEntity<>(updatedMaterial, HttpStatus.OK);
        } catch (CustomException e) {
            logger.error("Error updating material with id {}: {}", id, e.getMessage());
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMaterial(@PathVariable Integer id) {
        try {
            materialService.deleteMaterial(id);
            logger.info("Deleted material with id: {}", id);
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.NO_CONTENT.value(), "Material deleted successfully"), HttpStatus.NO_CONTENT);
        } catch (CustomException e) {
            logger.error("Error deleting material with id {}: {}", id, e.getMessage());
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
