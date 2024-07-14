package com.OneToMany;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Address ad1= new Address(101,"Permanent Address", "Lucknow");
		Address ad2= new Address(102,"Office Address", "Delhi");
		List<Address> list= new ArrayList<>();
		list.add(ad1);
		list.add(ad2);
		Empdetails emp = new Empdetails();
		emp.setId(201);
		emp.setName("Ritesh Kumar");
		emp.setAddress(list);

		ad1.setEmpdtls(emp);
		ad2.setEmpdtls(emp);
		
		Session session= factory.openSession();
		Transaction tx= session.beginTransaction();
		
//		session.save(ad1);
//		session.save(ad2);
//		session.save(emp);
//		
//		System.out.println("Insert Successfully");
		
		//--------------Get By Employee Address Details
		
//		Empdetails emp1= (Empdetails)session.get(Empdetails.class, 201);
//		System.out.println("Emp Name ="+emp1.getName());
//		
//		for(Address ad: emp1.getAddress()) {
//			System.out.println("Address Type= "+ad.getAddressType()+", Address ="+ad.getAddress());
//		}
		
		
		//-----------Get By Address Employee Details
		Address add1= (Address)session.get(Address.class, 101);
		System.out.println("Employee Name: "+add1.getEmpdtls().getName());
		System.out.println(add1.getAddressType()+","+add1.getAddress());

		
		tx.commit();
		
		session.close();
		factory.close();
		
	}

}
