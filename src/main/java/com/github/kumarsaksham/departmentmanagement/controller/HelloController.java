package com.github.kumarsaksham.departmentmanagement.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${welcome.message}")
    private String welcomeMessage;

//    @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String helloWorld() {
        return welcomeMessage;
    }
}
