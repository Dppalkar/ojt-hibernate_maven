package com.hibernate.product.configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.product.entity.Product;

public class Configurationhibernate {
	
	public  static SessionFactory getsessionFactory() {
		
		Configuration configuration=new Configuration();
		configuration.configure().addAnnotatedClass(Product.class);
		SessionFactory sessionFactory= configuration.buildSessionFactory();
		
	return sessionFactory;

		
	}

}
   