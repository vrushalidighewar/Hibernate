package com.app;

import org.hibernate.Session;

public class Test {

	public void save() {

		Person person = new Person();
		person.setName("ABC");
		person.setMobile("123654");

		Pancard pancard = new Pancard();
		pancard.setPanNo("AGDSJD90");

		pancard.setPerson(person);
	//	person.setPancard(pancard);

		Session session = HibernateUtility.getSession().openSession();
		session.save(pancard);

		session.beginTransaction().commit();
		System.out.println("successful");
	}

	public void selectAll() {
		HibernateUtility.getSession().openSession()
		   .createCriteria(Person.class)
		       .list()
		           .forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		Test test=new Test();
		test.save();
		test.selectAll();
	}
}
