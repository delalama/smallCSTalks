package com.example.workshits.controller;

import com.example.workshits.service.MyMercService.MyMercService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyMercMeerjarenPlanController {
    MyMercService myMercService;

    @Autowired
    public MyMercMeerjarenPlanController(MyMercService myMercService) {
        this.myMercService = myMercService;
    }

    @GetMapping
    public String getMeerjarenPlan(){
        return myMercService.getMeerjarenPlan();
    }
}
