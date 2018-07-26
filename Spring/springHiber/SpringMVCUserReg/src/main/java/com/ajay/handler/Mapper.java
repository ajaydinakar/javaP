package com.ajay.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ajay.bean.User;
import com.ajay.dao.UserDaoImpl;

@Controller
public class Mapper {
	
private UserDaoImpl dao;

@Autowired(required=true)
@Qualifier(value="dao")
public void setUserdao(UserDaoImpl userdao) {
	this.dao = userdao;
}
 @RequestMapping(value="/hello")
public	ModelAndView index()
	{
	String name="paduko rey";
	 return new ModelAndView("hello","name",name );
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public	ModelAndView insert(HttpServletRequest req,HttpServletResponse res)
	{
int id=Integer.valueOf(req.getParameter("id"));
String name=req.getParameter("name");
String password=req.getParameter("password");
User p=new User();
p.setId(id);
p.setName(name);
p.setPassword(password);

this.dao.save(p);
 
	 return  new ModelAndView("success","userlist","sucessfully added username"+name);
	}
	@RequestMapping(value="/userlist")
	
	
	public	ModelAndView list(HttpServletRequest req,HttpServletResponse res)
	{

List<User> list = this.dao.list();   
	 return  new ModelAndView("listall","userlist",list);
	}
}
