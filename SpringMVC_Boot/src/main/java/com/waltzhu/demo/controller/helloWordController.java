package com.waltzhu.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
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
	
	@RequestMapping("testGetInner")
	public String testGetInner(HttpServletRequest hsrq, HttpServletResponse hsrp){
		String access_token=hsrq.getHeader("access_token");
	 	return access_token;
	}
	
	//使用Get方式请求
	@RequestMapping("testGet")
	public String testGet(String cityName) {
		RestTemplate restTemplate=new RestTemplate();
        String uri="http://localhost:8080/testGetInner";
        HttpHeaders headers = new HttpHeaders();
        headers.add("access_token", "123456789");
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String strbody=restTemplate.exchange(uri, HttpMethod.GET, entity,String.class).getBody();
        return strbody;
    }

 
	
}
