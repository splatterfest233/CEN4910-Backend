package com.apartments.capstone.controller;

import com.apartments.capstone.serviceImpl.AptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/beta/addData")
public class AptController {

    private final AptService aptService;

    @Autowired
    public AptController(AptService aptService) { this.aptService = aptService;}

    //get entry by id
   // @GetMapping

}
