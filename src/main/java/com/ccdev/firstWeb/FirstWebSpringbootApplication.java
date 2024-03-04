package com.ccdev.firstWeb;

import com.ccdev.firstWeb.entities.People;
import com.ccdev.firstWeb.repository.PeopleRepository;
import com.ccdev.firstWeb.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class FirstWebSpringbootApplication implements CommandLineRunner {

	@Autowired
	private PeopleRepository peopleRepository;
	@Autowired
	private PeopleService peopleService;
	public static void main(String[] args) {
		SpringApplication.run(FirstWebSpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		peopleService.createPerson( new People(6L, "Kieran",30));
		peopleService.createPerson( new People(7L, "Andrea",40));
		peopleService.createPerson( new People(8L, "Sebastian",20));
		peopleService.createPerson( new People(9L, "Daniella",23));
		peopleService.createPerson( new People(10L, "Ismael",33));

		System.out.println("People in the table : "+ peopleService.quanityOfPeople());

		List<People> people = peopleService.obtainAll();
		people.forEach(p -> System.out.println("Person's name: "+ p.getName()));

		System.out.println("Person with id 4: "+ peopleService.obtainById(4L));

		System.out.println("Deleting perons with id 10");
		peopleService.deletePerson(10L);

		System.out.println("People in the table : "+ peopleService.quanityOfPeople());





	}
}
