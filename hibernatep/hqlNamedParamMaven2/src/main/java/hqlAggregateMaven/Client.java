package hqlAggregateMaven;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg =new Configuration();
		cfg.configure();
		System.out.println(cfg.getProperty("hibernate.connection.username"));
		SessionFactory ft=cfg.buildSessionFactory();
		Session S=ft.openSession();
		Transaction tx=S.beginTransaction();
		/*Query q=S.createNamedQuery("namedQ");
	     q.setParameter("dash", new String("ajay"));
	     List<Employee> e=q.list();
	 	for(Employee e1 : e)
	 		System.out.println(e1.getEid()+"  "+e1.getEname()+"  "+e1.getEsalary()+"  "+e1.getEadd());*/
	
		Query q1=S.createNamedQuery("greaterQ");
	     q1.setParameter(0, new Float(2000.00)
	    		 );
	     q1.setFirstResult(2);
	     q1.setMaxResults(2);
	     List<Employee> e3=q1.list();
	 	for(Employee e2 : e3)
	 		System.out.println(e2.getEid()+"  "+e2.getEname()+"  "+e2.getEsalary()+"  "+e2.getEadd());
		S.close();
	}
	}


