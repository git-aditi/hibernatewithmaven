package com.miit.hibernateTraining;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestOneToOneFK {
	
	public static void main(String[] args) {
		Session session = null;

		try{
			SessionFactory sessionFactory = new Configuration().configure("hibernate-one-to-one.cfg.xml")
					.buildSessionFactory();
			 session = sessionFactory.openSession();
			 session.beginTransaction();
			 Certificate certificate = new Certificate();
			 certificate.setCertName("SCJP2");
			 certificate.setCode("SCJP02");
			// session.save(certificate);
			 Person person = new Person();
			 person.setId(1);
			 person.setCertificate(certificate);
			 person.setName("Pinkesh");
			 certificate.setPerson(person);
			 //ItemImage itemImage = (ItemImage)session.get(ItemImage.class, 5L);
			 //String name = itemImage.getItem().getName();
			 session.saveOrUpdate(person);
			 session.getTransaction().commit();
			 session.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally{
			// Actual contact insertion will happen at this step
			System.out.println("test");
			
			}
	}
		


}
