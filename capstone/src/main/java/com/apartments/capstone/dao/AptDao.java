package com.apartments.capstone.dao;

import com.apartments.capstone.entity.PropertyName;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AptDao {

    @Query(value = "SELECT * FROM propertyname, location, coordinates, units, fees, utilities, propertyInformation " +
            "WHERE propertyname.property_id = (SELECT property_id FROM propertyname WHERE property_name = :name) \n" +
            "AND propertyname.property_id = location.property_id " +
            "AND propertyname.property_id = coordinates.property_id " +
            "AND propertyname.property_id = units.property_id " +
            "AND propertyname.property_id = fees.property_id " +
            "AND propertyname.property_id = utilities.property_id " +
            "AND propertyname.property_id = propertyInformation.property_id;",
            nativeQuery = true)
    Optional<Object[]> getPropertyByName(@Param("name") String name);

}
