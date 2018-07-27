package com.bjsxt.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class HibernateORMappingTest {
	private static SessionFactory sessionFactory;
	
	//@BeforeClass
	public static void beforeClass() {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(registry);
	}
	//@AfterClass
	public static void afterClass() {
		sessionFactory.close();
	}
	
	
	
	@Test
	public void testSchemaExport() {
		new SchemaExport(new Configuration().configure()).create(false, true);
	}
	
	public static void main(String[] args) {
		beforeClass();
	}
}
