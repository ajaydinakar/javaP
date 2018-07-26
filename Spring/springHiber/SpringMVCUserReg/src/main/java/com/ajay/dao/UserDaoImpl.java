package com.ajay.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ajay.bean.User;
@Repository
public class UserDaoImpl implements UserDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void save(User p) {
		System.out.println("*****************************************************************************");
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.merge(p);
		tx.commit();
		session.close();
	}
	@SuppressWarnings("unchecked")

	public List<User> list() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		List<User> personList = session.createQuery("from User").list();
		session.close();
		return personList;
	}

}
