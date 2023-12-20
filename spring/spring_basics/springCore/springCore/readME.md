# Inversion of Control - a design pattern

Dependency Injection is a more specific sub-branch of Inversion of Control where you don't specifically say what dependency you are going to use. Specifying that your app uses IoC tarnishes its value. https://stackoverflow.com/questions/3058/what-is-inversion-of-control

Remember the time when we learnt to build a hotel api in golang and thus implemented an upper level interface that removes direct dependence on the lower level database kind we would be using. Thus no matter if its MS-SQL or SQLITE3, the interface guarantees that it performs certain pre-defined functions. 

In this example, we have implemented, a coach interface that can take various types of specific sport coaches - cricket coach, football coach etc.

There are a few ways you could inject dependencies
1) Constructor injection - Required dependencies
2) Setter injection - Optional depencies.

NOT RECOMMENDED:
1) Field Injections - sets the dependency directly to the variable and makes it harder to unit test and thus its mostly used in legacy projects.

# Java bean

A bean is a standard java building block for your app. It is any class that does the following

1) Implements the serializable interface
2) No public constructor - ie.. zero arguments
3) has properties that use set/get - for example "foo" ---> "getFoo()"

## Spring Bean

In spring, a bean is how you initialize a third party client to work with spring container. A third party class would not be specified with @Component, how to make it availiable to the container? User @Configuration and @Bean - refer swimCoach.

@Bean annotation is used on methods to specify that the object returned by the method is a bean to be managed by spring context. It is usually declared in @Configuration classes.

# Okay so, is spring bean a java bean?

short answer: No

long answer:

1) Spring beans are objects managed by spring container - inversion of control.
2) They do not always implement the serializable interface
3) They can have public non-zero constructors.

# Annotations

1) @Component - this helps spring core to scan the code and auto-configure beans using classpath.
2) @Autowired - beans are automatically injected where they need to go. For example, if you have setMovieFinder, then spring container looks for a bean named "MovieFinder", if it finds one then inject. If two or more bean are found for the injection then it causes an error which can be prevented by using @Qualifier.
3) @SpringBootApplication - does the function of these three annotations
   1) @EnableAutoConfiguration - Enables spring boot's auto configuration
   2) @ComponentScan - Enables component scanning
   3) @Configuration - register extra beans.

# Component Scanning:
## Pitfalls
- Spring boot's @Component scanning only works for the primary application package for ex: springCore here (since it has the main application class). If theres any bean outside here then it won't be scanned. 
  - To specify packages to scan explicity then mention scanBasePackages under @SpringBootApplication

# Qualifiers

If two or more beans qualify for a dependency injection then we need @Qualifer. Here, we have both cricketCoach and footBallCoach? How do we know what coach to inject for the coachController? 

@Qualifer(<beanID>) 

<beanID> - string, name of the class component to be consumed but first character must be lowercase - doesn't matter what it is.

# Primary Annotation

One way to handle multiple components of same type is to use primary. This basically says - use this if multiple qualifying components are found to be injected. 

Primary has a lower priority than qualifier so if a specific qualifier component is mentioned then primary component isn't used.

In this example, I have made cricketCoach as my primary.

# Lazy initialisation

(@Lazy)

Spring container creates the bean only when it is necessary or needed. 

If you have a lot of beans, manually setting them as lazy would be a lot of work, in order to prevent that you can add these lines in the application.properities file.

```aidl
spring.main.lazy-initialization = true
```

Helps you to speed up the startup time and also only create as many objects as it is necessary.

Disadvantages - configuration issues do not show up unless its too late. Do not worry about premature optimization.

# Bean scopes and Life cycle

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)

Beans are created/initialized, they do the work, and deconstructed. You could specify hooks, corresponding to each bean lifecycle stage.

@PostContruct - executed after initialization.
@PreDestroy - executed before deconstruction.

### Singleton - default
 
Only one instance of a bean is created and all dependency injections use the same instance. It is cached in memory.

### Prototype 

Each dependency injection has a new instance of a bean created for them.
Destruction callbacks are NOT MADE for prototype beans, its upto the developers to properly dispose them after their work is done. These beans are LAZY by default. 


# References

- Autowired (https://stackoverflow.com/questions/19414734/understanding-spring-autowired-usage)
- Component vs bean (https://stackoverflow.com/questions/10604298/spring-component-versus-bean)