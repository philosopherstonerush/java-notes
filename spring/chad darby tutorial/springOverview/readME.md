
# Description

Spring is the package that lets us build web applications, spring boot is a framework that lives on top of spring so the developers do not have to manually set the configurations all the time.

Maven is a project build tool, that will automatically take care of all your dependencies.

# How to start ?

Go to spring initializer website and select the options you want and then download the file. Open it with intellj to automatically install the dependencies.

To see what the pom.xml file looks like, you can select the explore button to see the preview of it. If you just want to add the dependencies to your existing file, then you can add this way.

# Spring core

- beans
- core
- Spel
- context

# infrastructure

- AOP (aspect oriented programming)
  - mentioned in depth in CRUD_API project.
- Aspects (makes certain features available to the entire app)
- Instrumentation
- Messaging

# Data access layer

- JDBC
- ORM (object relational mapper) (lets you hook up with JDBC and hibernate)
- Transactions
- OXM
  - The OXM module provides an abstraction layer that supports Object/XML mapping implementations for JAXB, Castor, XMLBeans, JiBX and XStream.
- JMS (java message service) (Helps to send async messages to the message broker)

# Web layer

- Servlet
- websocket
- web
  - The Web module provides basic web-oriented integration features such as multipart file-upload functionality and the initialization of the IoC container using servlet listeners and a web-oriented application context.

# Test layer

- Unit
- integration
- Mock

# Spring projects

Spring is the base code framework and it has a lot of different addons depending on the type of projects that one might be doing. Example, spring security - to make your app secure, spring cloud - to make cloud services etc.

When you build these code, you can get a JAR or WAR file. JAR file has a Tomcat server built into it and WAR file doesn't. If you are going to deploy your java code, then having a tomcat server built in is no use.
# Maven

Maven is like pip tool, you specify what dependencies you need for your project and it makes it available for you. It reads the .pom file and checks if the dependencies are present in your local machine, if not then maven's remote repository is looked up to get the appropriate jar files and then it stores it in the local cache as well. 

## Maven GAV

G - Group ID
A - Artifact ID
V - Version (its important to define it for devops)

## How to find maven dependency coordinates?

1) Visit the project website (spring.io, hibernate.org)
2) go to search.maven.org

# Spring project file structure

- mvnw - maven wrapper files that automatically download maven for you if they are not found
- standard java project structure - like java main files in src/java etc
- src/main/resources/application.properities - This file is more like a config where you can set the port you want the app to run on like `server.port:8585` which runs it in port 8585 instead of 8080.
- src/main/resources/static - this folder holds all your static files like images, css, javascript etc. Spring will automatically load them for you.
- src/main/resources/templates - this is where you see all your templates present. By default spring looks for this folder and "thymeleaf" is a popular template engine.

# Spring starters

Instead of you searching and adding every single dependency spring development team have provided starter files that have the required dependencies referenced so its easier to start with.

example
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

# Spring actuator

Actuators are specific endpoints that are given to you to get extra information about the app. These endpoints are really helpful with devops.
You have to add the specific spring actuator dependency in the pom file.

By default only `\health` endpoint is exposed. To expose more endpoints refer the application.properities file.

Endpoints are prefixed by `\actuator`.


# Spring security

By adding the spring dependecny "starter-security" you automatically secure your endpoints. 

The default user: user

The default password: (gets generated when you run the app, displayed on the console)

endpoints /health and /info are still available even after you enabled security, to prevent access, disable them using exclude in application.properties

# How to run the app from command line

Option-1
1) Make a jar file using `mvn package`
2) Find your jar file and then use `java -jar <name>`

Option-2
1) `mvn spring-boot:run` 

# Spring - injecting custom properities

application.properities file could harbor new specifications or values that could be injected to the application with @value annotation

# Warning 

Do not use src/main/webapp directory if you application is packaged as a jar file, it only works with war files. Most build tools ignore this.
