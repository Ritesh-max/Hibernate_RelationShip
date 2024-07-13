package com.alpha2;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//If config file name is hibernate.xml instead of hibernate.cfg.xml then we need to declare in config method
// cfg.configure("hibernate.xml");

/*or

SessionFactory factory= new Configuration().configure("hibernate.xml").buildSessionFactory();*/


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
		/*
		 * Configuration cfg= new Configuration(); cfg.configure(); SessionFactory
		 * factory= cfg.buildSessionFactory(); System.out.println(factory);
		 */
        //SessionFactory factory= new Configuration().configure().buildSessionFactory();
        //System.out.println(factory);
        
        
        
        
        ////////////////Java Base configuration/////////////////////////
        SessionFactory factory= HibernateUtils.getSessionFactory();
        System.out.println(factory);
        
		/*
		 * Student st= new Student(); st.setId(1); st.setName("Ritesh");
		 * st.setEmail("riteshjha563@gmail.com"); st.setAddress("India");
		 * 
		 * Session session= factory.openSession(); Transaction tx=
		 * session.beginTransaction(); session.save(st); tx.commit(); session.close();
		 */
        Employee emp = new Employee();
        emp.setEmpName("Pravin Kumar Pathak");
        emp.setEmail("prav.pathak@gmail.com");
        emp.setSalary(96000.00);
        emp.setJoiningDate(new Date());
        emp.setStatus(true);
        emp.setToken("1233ersddddf");
        
        Session session= factory.openSession();
        Transaction tx= session.beginTransaction();
        session.save(emp);
        tx.commit();
        session.close();
    }
}
