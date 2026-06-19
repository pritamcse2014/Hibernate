package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[] args) {
        Laptop l1 = new Laptop();
        l1.setId(1);
        l1.setBrand("Lenovo");
        l1.setModel("ThinkPad");
        l1.setRam(32);

        Laptop l2 = new Laptop();
        l2.setId(2);
        l2.setBrand("Dell");
        l2.setModel("XPS");
        l2.setRam(16);

        Laptop l3 = new Laptop();
        l3.setId(3);
        l3.setBrand("Hp");
        l3.setModel("ElitBook");
        l3.setRam(24);

        Alien alien = new Alien();
        alien.setId(101);
        alien.setName("Alien");
        alien.setTech("Java");

        Alien alien2 = new Alien();
        alien2.setId(102);
        alien2.setName("Alien 2");
        alien2.setTech("JavaScript");

        alien.setLaptops(Arrays.asList(l1, l2));
        alien2.setLaptops(Arrays.asList(l3));

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(l1);
        session.persist(l2);
        session.persist(l3);
        session.persist(alien);
        session.persist(alien2);
        transaction.commit();
        session.close();
        Session session2 = sessionFactory.openSession();
        Alien alien4 = session2.get(Alien.class, 101);
        System.out.println(alien4);
        session.close();
        sessionFactory.close();
    }
}
