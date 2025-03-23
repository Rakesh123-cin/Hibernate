package com.rakesh.lifecycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args)
    {
        // 1. Transient
        // 2. Persistent
        // 3. Detached
        // 4. Removed

        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Employee emp = new Employee();
        emp.setId(501);
        emp.setName("Srijan Sinha");
        emp.setDepartment("Infra");
        //Employee : Transient state

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        //session.persist(emp);
        // Employee : Persistent state
        emp.setName("Suryadeep");

        tx.commit();

        session.close();
        // Employee : Detached state
        emp.setName("Tushar Bharti");
        System.out.println(emp);

        sf.close();
    }
}
