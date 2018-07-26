package hqlAggregateMaven;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;



public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg =new Configuration();
		cfg.configure();
		System.out.println(cfg.getProperty("hibernate.connection.username"));
		SessionFactory ft=cfg.buildSessionFactory();
		Session S=ft.openSession();
		Transaction tx=S.beginTransaction();
		// select * from employee
	Criteria C=S.createCriteria(Employee.class).add(Restrictions.gt("esalary", new Float(4000.00)));
	C.addOrder(Order.desc("eid"));
	List<Employee> e=C.list();
	for(Employee e1 : e)
		System.out.println(e1.getEid()+"  "+e1.getEname()+"  "+e1.getEsalary()+"  "+e1.getEadd());
		S.close();
	}
	}


