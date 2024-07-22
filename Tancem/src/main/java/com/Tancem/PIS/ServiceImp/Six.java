package com.Tancem.PIS.ServiceImp;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/six")
public class Six{
    @GetMapping
    public String a()
    {
        return"sri";
    }
}
