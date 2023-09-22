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

Annotate with @PathVaribale(<optional_endpoint_variable_name>) 

# REST exception handling:

Process:
1) Create a custom error response class.

A simple pojo to carry our json error message back.

3) Create a custom exception class.

Custom Error Handling, inherit RuntimeException class and then call super constructors

4) Update the REST service to throw exception if student not found.

Create a new student exception class if errorsome situation arises. 

5) Add an exception handler using @ExceptionHandler

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