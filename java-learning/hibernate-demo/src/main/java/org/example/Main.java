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
         try (SessionFactory sf = cfg.buildSessionFactory();
              Session session = sf.openSession()) {

             Transaction tx = session.beginTransaction();

             Student s1 = new Student();
             s1.setRollNo(101);
             s1.setName("Tony");
             s1.setAge(30);

             session.persist(s1);

             tx.commit();
             System.out.println("Student saved successfully!");
         } catch (Exception e) {
             e.printStackTrace();
         }

    }
}
