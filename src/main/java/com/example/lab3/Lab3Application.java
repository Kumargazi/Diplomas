package com.example.lab3;

import com.example.lab3.entity.Address;
import com.example.lab3.entity.Users;
import com.example.lab3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Lab3Application {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(Lab3Application.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	private void testJpaMethods(){
		Address address = new Address();
		address.setCity("Kiev");
		address.setHomeNumber("4");
		address.setStreet("Main Street");
		Address address1 = new Address();
		address1.setCity("Lviv");
		Users users = new Users();
		users.setAddress(address);
		users.setEmail("someEmail@gmail.com");
		users.setName("Smith");
		userService.createUsers(users);
		Users users1 = new Users();
		users1.setName("Jon Dorian");
		users1.setEmail("gmailEmail@gmail.com");
		users1.setAddress(address1);
		userService.createUsers(users1);

		userService.findAll().forEach(it-> System.out.println(it));

		userService.findAllByName("Smith").forEach(it-> System.out.println(it));

		userService.findWhereEmailIsGmail().forEach(it-> System.out.println(it));

		userService.findWhereNameStartsFromSmith().forEach(it-> System.out.println(it));
	}
}
