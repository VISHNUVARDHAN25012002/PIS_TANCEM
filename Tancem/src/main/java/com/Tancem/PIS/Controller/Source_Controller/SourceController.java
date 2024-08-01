package com.Tancem.PIS.Controller.Source_Controller;

import com.Tancem.PIS.Exceptions.CustomException;

import com.Tancem.PIS.Model.Source.Source;

import com.Tancem.PIS.Service.Source_Service.SourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Tancem.PIS.DTO.ErrorResponse;
import java.util.List;

@RestController
@RequestMapping("/tancem/pis/sources")
public class SourceController {
    private static final Logger logger = LoggerFactory.getLogger(SourceController.class);

    @Autowired
    private SourceService sourceService;

    @GetMapping
    public ResponseEntity<?> getAllSources() {
        try {
            List<Source> sources = sourceService.getAllSources();
            logger.info("Retrieved all sources");
            return new ResponseEntity<>(sources, HttpStatus.OK);
        } catch (CustomException e) {
            logger.error("Error retrieving sources: {}", e.getMessage());
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSourceById(@PathVariable Integer id) {
        try {
            Source source = sourceService.getSourceById(id);
            logger.info("Retrieved source with id: {}", id);
            return new ResponseEntity<>(source, HttpStatus.OK);
        } catch (CustomException e) {
            logger.error("Error retrieving source: {}", e.getMessage());
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createSource(@RequestBody Source source) {
        try {
            Source savedSource = sourceService.saveSource(source);
            logger.info("Created new source");
            return new ResponseEntity<>(savedSource, HttpStatus.CREATED);
        } catch (CustomException e) {
            logger.error("Error creating source: {}", e.getMessage());
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSource(@PathVariable Integer id, @RequestBody Source source) {
        try {
            Source existingSource = sourceService.getSourceById(id);
            source.setId(id);
            Source updatedSource = sourceService.saveSource(source);
            logger.info("Updated source with id: {}", id);
            return new ResponseEntity<>(updatedSource, HttpStatus.OK);
        } catch (CustomException e) {
            logger.error("Error updating source: {}", e.getMessage());
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSource(@PathVariable Integer id) {
        try {
            sourceService.deleteSource(id);
            logger.info("Deleted source with id: " + id);
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.NO_CONTENT.value(), "Source deleted successfully"), HttpStatus.NO_CONTENT);
        } catch (CustomException e) {
            logger.error("Error deleting source: " + e.getMessage());
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
