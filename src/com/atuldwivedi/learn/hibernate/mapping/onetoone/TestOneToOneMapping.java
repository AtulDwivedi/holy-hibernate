package com.atuldwivedi.learn.hibernate.mapping.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestOneToOneMapping {

	public static void main(String[] args) {

		saveTrainer();
//		getTriner();
//		deleteTriner();
//		deleteAll();
		
//		getTrinerDetail();
//		deleteTrinerDetail();
	}

	public static void saveTrainer() {
		try {
			Trainer trainer = new Trainer("Atul Dwivedi", "9110460027");
			TrainerDetail trainerDetail = new TrainerDetail("atul.wnw@gmail.com", "adwivedi");
			trainer.setTrainerDetail(trainerDetail);
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			 session.save(trainer);
			session.getTransaction().commit();

		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}

	public static void getTriner() {
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			Trainer trainer = session.get(Trainer.class, 1l);
			System.out.println("\n" + trainer);
			session.getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
	
	public static void getTrinerDetail() {
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			TrainerDetail trainerDetail = session.get(TrainerDetail.class, 2l);
			System.out.println("\n" + trainerDetail);
			System.out.println("\n" + trainerDetail.getTrainer());
			session.getTransaction().commit();
		} 
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession();
			HibernateUtil.closeSessionFactory();
		}
	}
	
	
	public static void deleteTriner() {
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			Trainer trainer = session.get(Trainer.class, 1l);
			System.out.println("\n" + trainer);
			
			if(trainer != null){
				// this will also delete TrainerDetail
				session.delete(trainer);
			}
			session.getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
	
	public static void deleteTrinerDetail() {
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			TrainerDetail trainerDetail = session.get(TrainerDetail.class, 2l);
			System.out.println("\n" + trainerDetail);
			
			if(trainerDetail != null){
				// this will also delete Trainer
				session.delete(trainerDetail);
			}
			session.getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
	
	public static void deleteAll(){
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			session.createQuery("delete from TrainerDetail").executeUpdate();
			session.getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
}
