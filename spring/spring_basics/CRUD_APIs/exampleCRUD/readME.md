
Note: Since the tutorial had two projects within one section I have combined them both here. Student is a basic introduction and employees is the whole done api endpoint example.

The database script can be found under resources and the database configurations are made in the application.properities file. Similar to what I did under hibernate section.

# JSON Data binding (Java POJO):

Alias:
    1) Serialization/ Unserialization
    2) Marshalling / Unmarshalling 
    3) Mapping

It is basically converting our json to objects of its java class and back. 

POJO - Plain Old Java Object.

```java
// pojo:
class teacher {
    String name;
    String age;
    String sub;
}

// JSON
{
    "name": "suvarna",
    "age": 57,
    "sub": "english"
}
```

# Jackson (JSON package for serialization and unserialization):

Provided by `spring-starter-web`

It is built into spring, and you don't have to convert your class objects to json before getting or returning them.

# Path Variables:

Parameterizing our endpoints to accept data.

```aidl

\test\students\{studentID}

studentID is a path variable

```

You can also append data to the end of your url like
```java

{@/employees/show-form-update(employeeId=${tempEmployee.id})}

employeeId gets appended to the end of the url.
```

Annotate with @PathVaribale(<optional_endpoint_variable_name>) 

# Request Body

Annotation - @RequestBody 

This converts the JSON input to the appropriate POJO class.

```aidl
\\ example
@PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee)
```

Make sure that the JSON key is same as the attribute names.


# REST exception handling:

Process:
1) Create a custom error response class.

A simple pojo to carry our json error message back.

2) Create a custom exception class.

Custom Error Handling, inherit RuntimeException class and then call super constructors

3) Update the REST service to throw exception if student not found.

Create a new student exception class if errorsome situation arises. 

4) Add an exception handler using @ExceptionHandler

```java
// syntax:

import org.springframework.web.bind.annotation.ExceptionHandler;

@ExceptionHandler

// it returns a response entity to give the developers more control over how exactly the error response must be like.
// it takes in a parameter of the object of exception class it must catch.
public ResponseEntity<studentErrorResponse> handleException(studentExcpetion exc) {
    //body
}

```

Annotate with @ExceptionHandler.

Catch the appropriate exception class object.

Initiate an object of student error response, and set the values and return it.

# REST Global Exception Handling

Promotes the use of global exception handlers.

1) Centralized exception handling

## Annotation - @ControllerAdvice 

It implements real time use of AOP (refer what AOP is below)

It is kinda like a filter or interceptor.

- It preprocesses our requests.
- It postprocesses our response.

## Development Process:
1) Annotate a class with @ControllerAdvice
2) Add exception handling code to that class

# Aspect Oriented Programming:

It's good when you want to apply the same logic in many disparate places of your codebase. AOP lets you "declare" the rules and then let the aspect weaving system apply those rules in all the right places.

AOP has the downside of being "magic" that isn't clearly present in the code that the developer sees. To understand the behavior of the system, the developer has to be aware that the aspect weaving is taking place.

So AOP is a tradeoff. It can reduce the maintenance burden of the code, at the risk of potentially making the system harder to understand and certainly making the build or load time behavior more complex.

## example

Let's say you want your code to log every time it enters a function and every time it leaves a function, for every single function in your codebase. How can you do that? Obviously, you could tediously write those statements at the beginning and end of every function. You could look carefully for things like early return and make sure to log in those places as well. But that's a lot of work and a huge maintenance headache.

AOP provides a way to declaratively say that you want to add those logging statements at those locations, and it will automatically rewrite your code to do that. It might be done as part of compilation or it might be done as your code is loaded into the running process. So you get the benefit of the logging without the maintenance burden of having a ton of logging statements at the start and end of your functions.

Logging is perhaps the most obvious case because of its extremely cross-cutting nature. AOP can also be used for e.g. authorization checks. You can indicate that certain functions should, before executing, verify that the user can actually perform the desired action. If they can't, then the function should throw. Again, this is a cross-cutting concern that you would prefer to centralize in some way.

