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

        Alien alien3 = new Alien();
        alien3.setId(103);
        alien3.setName("Alien 3");
        alien3.setTech("Python");

        alien.setLaptops(Arrays.asList(l1, l2));
        alien2.setLaptops(Arrays.asList(l2, l3));
        alien3.setLaptops(Arrays.asList(l1));

        l1.setAliens(Arrays.asList(alien, alien3));
        l2.setAliens(Arrays.asList(alien, alien2));
        l3.setAliens(Arrays.asList(alien2));

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
        session.persist(alien3);
        transaction.commit();

        Alien alien4 = session.get(Alien.class, 102);
        System.out.println(alien4);
        session.close();
        sessionFactory.close();
    }
}
