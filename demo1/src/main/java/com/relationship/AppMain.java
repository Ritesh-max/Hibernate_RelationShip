package com.relationship;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AppMain {

	public static void main(String[] args) {
		SessionFactory factory= HibernateUtils.getSessionFactory();
		Address ad = new Address();
		ad.setId(101);
		ad.setAddress("Bihar");
		
		Empdetails emp= new Empdetails();
		emp.setId(201);
		emp.setName("Ritesh Jha");
		emp.setAddress(ad);
		
		ad.setEmp(emp);
		
		Session session =factory.openSession();
		Transaction tx= session.beginTransaction();
		
//		session.save(ad);
//		session.save(emp);
		System.out.println("Details from Employee Table");
		Empdetails emp1=session.get(Empdetails.class, 201);
		System.out.println(emp1.getName());
		System.out.println(emp1.getAddress().getAddress());
		
		
		System.out.println("Details from Address Table");
		Address ad1= session.get(Address.class, 101);
		System.out.println(ad1.getAddress());
		System.out.println(ad1.getEmp().getName());
		tx.commit();
		session.close();
		System.out.println("Insert Successfully");
		
		factory.close();
	}

}
