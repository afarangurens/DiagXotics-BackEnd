package com.afas.diagxotics;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiagxoticsController {
    
    @RequestMapping("/hello")
    public String welcomeMessage(){
        return "Hello world";
    }
}
