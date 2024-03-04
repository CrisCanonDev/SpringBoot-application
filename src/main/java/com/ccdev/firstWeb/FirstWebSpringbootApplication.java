package com.ccdev.firstWeb;

import com.ccdev.firstWeb.entities.People;
import com.ccdev.firstWeb.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class FirstWebSpringbootApplication implements CommandLineRunner {

	@Autowired
	private PeopleRepository personRepository;
	public static void main(String[] args) {
		SpringApplication.run(FirstWebSpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		personRepository.save( new People(1L, "Cristhian",21));
		personRepository.save( new People(2L, "Juan",51));
		personRepository.save( new People(3L, "David",30));
		personRepository.save( new People(4L, "Salomon",12));
		personRepository.save( new People(5L, "Lorena",11));

		System.out.println("People in the table : "+ personRepository.count());

		List<People> people = personRepository.findAll();
		people.forEach(p -> System.out.println("Person's Name: "+p.getName()));


	}
}
