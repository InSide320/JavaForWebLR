package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		// Load the context from XML
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		// Retrieve beans from the context
		FirstBean firstBean = (FirstBean) context.getBean("firstBean");
		System.out.println(firstBean.getSecondBean().getThirdBean().getMessage());
		SecondBean secondBean = firstBean.getSecondBean();
		ThirdBean thirdBean = secondBean.getThirdBean();

		ThirdBean thirdBeans = new ThirdBean();
		System.out.println(thirdBeans.getMessage());

		// Display the message
		System.out.println(thirdBean.getMessage());
	}
}
