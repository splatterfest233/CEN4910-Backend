package com.apartments.capstone.dao;


import com.apartments.capstone.entity.PropertyName;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

//retrieves data from the database
@Repository
public class AptDaoImpl {

    //lets write code that retrieves property name and id given a name
    //get id from name
    //then using that id, query for other items
    //bring that all back

    //maybe join all entity into one

    @Autowired
    private final SessionFactory sessionFactory;

    public AptDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public PropertyName getPropertyIdFromName(String name) throws DataAccessException
    {
        PropertyName propName = new PropertyName();
        try{
            Session session = sessionFactory.openSession();
            Query query = session.createQuery("SELECT property_name, property_id \n" +
                    "FROM propertyname \n" +
                    "WHERE property_name LIKE :name", PropertyName.class);
            query.setParameter("name", name);
            List<PropertyName> results = query.list();
            if(results.size() > 0){
                propName = results.get(0);
            }
        } catch (Exception e) {
            System.out.println("getProperytIdFromName -- Failed");
            e.printStackTrace();
        }
        System.out.println(propName);
        return propName;
    }
}
