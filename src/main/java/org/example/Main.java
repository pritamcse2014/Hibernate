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
        student.setName("Sathi");
        student.setRollNo(190322019);
        student.setAge(15);

        Student student2 = null;

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        student2 = session.get(Student.class, 190322015);
        session.close();
        sessionFactory.close();
        System.out.println(student2);
    }
}
