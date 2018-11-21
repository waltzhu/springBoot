package com.waltzhu.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.waltzhu.demo.controller.helloWordController;
 
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration  //web��Ŀ��junit��Ҫģ��serveletcontext
public class HelloWorldControlerTests {
	private MockMvc mvc;
	
	@Before
    public void setUp(){
        mvc = MockMvcBuilders.standaloneSetup(new helloWordController()).build();
    }
	 
	@Test
	public void testHelloWorld() throws Exception{
		   String url = "/helloWorld";//����url
	        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(url).accept(MediaType.APPLICATION_JSON))
	                .andReturn();
	        //���ʷ���״̬
	        int status = mvcResult.getResponse().getStatus();
	        //�ӿڷ��ؽ��
	        String content = mvcResult.getResponse().getContentAsString();
	        //��ӡ�����״̬
	        System.out.println(status);
	        System.out.println(content);
	}
}
