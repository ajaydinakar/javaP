package com.ajay.client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ajay.bean.Employee;



public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg =new Configuration();
		cfg.configure();
		System.out.println(cfg.getProperty("hibernate.connection.username"));
		SessionFactory ft=cfg.buildSessionFactory();
		Session S=ft.openSession();
		Transaction tx=S.beginTransaction();
		Query q=S.createQuery("from Employee");
		List l=q.list();
		for(int i=0;i<l.size();i++)
		{
			Employee e1 =(Employee)l.get(i);
			System.out.println(e1.getEid()+e1.getEname()+e1.getEsalary());
		}
	/*	Employee e1=new Employee();
		e1.setEid(5);
		e1.setEname("shashank");
		e1.setEsalary(6909.98);
		e1.setEadd("amsterkatta");
		S.save(e1);
		tx.commit();*/
	/*	Employee e1 =(Employee)S.load(Employee.class, new Integer(1));
		System.out.println(e1.getEname());
		System.out.println(S.contains(e1));*/
		/*S.evict(sb);
		System.out.println(S.contains(sb));*/
		S.close();
	}

}
