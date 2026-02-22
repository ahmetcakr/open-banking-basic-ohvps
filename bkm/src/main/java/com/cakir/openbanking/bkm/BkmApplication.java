package com.cakir.openbanking.bkm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.cakir.openbanking.*")
public class BkmApplication {

	public static void main(String[] args) {
		SpringApplication.run(BkmApplication.class, args);
	}

}
