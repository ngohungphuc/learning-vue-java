package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        cfg.addAnnotatedClass(org.example.Student.class);


        // Use try-with-resources for the factory and the session
        try (SessionFactory sf = cfg.buildSessionFactory();
             Session session = sf.openSession()) {

            Transaction transaction = session.beginTransaction();

            Student s1 = new Student();
            s1.setRollNo(105);
            s1.setName("Test");
            s1.setAge(30);

            session.persist(s1);

            transaction.commit();
            System.out.println("Saved: " + s1);

        } catch (Exception e) {
            // If anything fails, the session is still closed safely
            e.printStackTrace();
        }
    }
}
