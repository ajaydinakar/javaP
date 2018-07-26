package hibernateHql02Maven;

import java.io.Serializable;

public class Employee implements Serializable{
	
	int eid;
	String ename;
	String eadd;
	float esalary;
public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public float getEsalary() {
		return esalary;
	}
	public void setEsalary(double d) {
		this.esalary = (float) d;
	}
	public String getEadd() {
		return eadd;
	}
	public void setEadd(String eadd) {
		this.eadd = eadd;
	}

public Employee(String ename, float esalary) {
	super();
	this.ename = ename;
	this.esalary = esalary;
}

public Employee() {
	super();
	// TODO Auto-generated constructor stub
}

}
