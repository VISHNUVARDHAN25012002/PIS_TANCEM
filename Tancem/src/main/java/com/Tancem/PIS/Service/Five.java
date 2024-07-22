package com.Tancem.PIS.Service;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/five")
public class Five {
    @GetMapping
    public String a()
    {
        return"sri";
    }
}
