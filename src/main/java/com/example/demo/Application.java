package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		// Retrieve beans from the context
		FirstBean firstBean = context.getBean(FirstBean.class);
		SecondBean secondBean = firstBean.getSecondBean();
		ThirdBean thirdBean = secondBean.getThirdBean();

		// Display the message
		System.out.println(thirdBean.getMessage());

		// Close the context
		context.close();
	}
}
