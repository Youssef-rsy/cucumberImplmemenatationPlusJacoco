package com.ysf.local.cucumberImplementataion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.ysf.local.cucumberImplementataion")
public class CucumberImplementataionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CucumberImplementataionApplication.class, args);
	}

}
