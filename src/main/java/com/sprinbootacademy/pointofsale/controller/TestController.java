package com.sprinbootacademy.pointofsale.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/v1/test")
public class TestController {

    public void getMyText(){
        String text = "Hiran";
        System.out.println(text);
    }
}
