package com.rakesh.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App
{
    public static void main( String[] args )
    {
        Address a1 = new Address();
        a1.setStreet("Kalyannagar");
        a1.setDistrict("Bangalore");
        a1.setState("Karnataka");

        Student s1 = new Student();
        s1.setsAge(28);
        s1.setsName("Soham");
        s1.setRollNo(131);
        s1.setTech("Python");
        s1.setAddress(a1);

        //Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
                                                .addAnnotatedClass(Student.class)
                                                 .buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        //session.save(s1); ---> Deprecated
//        session.persist(s1);

        Student s2 = session.get(Student.class,130);
        System.out.println(s2);
        s2.setAddress(a1);

//        s2.setsAge(23);
        //session.update(s2);   ----> Deprecated
        session.merge(s2);

//        Student s3 = session.get(Student.class,125);
//        session.remove(s3);

        tx.commit();
        session.close();
        sf.close();
    }
}
