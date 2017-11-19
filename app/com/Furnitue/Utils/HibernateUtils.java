package com.Furnitue.Utils;

import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.EntityType;

import javax.persistence.Query;

public class HibernateUtils {
    private static HibernateUtils instance = null;

    private static SessionFactory sessionFactory;
    //private static StandardServiceRegistry serviceRegistry;

    private HibernateUtils(){
        Configuration configuration = new Configuration();
        configuration.configure();
       // serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory();
    }

    public static HibernateUtils getInstance(){
        if(instance == null){
            instance  = new HibernateUtils();
        }
        return instance;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }


//            public static  SessionFactory sessionFactory;
//        private HibernateUtils() {
//        }
////maling the Hibernate SessionFactory object as singleton
//
//        public static synchronized SessionFactory getSessionFactory() {
//
//            if (sessionFactory == null) {
//                sessionFactory = new Configuration().configure("hibernate.cfg.xml").
//                        buildSessionFactory();
//            }
//            return sessionFactory;
//        }

//            static {
//                try {
//                    sessionFactory = new Configuration().configure()
//                            .buildSessionFactory();
//                } catch (Throwable ex) {
//                    System.err.println("Initial SessionFactory creation failed." + ex);
//                    throw new ExceptionInInitializerError(ex);
//                }
//            }
//
//            public static SessionFactory getSessionFactory() {
//                return sessionFactory;
//            }
        }

