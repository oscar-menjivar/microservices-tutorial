package com.in28minutes.microservices.limitesservices.controller;

import com.in28minutes.microservices.limitesservices.bean.Limits;
import com.in28minutes.microservices.limitesservices.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public Limits retrieveLimits(){
        //return new Limits(1, 1000);
        return new Limits(configuration.getMinimun(), configuration.getMaximun());
    }
}
