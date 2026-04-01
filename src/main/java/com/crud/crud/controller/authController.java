package com.crud.crud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class authController {

    @PostMapping("/{id}")
    public String hello(){
        return "Hello";
    }

    @GetMapping ("/{id}")
    public String GetEmployee(){
        return "Hello Ashish";
    }


    @GetMapping ("/{employeeId}")
    public String GetEmployeeById(){
        return "checking kar raha hu";
    }

    @GetMapping ("/{employeeId}")
    public String checking(){
        return "second time check kar raha hu";
    }
}
