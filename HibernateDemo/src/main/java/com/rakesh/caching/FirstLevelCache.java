package com.rakesh.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FirstLevelCache {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

//        Product p1 = new Product();
//        p1.setpId(205);
//        p1.setName("Grinder");
//        p1.setBrand("Bajaj");

        Session session1 = factory.openSession();
        Transaction tx = session1.beginTransaction();

//        session.persist(p1);

//        tx.commit();

        Product p1 = session1.get(Product.class,201);
        System.out.println(p1);
        System.out.println("Doing some work......");

        Product p2 = session1.get(Product.class,201); // First level cache
        System.out.println(p2);
        System.out.println(session1.contains(p2));

        session1.close();

        System.out.println("---------------------------------");

        Session session2 = factory.openSession();
        Product p3 = session2.get(Product.class,201);
        System.out.println("New session begins......");
        System.out.println(p3);

        factory.close();

    }
}
