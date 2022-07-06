package com.apartments.capstone.dao;

import com.apartments.capstone.entity.PropertyName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AptDao {

    @Query("SELECT x FROM propertyName x WHERE s.name = ?1")
    Optional<PropertyName> getPropertyByName(String name);

}
