package com.rakesh.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Laptop l1 = new Laptop();
        l1.setlId(550);
        l1.setlBrand("Dell");
        l1.setlModel("dell256 pro 2");

        Laptop l2 = new Laptop();
        l2.setlId(525);
        l2.setlBrand("Apple");
        l2.setlModel("Macbook Air 21");

        Laptop l3 = new Laptop();
        l3.setlId(510);
        l3.setlBrand("HP");
        l3.setlModel("NoteBook Pro 21");

        Laptop l4 = new Laptop();
        l4.setlId(540);
        l4.setlBrand("Acer");
        l4.setlModel("S12621");

        Laptop l5 = new Laptop();
        l5.setlId(527);
        l5.setlBrand("HP");
        l5.setlModel("Probook");

        Alien a1 = new Alien();
        a1.setaId(110);
        a1.setaName("Ayush");
        a1.setaTech("DataEngineer");


        Alien a2 = new Alien();
        a2.setaId(102);
        a2.setaName("Dipti");
        a2.setaTech("CyberSecurity");

        Alien a3 = new Alien();
        a3.setaId(105);
        a3.setaName("Rakesh Anand");
        a3.setaTech("Java Backend");

        a1.setaLaptop(Arrays.asList(l1,l2));
        a2.setaLaptop(Arrays.asList(l3));
        a3.setaLaptop(Arrays.asList(l4,l5));

        l1.setAlien(a1);
        l2.setAlien(a1);
        l3.setAlien(a2);
        l4.setAlien(a3);
        l5.setAlien(a3);


        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
                                               .addAnnotatedClass(Laptop.class)
                                               .addAnnotatedClass(Alien.class)
                                               .buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

//        session.persist(l1);
//        session.persist(l2);
//        session.persist(l3);
//        session.persist(l4);
//        session.persist(l5);
//
//        session.persist(a1);
//        session.persist(a2);
//        session.persist(a3);

        Alien a = session.get(Alien.class,105); // By default the fetch type is LAZY & not EAGER
        List<Laptop> laptops = a.getaLaptop();
        System.out.println(laptops);

//        Laptop l = session.get(Laptop.class,525);
//        System.out.println(l);


        tx.commit();
        sf.close();
        session.close();


    }
}
