package com.chad.jpatutorial.CRUDapp;

import com.chad.jpatutorial.CRUDapp.dao.studentDAO;
import com.chad.jpatutorial.CRUDapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruDappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruDappApplication.class, args);
	}

	// CommandLineRunner - one of the ways to implement it

	@Bean
	public CommandLineRunner commandLineRunner (String[] args) {
		return runner -> {
			System.out.println("Hello World");
		};
	}

	// More examples of creating a comand line runner, the object is created and stored in the database.

	@Bean
	public CommandLineRunner commandLineRunner2 (studentDAO studentdao) {
		return runner -> {
			updateStudent(studentdao);
		};
	}

	private void createStudent(studentDAO studentdao) {

		Student s1 = new Student("paul", "asss", "paulasss@gmail.com");

		studentdao.save(s1);

		System.out.println("Generated ID: " + s1.getId());

	}

	private void updateStudent(studentDAO studentdao) {
		Student stu = studentdao.findById(1);
		stu.setFirstName("mydick");
		studentdao.update(stu);
	}


}
