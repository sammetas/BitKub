package com.bitkub.service.BitKub;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    @Value("${spring.application.message: Default message}")
    private String message;

    @RequestMapping("/message")

    public  String getMessage(){
        return message;
    }
}
