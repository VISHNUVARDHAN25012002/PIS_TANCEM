package com.Tancem.PIS.Material.Controller;

import com.Tancem.PIS.DTO.ErrorResponse;
import com.Tancem.PIS.Exceptions.CustomException;

import com.Tancem.PIS.Model.Material_Type.Material_Type;

import com.Tancem.PIS.Service.Material_Type_Service.MaterialTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tancem/pis/materialTypes")
public class MaterialTypeController {
    private static final Logger logger = LoggerFactory.getLogger(MaterialTypeController.class);

    @Autowired
    private MaterialTypeService materialTypeService;

    @GetMapping
    public ResponseEntity<?> getAllMaterialTypes() {
        try {
            List<Material_Type> materialTypes = materialTypeService.getAllMaterialTypes();
            logger.info("Retrieved all material types");
            return new ResponseEntity<>(materialTypes, HttpStatus.OK);
        } catch (CustomException e) {
            logger.error("Error retrieving material types: {}", e.getMessage());
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMaterialTypeById(@PathVariable Integer id) {
        try {
            Material_Type materialType = materialTypeService.getMaterialTypeById(id);
            logger.info("Retrieved material type with id: {}", id);
            return new ResponseEntity<>(materialType, HttpStatus.OK);
        } catch (CustomException e) {
            logger.error("Error retrieving material type: {}", e.getMessage());
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createMaterialType(@RequestBody Material_Type materialType) {
        try {
            Material_Type savedMaterialType = materialTypeService.saveMaterialType(materialType);
            logger.info("Created new material type");
            return new ResponseEntity<>(savedMaterialType, HttpStatus.CREATED);
        } catch (CustomException e) {
            logger.error("Error creating material type: {}", e.getMessage());
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMaterialType(@PathVariable Integer id, @RequestBody Material_Type materialType) {
        try {
//            MaterialType existingMaterialType = materialTypeService.getMaterialTypeById(id);
            materialType.setId(id);
            Material_Type updatedMaterialType = materialTypeService.saveMaterialType(materialType);
            logger.info("Updated material type with id: {}", id);
            return new ResponseEntity<>(updatedMaterialType, HttpStatus.OK);
        } catch (CustomException e) {
            logger.error("Error updating material type: {}", e.getMessage());
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMaterialType(@PathVariable Integer id) {
        try {
            materialTypeService.deleteMaterialType(id);
            logger.info("Deleted material type with id: {}", id);
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.NO_CONTENT.value(), "MaterialType deleted successfully"), HttpStatus.NO_CONTENT);
        } catch (CustomException e) {
            logger.error("Error deleting material type:  {}", e.getMessage());
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
