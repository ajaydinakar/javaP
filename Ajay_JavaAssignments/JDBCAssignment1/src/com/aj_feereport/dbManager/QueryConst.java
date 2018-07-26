package com.aj_feereport.dbManager;

public interface QueryConst {
	
	String CREATE_Admin="create table admin(name varchar2(20),pwd varchar2(20))";
	String CREATE_Accountant="create table actnt(id number(1) ,name varchar2(20),pwd varchar2(20),email varchar2(20),phone varchar2(11))";
	String CREATE_Student="create table stu(roll number(1) ,name varchar2(20),email varchar2(20),course varchar2(20),fee number(11),paid number(11),due number(11),sadd varchar2(20),city varchar2(20),state varchar2(20) ,country varchar2(20),phone varchar2(11))";
	String INSERT_Admin="insert into admin values('admin','password')";
	String INSERT_QUERY0="insert into stu values(1,'ajay','kovvur')";
	String INSERT_QUERY1="insert into stu values(2,'nikhil','warangal')";
	String INSERT_QUERY2="insert into stu values(3,'bhu','kaval')";
	String INSERT_QUERY3="insert into stu values(4,'krishna','bang')";
	String INSERT_QUERY4="insert into stu values(5,'sharat','hyd')";
    String UPDATE_QUERY="Update student set sname='karan' where sno=5";
    String SELECT_QUERY="select * from stu";
    String PINSERT_QUERY="insert into stu values(?,?,?)";

}
