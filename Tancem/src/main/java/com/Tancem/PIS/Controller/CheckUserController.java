package com.Tancem.PIS.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class CheckUserController {

    @GetMapping("/public")
    public ResponseEntity<String> publicEndpoint()
    {
        return ResponseEntity.ok("This is a public endpoint accessible by both users and admins!");
    }

    @GetMapping("/user")
    public ResponseEntity<String> userEndpoint()
    {
        return ResponseEntity.ok("Hello user! This endpoint is accessible only by users.");
     }
  }
