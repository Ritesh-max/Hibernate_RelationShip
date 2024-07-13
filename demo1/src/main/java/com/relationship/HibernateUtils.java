package com.relationship;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
	private static SessionFactory sessionfactory;
	
	public static SessionFactory getSessionFactory() {
		
		if(sessionfactory==null) {
			Configuration configuration = new Configuration();
			Properties prop= new Properties();
			prop.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			prop.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate_db");
			prop.put(Environment.USER, "root");
			prop.put(Environment.PASS, "Ritesh@2050");
			prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
			prop.put(Environment.HBM2DDL_AUTO, "update");
			prop.put(Environment.SHOW_SQL, true);
			
			configuration.setProperties(prop);
			
			configuration.addAnnotatedClass(Empdetails.class);
			configuration.addAnnotatedClass(Address.class);

			ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		
			sessionfactory= configuration.buildSessionFactory(serviceRegistry);
		
		}
		
		return sessionfactory;
	}
}
