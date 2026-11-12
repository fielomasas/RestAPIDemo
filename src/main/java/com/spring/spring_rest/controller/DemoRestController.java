package com.spring.spring_rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Provides simple demonstration endpoints.
 */
@RestController 
@RequestMapping("/test")
public class DemoRestController {

    /**
     * Returns a greeting from the demo endpoint.
     *
     * @return the greeting message
     */
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

}
