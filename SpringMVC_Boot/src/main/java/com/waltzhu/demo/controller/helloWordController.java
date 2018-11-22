package com.waltzhu.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waltzhu.demo.domain.user;

@RestController
public class helloWordController {
    
	@Value("${com.boot.title}")
	public String title;
	 
	@RequestMapping("helloWorld")
	public String helloWorld(){
		return "hello world! 123";
	}
	
	@RequestMapping("getUser")
	public user getUser(){
		user ur=new user();
		ur.setId("1");
		ur.setName("waltzhu");
		return ur;
	}
	
	@RequestMapping("getTitle")
	public String getTitleProperty(){
	 	return title;
	}
	
}
