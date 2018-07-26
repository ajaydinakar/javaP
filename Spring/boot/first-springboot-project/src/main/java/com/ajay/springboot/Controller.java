package com.ajay.springboot;
import com.ajay.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@Autowired
	private WelcomeService myservice;
	@RequestMapping("/welcome")
	public String welcome()
	{
		return myservice.service();
		
	}
	
	

}
