package com.example.eclipse_store.Spring_Demo;

import com.example.eclipse_store.Spring_Demo.model.Root;
import com.example.eclipse_store.Spring_Demo.storage.JokesStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	@Autowired
	JokesStorage jokesStorage;

	@Bean
	public CommandLineRunner runStartUp() {
		return args -> {

		/*

			Start off by creating a root like this, and then comment it out because it has to be done only once. Root acts as an anchor that lets you to reference other objects through it.

			NOTE:
			1) If you take a look at the storage class for this application then you can notice @Read and @Write which lets one to do safe transaction in multi threading situations.

		 */
//			Root root = new Root();
//			root.setJokes(new ArrayList<>());
//			this.jokesStorage.setRoot(root);

			/*

				Just testing out if I can add or remove stuff

			 */
			this.jokesStorage.addNewJokes("this is a joke");
			System.out.println(this.jokesStorage.allJokes());
		};
	}
}
