# JPA

Jakarta Persistence API is a SPECIFICATION about database CRUD operations. The main advantage of using this is to prevent being vendor locked to a specific database. 

# JPA Providers

The specification that JPA mentions can be implemented by a lot of JPA providers like hibernate and eclipseLink. 

# JDBC 

This is the actual low level sql code to manipulate the database. All JPA providers implement this underneath, which means, JPA is just a higher level abstraction to JDBC.

# CommandLineRunner 

It is an interface that is used to execute code after the beans are created in a spring boot application. 

IMP - it gets executed even before main application run methods finishes executing.

Uses:
- One common use case for CommandLineRunner is to parse command line arguments and configure the application based on those arguments. For example, you might use CommandLineRunner to set a default value for a configuration property if it is not provided as a command line argument, or to enable or disable certain features of the application based on command line arguments.
- Another use case for CommandLineRunner is to perform any one-time tasks that need to be run after the application has started, but before it is fully ready to handle requests. For example, you might use CommandLineRunner to initialize a database or load data into the application.
- Need to add some additional logger information
- Schedule a batch job
- Database operation i.e. cleanup script, status update

# Setting up Database connection:

To connect to a database, what you need is a low-level JDBC package and JPA provider.
Most of the configurations are automatically executed by spring container like making EntityManager etc provided by JPA providers.

You need to set up the url in application.properities, with username and password.

This is almost similar to how we used DynamicPropertySource to set our database connections dynamically with testcontainers. We set the uri, username and password.

# About this project

The database schema used for this project can be found under database folder.
