package com.example.FullStack_Projecy_java;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class FullStackProjecyJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullStackProjecyJavaApplication.class, args);
	}

}
