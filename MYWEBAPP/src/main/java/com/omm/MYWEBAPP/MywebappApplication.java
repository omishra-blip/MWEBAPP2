package com.omm.MYWEBAPP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MywebappApplication {

	public static void main(String[] args) {

		SpringApplication.run(MywebappApplication.class, args);
	}

}
