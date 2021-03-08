package com.app.entity;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Test {

	private static SessionFactory sessionFactory = null;

	static {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder registry = new StandardServiceRegistryBuilder();
		registry.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = registry.build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	Scanner sc = new Scanner(System.in);

	public void insert() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		boolean flag = Boolean.FALSE;
		System.out.println("How many employee");
		int noofemp = sc.nextInt();
		for (int i = 0; i < noofemp; i++) {
			Employee employee = new Employee();
			System.out.println("Enter name");
			employee.setName(sc.next());
			System.out.println("Enter mobile");
			employee.setMobile(sc.next());
			session.save(employee);
		}
		tx.commit();
		flag = tx.wasCommitted();
		if (flag) {
			System.out.println("Success");
		} else {
			System.out.println("failure");
		}
		session.close();
	}

	public void select() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		List<Employee> list = criteria.list();
		list.forEach(System.out::println);

	}
	
	public void update() {
		select();
		System.out.println("select employee id for record");
		int id=sc.nextInt();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Employee employee=(Employee) session.get(Employee.class,id);
		System.out.println("Enter name");
		employee.setName(sc.next());
		System.out.println("Enter mobile");
		employee.setMobile(sc.next());
		session.update(employee);
		tx.commit();
		tx.wasCommitted();
		System.out.println("Successful");
	}
	
	public void delete() {
		select();
		System.out.println("select employee id for delete");
		int id=sc.nextInt();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Employee employee=(Employee) session.get(Employee.class, id);
		session.delete(employee);
		tx.commit();
		tx.wasCommitted();
		System.out.println("Successful");
		
	}
	
	public static void main(String[] args) {
		Test t=new Test();
		//t.insert();
		//t.select();
		//t.update();
		t.delete();
	}
}
