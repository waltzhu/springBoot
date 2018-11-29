package com.waltzhu.demo.controller;

import java.util.UUID;

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


	    @RequestMapping(value = "/test",method = RequestMethod.GET)
	    public void demoTest(){
	        redisService.set("2","value22222");
	    } 
	    
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("sessionId");
		if (null != sessionId) { // sessionId²»Îª¿Õ
			System.out.println("main sessionId:" + sessionId);
			return "main";
		} else { // sessionIdÎª¿Õ
			return "redirect:/login";
		}
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/doLogin", method=RequestMethod.POST)
	public String doLogin(HttpServletRequest request) {
		System.out.println("I do real login here");
		HttpSession session = request.getSession();
		String sessionId = UUID.randomUUID().toString();
		session.setAttribute("sessionId", sessionId);
		System.out.println("login sessionId:" + sessionId);
		return "redirect:/main";
	} 
	
}
