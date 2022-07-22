package com.apartments.capstone.serviceImpl;

import com.apartments.capstone.dao.AptDaoImpl;
import com.apartments.capstone.entity.PropertyName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//makes returns data fetched from db
@Service
public class AptServiceImpl {
    private final AptDaoImpl aptDao;

    @Autowired
    public AptServiceImpl(AptDaoImpl aptDao) {
        this.aptDao = aptDao;
    }

    public PropertyName aptIdByName (String name) {
        return aptDao.getPropertyIdFromName(name);
    }
}
