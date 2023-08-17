# Inversion of Control - a design pattern

Dependency Injection is a more specific sub-branch of Inversion of Control where you don't specifically say what dependency you are going to use. Calling your app to use IoC tarnishes its value. https://stackoverflow.com/questions/3058/what-is-inversion-of-control

Remember the time when we learnt to build a hotel api in golang and thus implemented an upper level interface that removes direct dependence on the lower level database kind we would be using. Thus no matter if its MS-SQL or SQLITE3, the interface guarantees that it performs certain pre-defined functions. 

In this example, we have implemented, a coach interface that can take various types of specific sport coaches - cricket coach, football coach etc.

There are a few ways you could inject dependencies
1) Constructor injection
2) Setter injection

# Java bean

A bean is a standard java building block for your app. It is any class that does the following

1) Implements the serializable interface
2) No public constructor - ie.. zero arguments
3) has properties that can be set/get - for example "foo" ---> "getFoo()"

# Okay so, is spring bean a java bean?

short answer: No

long answer:

1) Spring beans are objects managed by spring container.
2) They do not always implement the serializable interface
3) They can have public non-zero constructors.

# Annotations

1) @Component - this helps spring core to scan the code and auto-configure beans using classpath.
2) @Autowired - beans are automatically injected where they need to go. For example, if you have setMovieFinder, then spring container looks for a bean named "MovieFinder", if it finds one then inject. If two or more bean are found for the injection then it causes an error which can be prevented by using @Qualifier.


# References

- Autowired (https://stackoverflow.com/questions/19414734/understanding-spring-autowired-usage)
- Component vs bean (https://stackoverflow.com/questions/10604298/spring-component-versus-bean)