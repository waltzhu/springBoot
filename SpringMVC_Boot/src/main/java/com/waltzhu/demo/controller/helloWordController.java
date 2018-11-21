package com.waltzhu.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWordController {
   
	@RequestMapping("helloWorld")
	public String helloWorld(){
		return "hello world! 123";
	}
}
