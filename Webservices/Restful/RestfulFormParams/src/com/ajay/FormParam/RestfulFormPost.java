package com.ajay.FormParam;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("welcome")
public class RestfulFormPost {
	@POST
	@Path("/add")
	public Response adduser(@FormParam("name")String name,@FormParam("password")String password)
	{
		String result="new user added with \n name:"+name+"\n password :"+password;
		return Response.status(200).entity(result).build();
	}

}
