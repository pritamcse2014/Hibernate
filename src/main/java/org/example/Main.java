package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[] args) {
        Student student = new Student();

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        student = session.get(Student.class, 190322019);
        Transaction transaction = session.beginTransaction();
        session.remove(student);
        transaction.commit();
        session.close();
        sessionFactory.close();
        System.out.println(student);
    }
}
