package com.Tancem.PIS.Model;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Four {
    @GetMapping
    public String a()
    {
        return"sri";
    }
}

