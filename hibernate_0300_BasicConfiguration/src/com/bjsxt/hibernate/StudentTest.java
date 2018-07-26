package com.bjsxt.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class StudentTest {
	private static SessionFactory sessionFactory;
	@BeforeClass
	public static void beforeClass() {
		// ���µ�SessionFactory������ʽ
		Configuration configuration = new Configuration().configure();
		ServiceRegistry registry =
				new ServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(registry);
	}
	@AfterClass
	public static void afterClass() {
		sessionFactory.close();
	}
	
	@Test
	public void testStudentSave() {
		Student s = new Student();
		s.setId(3);
		s.setName("zhangsan");
		s.setAge(8);
		
		
		Session session = sessionFactory.getCurrentSession();// ��ǰ�����õ�session��ʹ�ã�û���򴴽���ʹ�ú��Զ��ر�
//		Session session2 = sessionFactory.openSession();// ÿ�δ���һ���µ�session�����Զ��ر�
		
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
	}
	
	public static void main(String[] args) {
		beforeClass();
	}
	
	@Test
	public void testStudentDelete() {
		
	}
}