# REST API DESIGN

1) Review requirements

2) Identify the main resource/entity

The most prominent noun in the list of requirements. 

requirements:
```aidl
1) Create an employee
2) Get a specific employee
3) Update an employee
```

prominent noun = employee

By convention use the plural - employees.

3) Use HTTP methods to assign action on resource

```aidl
Prominent noun = sensors

BAD CONVENTION - To create a new sensor
/addSensor

CORRECT CONVENTION - Use POST to create new sensor
POST - /sensors
```

Example:

```aidl
POST ---> /employees ---> Create a new employee
GET ---> /employees ---> Read a list of employees
GET ---> /employees/{employeeId} ---> Read a single employee
PUT ---> /employees/{employeeId} ---> Update an existing employee
DELETE ---> /employees/{employeeId} ---> Delete an existing employee
```

## When you use GET VS POST:

GET is used when you enter an URL through an `<a>` tag, or any way where you would visit it through typing on the addressbar.

POST is used when you send something through a **form**.

# Service Layer

- Service Facade design pattern.
- Intermediate Layer for custom business logic
- Integrate data from different sources.

```aidl
Employee Rest Controller could interact with an Employee Service that can poll results from Employee DAO, Skills DAO, Payroll DAO.

```

@Service - Does things similar to @Component but eventually in the future, new features could be released.

## Best practice

It is the service layer's responsibility to manage transactions. All @Transaction annotation on DAO methods must be replaced to service impl.

Ideally, Service layer (Manager) represents your business logic and hence it should be annotated with @Transactional.

Service layer may call different DAOs to perform DB operations. Lets assume a situation where you have 3 DAO operations in a service method. If your 1st DAO operation failed, other two may be still passed and you will end up with an inconsistent DB state. Annotating Service layer can save you from such situations.

# Jpa Repository:

It is an interface provided that can be used to perfom database actions. It contains a lot of predefined methods and supports transaction out of the box! So we don't have to enter @Transaction manually.

Custom methods - methods of your own:
1) Write raw sql queries yourself ---> @Query(value=<sql>)
2) The method names are parsed to create queries for you automatically.

```java

public List<Employee> findAllByOrderByLastNameAsc();

// retrieves all employees and then orders them by last name

```

# Spring Data REST:

This maven dependency scans your project and finds the appropriate entities and gives you the REST code for them without you having to code them out like I have done in this project (DAO - SERVICE - REST, after this dependency, you just need the DAO with Jpa Respository).

You could set the base api route for auto generated endpoints in your application.properities file.

## Convention:
The REST url is created with the plural form of the entity class name and also the first character converted to lower case.

Example:
```aidl
Employee ---> Entity class

\employees ---> REST endpoint created.
```

Do not send id in the JSON body!! These auto generated endpoints ignore them and only take Id from the url.

```aidl
spring.data.rest.base-path = /restApi
```

## HATEOAS Format (Hypertext as the Engine of Application State):

When the auto generated REST services are accessed then they reply in a format that is HATEOAS compliant.

## Configuration:

Since by default spring, pluralizes the entity name, it might be helpful for the cases like goose etc and what if you want a completely new name? 

All you have to do is annotate the Respository with 

```aidl
@RespositoryRestResource(path="<your-custom-name>")
```


## Features

This also exposes a lot of pre-defined features like pagination, sorting etc.

### Pagination:

By default, the generated api only returns 20 results and rest can be accessed by increasing the page number.

```aidl
bot\employees?page=0 ---> ?page=1
```

To change the default page size go to application.properities and then

```aidl
spring.data.rest.default-page-size= <new-page-size>
```

### Sorting

You can sort the entity data by their attributes (default - ascending)

```aidl

for descending
\employees?sort=firstName,desc
```

# To render the error pages - according to specific exception

To do that you would have to make a custom Error Controller.
Please refer to obsidian for it