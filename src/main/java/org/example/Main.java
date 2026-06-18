package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[] args) {
        Laptop l1 = new Laptop();
        l1.setBrand("Lenovo");
        l1.setModel("ThinkPad");
        l1.setRam(32);
        Alien alien = new Alien();
        alien.setId(101);
        alien.setName("Alien");
        alien.setTech("Java");
        alien.setLaptop(l1);
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Alien.class)
                .configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(alien);
        transaction.commit();
        Alien alien2 = session.get(Alien.class, 101);
        System.out.println(alien2);
        session.close();
        sessionFactory.close();
    }
}
