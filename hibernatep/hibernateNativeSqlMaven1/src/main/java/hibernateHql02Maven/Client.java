package hibernateHql02Maven;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
	//add entity method
	/*SQLQuery q=S.createSQLQuery("select * from employee order by eid");
     q.addEntity(Employee.class);
	List<Employee> e=q.list();
	for(Employee e1 : e)
		System.out.println(e1.getEid()+"  "+e1.getEname()+"  "+e1.getEsalary()+"  "+e1.getEadd());*/
//add scalar method
	String query="select  ename,esalary from employee  where eid like:p1";
	SQLQuery q=S.createSQLQuery(query);
   q.setInteger("p1",2);
   q.addScalar("ename" );
   q.addScalar("esalary");
   List l=q.list();
	for(int i=0;i<l.size();i++)
	{
		Object [] ob =(Object[])l.get(i);
		
		for(int k=0;k<ob.length;k++)
		{
			System.out.println(ob[k]+"  ");
			
		}
	S.close();
}
}
}
