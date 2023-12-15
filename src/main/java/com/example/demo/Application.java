package com.example.demo;

import com.example.demo.config.AppConfig;
import com.example.demo.services.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		MyService myService = context.getBean(MyService.class);

        // Виклик методу, який викликає аспект beforeMyServiceMethods
        myService.simpleMethod();

        // Виклик методу, який викликає аспект afterMethodsWithResponseBody
        myService.methodWithResponseBody();

        // Виклик методу, який викликає аспект afterReturningMethodsWithStringArgument
        try {
            myService.methodWithException("Test Input");
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }


        // Виклик методу, який викликає аспект afterThrowingMethodsWithStringArgument

//		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
//
//		// Retrieve beans from the context
//		FirstBean firstBean = context.getBean(FirstBean.class);
//		SecondBean secondBean = firstBean.getSecondBean();
//		ThirdBean thirdBean = secondBean.getThirdBean();
//
//		// Display the message
//		System.out.println(thirdBean.getMessage());
//
//		// Close the context
//		context.close();
    }
}
