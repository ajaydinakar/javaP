package hibernateHql02Maven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Client {

public static void main(String[] args) {
	// TODO Auto-generated method stub
	SessionFactory sessFact = Util.getSessionFactory();
	Session session = sessFact.getCurrentSession();
	org.hibernate.Transaction tr = session.beginTransaction();
	EmployBean e1=new EmployBean ();
	e1.setEid(2);
	e1.setEname("karan");
	e1.setEsalary(5030.22);
	e1.setEadd("karimnagar");
	session.save(e1);
	tr.commit();
sessFact.close();
}
}
