package hqlAggregateMaven;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class Client {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg =new Configuration();
		cfg.configure();
		System.out.println(cfg.getProperty("hibernate.connection.username"));
		SessionFactory ft=cfg.buildSessionFactory();
		Session S=ft.openSession();
		Transaction tx=S.beginTransaction();
		Query q=S.createQuery("select e.ename,e.esalary from Employee as e where e.eid=?");
	      q.setParameter(0, new Integer(2));
		List <Object[]>l=q.list();
		Object[] ob=l.get(0);
		System.out.println(ob[0]);
		System.out.println(ob[1]);
		S.close();
	}
	}


