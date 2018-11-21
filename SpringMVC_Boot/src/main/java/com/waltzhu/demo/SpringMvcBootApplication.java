package com.waltzhu.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/*
 * @SpringBootApplication组合了3个注解：
 * @Configration 标明该类使用spring基于java的配置
 * @ComponentScan 组件扫描
 * @EnableAutoConfiguration
 * (exclude={DataSourceAutoConfiguration.class,})
 */

@SpringBootApplication 
public class SpringMvcBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcBootApplication.class, args);//负责启动并引导应用程序
	}
}
