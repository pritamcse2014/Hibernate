package org.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Laptop laptop1 = session.get(Laptop.class, 2);
        System.out.println(laptop1);
//        Laptop laptop2 = session.get(Laptop.class, 2);
//        System.out.println(laptop2);
//        session.close();
        Session session2 = sessionFactory.openSession();
        Laptop laptop2 = session.get(Laptop.class, 2);
        System.out.println(laptop2);
        session2.close();
        sessionFactory.close();
    }
}
