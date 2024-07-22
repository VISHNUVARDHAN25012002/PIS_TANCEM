package com.Tancem.PIS.DAO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second")
public class Second {
    @GetMapping
    public String a()
    {
        return"sri";
    }
}

