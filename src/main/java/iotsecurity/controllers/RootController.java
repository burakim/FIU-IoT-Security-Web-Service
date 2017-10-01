package iotsecurity.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class RootController {
    
    @RequestMapping("/")
    public String index() {
        return "Web Service is running perfectly!";
    }
    
}
