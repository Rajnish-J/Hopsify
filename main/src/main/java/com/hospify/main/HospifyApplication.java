package com.hospify.main;

import com.hospify.main.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HospifyApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HospifyApplication.class, args);
		System.out.println("Hospify Project started");

		User user = new User();
		user.setUsername("Rajnish");

		User userOne = new User();
		userOne.setUsername("Sabari");

		System.out.println(user.getUsername());
		System.out.println(userOne.getUsername());

	}

}
