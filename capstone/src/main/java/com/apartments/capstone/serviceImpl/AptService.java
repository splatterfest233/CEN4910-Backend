package com.apartments.capstone.serviceImpl;

import com.apartments.capstone.dao.AptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AptService {

    private final AptDao aptDao;

    @Autowired
    public AptService (AptDao aptDao){this.aptDao = aptDao;}

    //replace object with request body type
    public Optional<Object[]> getAptInfo (String name) {return aptDao.getPropertyByName(name);}
}
