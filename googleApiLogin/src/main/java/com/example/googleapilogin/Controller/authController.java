package com.example.googleapilogin.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class authController {

    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }
}
