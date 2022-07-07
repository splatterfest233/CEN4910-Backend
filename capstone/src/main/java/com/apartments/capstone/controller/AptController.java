package com.apartments.capstone.controller;

import com.apartments.capstone.serviceImpl.AptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "api/beta/addData")
public class AptController {

    private final AptService aptService;

    @Autowired
    public AptController(AptService aptService) { this.aptService = aptService;}

    //get entry by name
    //probably change request body type
    //and response type
   @GetMapping
    public Optional<Object[]> aptInfoByName (@RequestBody String name){return aptService.getAptInfo(name);}

}
