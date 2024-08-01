package com.Tancem.PIS.Material.Controller;

import com.Tancem.PIS.DTO.ErrorResponse;
import com.Tancem.PIS.Exceptions.CustomException;

import com.Tancem.PIS.Model.Status.Status;
import com.Tancem.PIS.Service.Status_Service.StatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tancem/pis/status")
public class StatusController {
    private static final Logger logger = LoggerFactory.getLogger(StatusController.class);

    @Autowired
    private StatusService statusService;

    @GetMapping
    public ResponseEntity<?> getAllStatuses() {
        try {
            List<Status> statuses = statusService.getAllStatuses();
            logger.info("Retrieved all statuses");
            return new ResponseEntity<>(statuses, HttpStatus.OK);
        } catch (CustomException e) {
            logger.error("Error retrieving statuses: {}", e.getMessage());
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStatusById(@PathVariable Integer id) {
        try {
            Status status = statusService.getStatusById(id);
            logger.info("Retrieved status with id: {}", id);
            return new ResponseEntity<>(status, HttpStatus.OK);
        } catch (CustomException e) {
            logger.error("Error retrieving status: {}", e.getMessage());
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createStatus(@RequestBody Status status) {
        try {
            Status savedStatus = statusService.saveStatus(status);
            logger.info("Created new status");
            return new ResponseEntity<>(savedStatus, HttpStatus.CREATED);
        } catch (CustomException e) {
            logger.error("Error creating status: {}", e.getMessage());
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStatus(@PathVariable Integer id, @RequestBody Status status) {
        try {
            Status existingStatus = statusService.getStatusById(id);
            status.setId(id);
            Status updatedStatus = statusService.saveStatus(status);
            logger.info("Updated status with id: {}", id);
            return new ResponseEntity<>(updatedStatus, HttpStatus.OK);
        } catch (CustomException e) {
            logger.error("Error updating status: {}", e.getMessage());
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStatus(@PathVariable Integer id) {
        try {
            statusService.deleteStatus(id);
            logger.info("Deleted status with id: {}", id);
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.NO_CONTENT.value(), "Status deleted successfully"), HttpStatus.NO_CONTENT);
        } catch (CustomException e) {
            logger.error("Error deleting status: {}", e.getMessage());
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
