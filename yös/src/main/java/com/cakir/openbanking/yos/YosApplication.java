package com.cakir.openbanking.yos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.cakir.openbanking.*")
public class YosApplication {

	public static void main(String[] args) {
		SpringApplication.run(YosApplication.class, args);
	}

}
