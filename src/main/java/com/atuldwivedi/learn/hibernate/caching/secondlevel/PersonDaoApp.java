package com.atuldwivedi.learn.hibernate.caching.secondlevel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PersonDaoApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-cfg.xml")
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();

        Session session1 = sessionFactory.openSession();
//        Person person = new Person("Atul", 25, "Male");
//        session1.save(person);
        Person p = session1.load(Person.class, 1L);
        System.out.println(p);
        session1.close();

        Session session2 = sessionFactory.openSession();
        Person p2 = session2.load(Person.class, 1L);
        System.out.println(p2);
        session2.close();

        sessionFactory.close();
    }
}
