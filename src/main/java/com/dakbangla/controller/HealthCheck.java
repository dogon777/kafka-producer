package com.dakbangla.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka-producer/v1")
public class HealthCheck {
    
    @GetMapping("health-status")
    public String healthStatus(){
        return "Kafka Producer server is UP and RUNNING";
    }
}
