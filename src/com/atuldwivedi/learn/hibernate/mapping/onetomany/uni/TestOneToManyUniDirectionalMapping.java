package com.atuldwivedi.learn.hibernate.mapping.onetomany.uni;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestOneToManyUniDirectionalMapping {

	private static SessionFactory sessionFactory;

	private static Session session;

	public static void main(String[] args) {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Course.class)
				.addAnnotatedClass(Assignment.class).buildSessionFactory();
		session = sessionFactory.getCurrentSession();

		saveCourse();

		getCourse();
		
		deleteCourse();
		
		getAllCourses();
	}

	private static void getAllCourses() {

		try {
			session.beginTransaction();
			List<Course> courses = session.createQuery("from Course").getResultList();
			System.out.println(courses);
			session.getTransaction().commit();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	private static void saveCourse() {

		try {
			session.beginTransaction();

			// create assignments for course
			Assignment assign01 = new Assignment("Write code for login flow.");
			Assignment assign02 = new Assignment("Write code to take input from user and save in database.");

			List<Assignment> assignemnts = new ArrayList<Assignment>();
			assignemnts.add(assign01);
			assignemnts.add(assign02);

			// create course
			Course course = new Course("Java Frameworks2", assignemnts);

			// save the course
			long coursePk = (long) session.save(course);
			System.out.println(coursePk);

			session.getTransaction().commit();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	private static void getCourse() {

		try {
			session.beginTransaction();

			Course course = session.get(Course.class, 1l);
			System.out.println(course);
			
			session.getTransaction().commit();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	
private static void deleteCourse() {

	try {
		session.beginTransaction();

		Course course = session.get(Course.class, 3l);
		System.out.println(course);
		
		session.delete(course);
		
		session.getTransaction().commit();
	} finally {
		session.close();
		sessionFactory.close();
	}

	}
}
