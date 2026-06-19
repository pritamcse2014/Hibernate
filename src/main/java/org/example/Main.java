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

        Alien alien = new Alien();
        alien.setId(101);
        alien.setName("Alien");
        alien.setTech("Java");
        alien.setLaptops(Arrays.asList(l1, l2));

        l1.setAlien(alien);
        l2.setAlien(alien);

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(l1);
        session.persist(l2);
        session.persist(alien);
        transaction.commit();

        Alien alien2 = session.get(Alien.class, 101);
        System.out.println(alien2);
        session.close();
        sessionFactory.close();
    }
}
