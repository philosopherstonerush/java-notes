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
Most of the configurations are automatically executed by spring container like making EntityManager etc. provided by JPA providers.

You need to set up the url in application.properties, with username and password.

This is almost similar to how we used DynamicPropertySource to set our database connections dynamically with testcontainers. We set the uri, username and password.

# JPA annotations (Refer to student java class)

## IMP

- Most IDE's would generate constructors, getters/setters and stuff for you automatically. Leverage that!

## Entity class

A java class that is mapped to a database table

- Must be annotated with @Entity 
- Must have a public or private no-argument constructor
  - The class can have more constructors.

@Table("name") - specifies the name of the table - default is the class name.
@Column - Optional, maps to the name of the column, default is the name of the variable.

## Id and generation

```java
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
<column>
```

Use GenerationType.IDENTITY - Mostly you will use this for a lot of cases.

Some of the other generation types are:
    - .AUTO 
    - .SEQUENCE
    - .TABLE

custom generation:

- Create implementation of IdentifierGenerator
- override method generate()

# Data Access Object(DAO):

A "helper" class object that is created to store and retrieve information from the database.

This class implements an interface having abstract methods.

This is the object which you use methods like save(), findByName() etc

## Architectural pattern:

student DAO ---- Entity Manager ---- Data Source ---- Database

Our DAO needs an entity manager - which are created automatically by spring boot.

Data source is also automatically created by spring boot, and it gives information about the connection string.

application.properties file has information regarding this the automatic configuration.

## Steps involved in creating student DAO:

1) Define DAO interface.
2) Define DAO implementation - class that implements the DAO interface
   1) Inject the entity manager
   2) @Transactional - for spring to take care of initializing a transaction. Provide this annotation whenever you are manipulating the database.
   3) @Respository :- 
      1) Automatically registers our DAO implementation.
      2) Provides translation for any JDBC related exceptions.

# Why pass .class to entity manager?

What is .class?
It represents a class on runtime, and gives information about the class. Suppose when we have a class Student then Student.class, gives its runtime representation.

If you have an object called student that is made off Student then you get the same result by executing
`student.getClass()`

# JPQL

JPA Query Language

- It is a language to return objects.
- JPQL is based entirely on entity name and entity fields - NOT DATABASE TABLE NAME's.

```sql
FROM Student ---> finds all students objects.
DELETE FROM Student ---> Deletes all students.
UPDATE Student ---> Updates a student.
```

# Automatic database creation

Spring helps with automatic database creation, so you don't have to make those tables yourself with sql.

Define in application.properties file 
```aidl
spring.jap.hibernate.ddl-auto=PROPERTY_VALUE
```

Some PROPERTY_VALUE's are:

```aidl
none = No action will be performed.
create-only = Database tables are only created.
drop = Database tables are dropped.
create = Database tables are dropped followed by database tables creation.
create-drop = Database tables are dropped followed by database tables creation. On application shutdown drop the database tables.
validate = validate the database tables schema.
update = Update the database table schema.
```

IMP - Don't USE THESE FOR PRODUCTION OR REAL TIME PROJECTS. It is very easy to drop your production data. Instead use `sqlscripts` to manage your database.

# Hibernate SQL logging

Define it in application.properties file.

```aidl

// to log sql statements
logging.level.org.hibernate.SQL=debug 

// to log sql parameters inserted
logging.level.org.hibernate.orm.jdbc.bind=trace
```

# About this project

The database schema used for this project can be found under database folder.
