package com.Tancem.PIS.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class CheckController {

    @GetMapping("/admin")
    public ResponseEntity<String> adminEndpoint() {
        return ResponseEntity.ok("Welcome Admin! This endpoint is accessible only by admins.");
    }

    @GetMapping("/add-employee")
    public ResponseEntity<String> addEmployeeEndpoint() {
        return ResponseEntity.ok("Admin can add an employee. This endpoint is accessible only by admins.");
    }
}
