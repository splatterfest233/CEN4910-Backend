package com.apartments.capstone.dao;

import com.apartments.capstone.entity.PropertyName;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

//retrieves data from the database
@Repository
public class AptDaoImpl {

    // write code that retrieves property name and id given a name
    //get id from name
    //then using that id, query for other items

//    private final SessionFactory sessionFactory = new Configuration().buildSessionFactory();

    public PropertyName getPropertyIdFromName(String name) throws DataAccessException
    {
        PropertyName propName = new PropertyName();
        try{
//            Session session = sessionFactory.openSession();
//            session.beginTransaction();
//            //seems to be failing here
//            Query query = session.createQuery("SELECT P.propertyName, P.propertyId " +
//                    "FROM com.apartments.capstone.entity.PropertyName P " +
//                    "WHERE P.propertyName LIKE :name", PropertyName.class)
//                    .setParameter("name", name);
//            List<PropertyName> results = query.list();
//            if(results != null && !results.isEmpty()){
//                System.out.println(results);
//                propName = results.get(0);
//            }
//            session.close();
        } catch (Exception e) {
            System.out.println("getPropertyIdFromName -- Failed");
            e.printStackTrace();
        }
        System.out.println(propName);
        return propName;
    }
}
