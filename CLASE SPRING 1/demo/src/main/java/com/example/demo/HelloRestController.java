package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
    @GetMapping(path = "/{name}")
    public String sayHello(@PathVariable String name) {

        // aca programar
        return "Hello, " + name;
    }
}
