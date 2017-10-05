package com.atuldwivedi.learn.hibernate.mapping.onetoone.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestOneToOneUniDirectionalMapping {

	private static SessionFactory sessionFactory;

	private static Session session;

	public static void main(String[] args) {

		sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Trainer.class)
				.addAnnotatedClass(TrainerDetail.class).buildSessionFactory();

		try {
			saveTrainer();
			getTriner();
			deleteTrainer();

			 getTrainerDetail();
			 deleteTrainerDetail();
			
			deleteAllTrainers();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

	public static void saveTrainer() {
		Trainer trainer = new Trainer("Atul Dwivedi", "9110460027");
		TrainerDetail trainerDetail = new TrainerDetail("atul.wnw@gmail.com", "adwivedi");
		trainer.setTrainerDetail(trainerDetail);

		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(trainer);
		session.getTransaction().commit();

	}

	public static void getTriner() {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Trainer trainer = session.get(Trainer.class, 2l);
		System.out.println("\n" + trainer);
		session.getTransaction().commit();

	}

	public static void deleteTrainer() {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Trainer trainer = session.get(Trainer.class, 1l);
		System.out.println("\n" + trainer);

		if (trainer != null) {
			// this will also delete TrainerDetail
			session.delete(trainer);
		}
		session.getTransaction().commit();
	}

	public static void getTrainerDetail() {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		// this will not fetch associated trainer
		TrainerDetail trainerDetail = session.get(TrainerDetail.class, 1l);
		System.out.println("\n" + trainerDetail);
		session.getTransaction().commit();
	}

	public static void deleteTrainerDetail() {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		TrainerDetail trainerDetail = session.get(TrainerDetail.class, 1l);
		System.out.println("\n" + trainerDetail);

		if (trainerDetail != null) {
			// this will fail because of constraint violation
			session.delete(trainerDetail);
		}
		session.getTransaction().commit();
	}

	public static void deleteAllTrainers() {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.createQuery("delete from Trainer").executeUpdate();
		session.getTransaction().commit();
	}
}
