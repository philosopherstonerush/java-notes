
I have a pretty good introduction about AOP in crud_apis. Please do refer to it.

# AOP Terminology:

- Aspect: Module of code for a cross cutting concer (logging, security)
- Advice: What action is taken and when it should be applied
- Join point: When to apply code during program execution
- Pointcut: A predicate expression for where the advice should be applied

# Advice Types

- Before advice: run before the method
- After finally advice: run after the method (finally)
- After returning advice: run after the method (success execution)
- After throwing advice: run after method (if exception thrown)
- Around advice: run before and after method

# Weaving

Connecting aspects to target objects to create an advised object

- Different types of weaving
    - Compile time, load time or run time

Performance is the lowest with run time weaving

# AspectJ

Very first AOP framework that was released. Enables full support for all AOP advice types, pointcuts etc.

# Spring AOP

Spring uses run time weaving to advise objects!

You can convert them to AspectJ using @Aspect annotation

Only supports `Method-level` join points

# PointCut

Spring AOP uses AspectJ's pointcut expression language

- Execution Pointcuts :- Applies to execution methods

## Pointcut expression language:

```

execution(modifiers-pattern? return-type-pattern declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?)

```

fields with `?` is optional

### Examples

match method - addAccount from any class - with no arguments
```

execution(public void addAccount())

```

match method - updateAccount for a particular class

```

execution(public void com.bsn.tut.aop.repositories.AccountDAO.updateAccount())

```

match wildcard methods - addFakeAccount for a particular class

```

execution(public void add* ())

```

match method return type

```
The below pattern matches with any method that has any return type and also starts with count

execution(* count* ())

```

match method with parameter of Account class

```

execution(* addAccount(com.bsn.tut.aop.entity.Account))

```

match method with any number of parameters

```

execution(* addAccount(..))

```

match any method that returns any type with any arguments 

basically match by package

```
After the * for return type
first * - any class
second * - any method

execution(* com.bsn.tut.aop.repositories.*.*(..))

```

# Project setup

When starting a new project - select dependency `spring-boot-starter-aop`

If you want to add support for legacy project `@EnableAspectJAutoProxy`