package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
		
	public static SessionFactory getSessionFactory(){
		Configuration config=new Configuration();
		config.configure();
		System.out.println("Configuration loaded");
			
		SessionFactory sf=config.buildSessionFactory();
		System.out.println("SessionFactory created");
		return sf;
	}
}