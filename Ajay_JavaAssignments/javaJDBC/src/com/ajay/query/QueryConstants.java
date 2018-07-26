package com.ajay.query;

public interface QueryConstants {
	
	String CREATE_QUERY="create table stu(sno number(5),sname varchar2(20),sadd varchar2(20))";
	String INSERT_QUERY0="insert into stu values(1,'ajay','kovvur')";
	String INSERT_QUERY1="insert into stu values(2,'nikhil','warangal')";
	String INSERT_QUERY2="insert into stu values(3,'bhu','kaval')";
	String INSERT_QUERY3="insert into stu values(4,'krishna','bang')";
	String INSERT_QUERY4="insert into stu values(5,'sharat','hyd')";
    String UPDATE_QUERY="Update student set sname='karan' where sno=5" ;
    String SELECT_QUERY="select * from stu";
    String PINSERT_QUERY="insert into stu values(?,?,?)";
}