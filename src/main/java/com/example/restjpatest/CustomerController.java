package com.example.restjpatest;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {

	@Autowired
	CustomerRepository repository;

	private static final Logger log = LoggerFactory.getLogger(RestJPATestApplication.class);

	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "firstName", defaultValue= "Dr.") String firstName, 
			@RequestParam(value = "lastName", defaultValue= "Who") String lastName) 
	{

		Customer newCustomer = new Customer(firstName, lastName);
		repository.save(newCustomer);
		
		String response = "Ola " + firstName + " " + lastName;
		
		String oldVisitors = "";
		for (Customer customer : repository.findAll()) {
			log.info(customer.toString());
			oldVisitors = oldVisitors + customer.toString() + "<br>";
		}
		log.info("");
		
		response = response + "<br>já estiveram aqui:<br>";
		
		return response + oldVisitors;
	}
}
