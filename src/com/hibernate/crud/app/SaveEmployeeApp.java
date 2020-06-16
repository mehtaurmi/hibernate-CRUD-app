package com.hibernate.crud.app;



import java.util.Date;
import java.text.ParseException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveEmployeeApp {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		
		try {
			//create and start new session
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			//create new Employee object
			String dateOfBirthStr = "01/02/1996";
			Date dateOfBirth=DateUtils.parseDate(dateOfBirthStr);
			Employee employee=new Employee("Mary","Bean","Company1",dateOfBirth);
			System.out.println("Employee Saved!"+employee);
			//add this object into session
			session.save(employee);
			
			//commit session
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			//close factory anyway
			factory.close();
		}
	}

}
