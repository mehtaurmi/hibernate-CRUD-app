package com.hibernate.crud.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SearchEmployeeApp {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		
		try {
			//create and start new session
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve Employee for given company
			List<Employee> empList = session.createQuery("from Employee e where e.company='Company1'").getResultList();
			System.out.println("Employee with company1 are:");
			for(Employee employee:empList) {
				System.out.println(employee);
			}
		
			//commit session
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}finally {
			//close factory anyway
			factory.close();
		}
	}

}
