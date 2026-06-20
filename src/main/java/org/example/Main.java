package org.example;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
//        Query query = session.createQuery("from Laptop");
//        Query query = session.createQuery("from Laptop where ram = 64");
//        Query query = session.createQuery("from Laptop where brand like 'ASUS'");
        String brand = "ASUS";
//        Query query = session.createQuery("from Laptop where brand like ? 1");
//        Query query = session.createQuery("select model from Laptop where brand like ? 1");
        Query query = session.createQuery("select brand, model from Laptop where brand like ? 1");
        query.setParameter(1, brand);
//        java.util.List<Laptop> laptops = query.getResultList();
        java.util.List<Object[]> laptops = query.getResultList();
        for (Object[] laptop : laptops) {
            System.out.println((String)laptop[0] + " " + (String)laptop[1]);
        }
//        java.util.List<String> laptops = query.getResultList();
//        java.util.List<String[]> laptops = query.getResultList();
//        Laptop laptop = session.get(Laptop.class, 3);
        System.out.println(laptops);
        session.close();
        sessionFactory.close();
    }
}
