package com.atuldwivedi.learn.hibernate.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	private static StandardServiceRegistry registory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {

				// Create registry builder
				StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Map<String, String> settings = new HashMap<>();
				settings.put(Environment.DRIVER, "org.h2.Driver");
				settings.put(Environment.URL, "jdbc:h2:~/HFW");
				settings.put(Environment.USER, "sa");
				settings.put(Environment.PASS, "");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");

				// Apply settings
				registryBuilder.applySettings(settings);

				// Create registry
				registory = registryBuilder.build();

				// Create MetadataSources
				MetadataSources sources = new MetadataSources(registory);

				// Create Metadata
				Metadata metadata = sources.getMetadataBuilder().build();

				// Create SessionFactory
				sessionFactory = metadata.getSessionFactoryBuilder().build();

			} catch (Exception e) {
				e.printStackTrace();
				if (registory != null) {
					StandardServiceRegistryBuilder.destroy(registory);
				}
			}
		}
		return sessionFactory;
	}
}
