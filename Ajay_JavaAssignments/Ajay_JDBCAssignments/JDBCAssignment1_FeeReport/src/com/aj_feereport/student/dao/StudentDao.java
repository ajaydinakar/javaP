package com.aj_feereport.student.dao;
import  com.aj_feereport.student.bean.*;
import java.util.List;

public interface StudentDao {
	int addStudent();
	void editStudent();
	List<StudentBean> viewStudents();
	void viewStudent();
	void duefee();
	

}
