
# Description

Spring is the package that lets us build web applications, spring boot is a framework that lives on top of spring so the developers do not have to manually set the configurations all the time.

Maven is a project build tool, that will automatically take care of all your dependencies.

# How to start ?

Go to spring initializer website and select the options you want and then download the file. Open it with intellj to automatically install the dependencies.

# Spring core

- beans
- core
- Spel
- context

# infrastructure

- AOP (aspect oriented programming)
- Aspects (makes certain features available to the entire app)
- Instrumentation
- Messaging

# Data access layer

- JDBC
- ORM (object relational mapper) (lets you hook up with JDBC and hibernate)
- Transactions
- OXM
- JMS (java message service) (Helps to send async messages to the message broker)

# Web layer

- Servlet
- websocket
- web

# Test layer

- Unit
- integration
- Mock

# Spring projects

Spring is the base code framework and it has a lot of different addons depending on the type of projects that one might be doing. Example, spring security - to make your app secure, spring cloud - to make cloud services etc.

When you build these code, you can get a JAR or WAR file. JAR file has a Tomcat server built into it and WAR file doesn't. If you are going to deploy your java code, then having a tomcat server built in is no use.
# Maven

Maven is like pip tool, you specify what dependencies you need for your project and it makes it available for you. It reads the .pom file and checks if the dependencies are present in your local machine, if not then maven's remote repository is looked up to get the appropriate jar files and then it stores it in the local cache as well. 
