package com.cakir.openbanking.hhs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.cakir.openbanking.hhs.*")
public class HhsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HhsApplication.class, args);
	}

}
