package com.atuldwivedi.learn.hibernate.caching.firstlevel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PersonDaoApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-cfg.xml")
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Person person = new Person("Atul", 25, "Male");
//            session.save(person);
            Person p1 = session.get(Person.class, 1L);
            Person p2 = session.get(Person.class, 1L);
            session.evict(p1);
            Person p3 = session.get(Person.class, 1L);
            System.out.println(session.contains(p3));
            session.clear();
            Person p4 = session.get(Person.class, 1L);
            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
