package com.bsn.jpaAdvancedMapping;

import com.bsn.jpaAdvancedMapping.dao.instructorDAO;
import com.bsn.jpaAdvancedMapping.entity.Course;
import com.bsn.jpaAdvancedMapping.entity.Instructor;
import com.bsn.jpaAdvancedMapping.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaAdvancedMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaAdvancedMappingApplication.class, args);
	}

	// No autowired required, when bean is used the spring container automatically injects appropriate class object
	@Bean
	public CommandLineRunner commandLineRunner(instructorDAO in) {
		return runner -> {
//			createInstructor(in);
//			findInstructor(1, in);
//			deleteInstructor(1, in);
//			findInstructorDetail(3, in);
//			deleteInstructorDetail(3, in);
//			createCoursesWithInstructor(in);
			fetchtype_demo_fetching_intructor_courses(in);
		};
	}

	private void fetchtype_demo_fetching_intructor_courses(instructorDAO in) {

		/**
		 *
		 * Overcoming pitfalls posed by lazy initialization through various ways (refer to readme)
		 *
		 */

		Instructor instructor = in.findById(1);
		System.out.println(instructor);

		// Using solution #2
		List<Course> courses = in.findCoursesByInstructorId(1);
		instructor.setCourses(courses);

		// Using solution #3
		instructor = in.findInstructorByIdWithCourses(1);

		System.out.println(instructor.getCourses());
	}

	private void createCoursesWithInstructor(instructorDAO in) {
		Instructor instructor = new Instructor("Suvarna", "narayanan", "suvarna@111.com");

		InstructorDetail instructorDetail = new InstructorDetail("suvarnaCODES", "CODING");

		instructor.setInstructorDetail(instructorDetail);

		Course tempCourse1 = new Course("Fine ass");
		Course tempCourse2 = new Course("fucking");

		instructor.add(tempCourse1);
		instructor.add(tempCourse2);

		in.save(instructor);
	}

	private void deleteInstructor(int i, instructorDAO in) {
		in.deleteID(i);
	}

	private void findInstructor(int id, instructorDAO in) {
		System.out.println(in.findById(id));
	}

	private void createInstructor(instructorDAO in) {

		Instructor instructor = new Instructor("Suvarna", "narayanan", "suvarna@111.com");

		InstructorDetail instructorDetail = new InstructorDetail("suvarnaCODES", "CODING");

		instructor.setInstructorDetail(instructorDetail);

		in.save(instructor);

	}

	private void findInstructorDetail(int i, instructorDAO in) {
		System.out.println(in.findInstructorDetailById(i).getInstructor());
	}

	private void deleteInstructorDetail(int i, instructorDAO in) {
		in.deleteInstructorDetailByID(i);
	}

}
