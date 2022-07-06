package com.apartments.capstone.serviceImpl;

import com.apartments.capstone.dao.AptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AptService {

    private final AptDao aptDao;

    @Autowired
    public AptService (AptDao aptDao){this.aptDao = aptDao;}
}
