package com.hibernate.crud.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadEmployeeApp {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		
		try {
			//create and start new session
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve Employee by primary key
			int empId = 1;
			Employee employee=session.get(Employee.class, empId);
			System.out.println("Primarykey(Employee ID):"+empId+"\n Employee:"+employee);
			
			
			//commit session
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}finally {
			//close factory anyway
			factory.close();
		}
	}

}
