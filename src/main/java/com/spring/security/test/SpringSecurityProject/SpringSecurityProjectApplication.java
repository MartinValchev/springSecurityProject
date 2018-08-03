package com.spring.security.test.SpringSecurityProject;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSecurityProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityProjectApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}
}
