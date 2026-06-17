package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[] args) {
        Alien alien = new Alien();
        alien.setId(101);
        alien.setName("Alien");
        alien.setTech("Java");
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Alien.class)
                .configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(alien);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
