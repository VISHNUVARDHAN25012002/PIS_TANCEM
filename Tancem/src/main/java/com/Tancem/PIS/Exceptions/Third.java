package com.Tancem.PIS.Exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/third")
public class Third {
    @GetMapping
    public String a()
    {
        return"sri";
    }
}

