package com.app;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtility {

	public static SessionFactory getSession() {
		
		Properties properties=new Properties();
		properties.setProperty("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
		properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernate-a1");
		properties.setProperty("hibernate.connection.username", "root");
		properties.setProperty("hibernate.connection.password", "root");
		properties.setProperty("hibernate.connection.dialect", "org.hibernate.dialect.MySQLDialect");
		
		Configuration cfg=new Configuration();
		cfg.setProperties(properties);
		
		cfg.addAnnotatedClass(Person.class);
		cfg.addAnnotatedClass(Pancard.class);
		
	   StandardServiceRegistryBuilder registry=new StandardServiceRegistryBuilder();
	   registry.applySettings(cfg.getProperties());
	   ServiceRegistry serviceRegistry=registry.build();
	   
	   SessionFactory sessionfactory=cfg.buildSessionFactory(serviceRegistry);
	   return sessionfactory;
	   
		
	}
}
