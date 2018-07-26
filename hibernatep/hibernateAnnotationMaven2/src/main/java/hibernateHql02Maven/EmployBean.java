package hibernateHql02Maven;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="employee")
public class EmployBean implements Serializable{
	@Id
	@GeneratedValue
	@Column(name="eid" ,length=5)
	int eid;
	@Column(name="ename",length=20)
	String ename;
	@Column(name="esalary",length=20)
	String eadd;
	@Column(name="eadd",length=30)
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

public EmployBean(String ename, float esalary) {
	super();
	this.ename = ename;
	this.esalary = esalary;
}

public EmployBean() {
	super();
	// TODO Auto-generated constructor stub
}

}
