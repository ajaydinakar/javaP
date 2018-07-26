package com.ajay.simple;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("welcome")
public class WelcomeService {
	@GET
	@Path("{msg}")
	public String getMsg(@PathParam("msg")String msg )
	{
	return "welcome :"+msg;
	}
}
