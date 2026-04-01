package com.crud.crud.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class authController {

    @PostMapping("/{id}")
    public String hello(){
        return "Hello";
    }

}
