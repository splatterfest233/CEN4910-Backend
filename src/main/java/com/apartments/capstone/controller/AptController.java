package com.apartments.capstone.controller;

import com.apartments.capstone.entity.PropertyName;
import com.apartments.capstone.entity.RequestObject;
import com.apartments.capstone.serviceImpl.AptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//handles web requests
@RestController
//endpoint
@RequestMapping
public class AptController {

    private final AptServiceImpl aptService;

    @Autowired
    public AptController(AptServiceImpl aptService) {
        this.aptService = aptService;
    }

    //handles post requests
    @PostMapping(path = "/getAptInfo")
    public PropertyName aptInfoByName (@RequestBody RequestObject name) {
        String aptName = name.getName();
        return aptService.aptIdByName(aptName);
        //then use the id to get rest of info
    }

}
