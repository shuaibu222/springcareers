package com.shuaibu.recruiters.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class RecruitersController {
    
    @GetMapping("/api/v1/recruiters")
    public String getRecruiterGreeting() {
        return "Recruiters Controller in action!";
    }
    
}
