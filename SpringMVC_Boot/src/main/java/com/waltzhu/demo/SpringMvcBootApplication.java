package com.waltzhu.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/*
 * @SpringBootApplication�����3��ע�⣺
 * @Configration ��������ʹ��spring����java������
 * @ComponentScan ���ɨ��
 * @EnableAutoConfiguration
 * (exclude={DataSourceAutoConfiguration.class,})
 */

@SpringBootApplication 
public class SpringMvcBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcBootApplication.class, args);//��������������Ӧ�ó���
	}
}
