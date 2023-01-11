package com.JYSHS.AfterSchool;

import com.JYSHS.AfterSchool.aggregate.user.UserVO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class AfterSchoolApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		String [] beanNames = context.getBeanDefinitionNames();
		System.out.println(Arrays.toString(beanNames));

		SpringApplication.run(AfterSchoolApplication.class, args);
		System.out.println("Server is running. AfterSchool.");;

	}

}
