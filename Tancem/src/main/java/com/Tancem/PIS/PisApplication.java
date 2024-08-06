package com.Tancem.PIS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"com.Tancem"})
public class PisApplication {

	public static void main(String[] args) {
		SpringApplication.run(PisApplication.class, args);
	}
}
