package com.waltzhu.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.waltzhu.demo.service.RedisService;
@RestController
public class quickRunController {
	
	   @Autowired
	    private RedisService redisService ;


	    @RequestMapping(value = "/saveredis",method = RequestMethod.GET)
	    public void demoTest(){
	        redisService.set("2","value22222");
	    } 
	    
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("sessionId");
		System.out.println("main sessionId:" + sessionId);
		if (null != sessionId) { // sessionId²»Îª¿Õ
			return "main";
		} else { // sessionIdÎª¿Õ
			return "login";
		}
	}
	 
	
}
