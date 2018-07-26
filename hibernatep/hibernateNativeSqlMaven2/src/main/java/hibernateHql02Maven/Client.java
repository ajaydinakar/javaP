package hibernateHql02Maven;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
		//add entity method
	
		
		Query q=S.getNamedQuery("test");
	   q.setInteger(0,6);
	  q.setString(1, "rohit");
	  q.setFloat(2,(float) 4500.56);
	  q.setString(3,"jambalba");
q.executeUpdate();
	
		S.close();
}
}
