package com.apartments.capstone.dao;

import com.apartments.capstone.entity.PropertyName;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

//retrieves data from the database
@Repository
public class AptDaoImpl {

    @Autowired
    private static SessionFactory sessionFactory;

    private static void loadSessionFactory()
    {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addResource("PropertyName.hbm.xml");
            ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
                    .build();
            sessionFactory = configuration.buildSessionFactory(registry);
        }catch (Exception e)
        {
            System.out.println("loadSessionFactory -- Failed");
            e.printStackTrace();
        }
    }

    public static Session getSession(){
        Session session = null;
        try{
            session = sessionFactory.openSession();
        } catch (Exception e){
            System.out.println("getSession -- Failed");
            e.printStackTrace();
        }
        return session;
    }

    //retrieves property name and id given a name
    //then using that id, query for other items
    public PropertyName getPropertyIdFromName(String name) throws DataAccessException
    {
        PropertyName propName = new PropertyName();
        try{
            loadSessionFactory();
            Session getId = getSession();
            getId.beginTransaction();

            Query query = getId.createQuery("SELECT P " +
                    "FROM com.apartments.capstone.entity.PropertyName P " +
                    "WHERE P.propertyName LIKE :name", PropertyName.class)
                    .setParameter("name", name);

            List<PropertyName> results = query.list();

            if(results != null && !results.isEmpty()){
                System.out.println(results);
                propName = results.get(0);
            }
        } catch (Exception e) {
            System.out.println("getPropertyIdFromName -- Failed");
            e.printStackTrace();
        } finally {
            getSession().close();
        }
        System.out.println(propName);
        return propName;
    }
}
