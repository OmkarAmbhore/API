package com.example.QuestionPro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.*"})
public class QuestionProApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionProApplication.class, args);
		System.out.println("Application started");
	}

}
