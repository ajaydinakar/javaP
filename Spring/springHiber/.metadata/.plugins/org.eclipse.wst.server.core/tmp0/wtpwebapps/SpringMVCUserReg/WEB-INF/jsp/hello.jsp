<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import= "java.util.*" %>
    
    <% out.println(new Date()) ;%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>
	<legend>Registration form</legend>
    <form action="./insert" method="post">
	Id:<input type="text" name="id"><br>
	Name:<input type="text" name="name">
	Password:<input type="text" name="password">
	<input type="submit" name="button"  value="Insert">

</form>
</fieldset>
<a href="Index.jsp">Home</a>
<a href="./userlist">List of all users</a>
</body>
</html>