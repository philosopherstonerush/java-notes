# JPA Advanced Mapping Techniques

# One to One mapping:

Happens when one entity is associated with another entity.

```html

instructor ---> instructorDetail

```

primary key ---> foreign key constraints are applied to set up such mapping when you create database.

Suppose we have a User with address stored in a different table, then we have one-to-one mapping as :-

```java

// While defining user entity:-

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "address_id", referencedColumnName = "id")
private Address address;

```

`address_id` is a foreign key (meaning primary key of address table) in User table. 

Note, the address entity would get stored first before User as User object depends on address_id as a foreign key constraint.

CASCADE - Any operation done on this entity would affect the mapped entity as well according to the type of cascade mentioned.

CascadeTypes can be
- ALL ->  propagates all operations from a parent to a child entity.
- PERSIST -> only persist operation is propagated from parent to child entity
- MERGE -> merge operation is propagated
- REMOVE -> propagates the removal of the entity, similar to CasadeType.DELETE
- REFRESH -> rereads the value of an instance from the database, propagates this action to the child entity as well.
- DETACH -> Removes both parent and child entity from parent session

Instead of all, you could use curly brackets to only specify the operations that you want to perform.
```java

import jakarta.persistence.CascadeType;

@OneToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})

```

# Hibernate Lazy/Eager loading:

You can specify the type of fetch by `fetch` attribute by @OneToOne, @OneToMany, @ManyToOne, @ManyToMany annotations.

Lazy: 
- Default type of fetch. The associated entity is only loaded when it is accessed for the first time. Could be efficient if the entity is not used for the most part of the logic.

Eager:

- The associated entity is loaded when the parent entity is loaded.

## Best practice?

Always ensure that your program prioritizes lazy loading over eager loading.

Lazy loading actually requires you to have an open hibernate session ---> if its closed, then it throws an exception 

## pitfalls

1) Sometimes the mapping is lazy by default and then when you try to access the data you get this error --> no session, which means the hibernate session closed before you could ask for further data
```json

Caused by: org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: com.bsn.jpaAdvancedMapping.entity.Instructor.courses: could not initialize proxy - no Session


```
    - Solution #1 --> Fetch by Eager
    - Solution #2 --> Get the courses separately and then set it to the courses when accessed.
    - Solution #3 --> Instead of hardcoding fetch type eager to the fields, implement a method with a typed query to fetch the eager like result that way you can have the best of both worlds

```json

mismatched input 'FETCH' expecting

```

Make sure your typed queries are properly formatted if you concatenation to join them.

# Bi-directional Mapping

Establishes a bidirectional mapping from child entity to parent entity. 

```java

// At the child entity class

// mappedby value must be the property name from parent entity class ---> private InstructorDetail instructorDetail;
// cascade helps to propagate changes to the parent entity class.
@OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
private Instructor instructor;

```

The value of mappedBy attribute points back to the variable that references to this (NOT THE DATABASE TABLE).

## Deleting while keeping one entity

```java

InstructorDetail temp = entityManager.find(InstructorDetail.class, id);
Instructor ins = temp.getInstructor();
ins.setInstructorDetail(null);
entityManager.remove(temp);

```

# JoinColumn vs Mappedby - When to use either?

The annotation @JoinColumn indicates that this entity is the owner of the relationship (that is: the corresponding table has a column with a foreign key to the referenced table), whereas the attribute mappedBy indicates that the entity in this side is the inverse of the relationship, and the owner resides in the "other" entity. This also means that you can access the other table from the class which you've annotated with "mappedBy" (fully bidirectional relationship).



# Pitfalls

- Unknown field "<name>" in field list ---> Double check for spelling/naming mistakes, check the database to see if you have mispelled anything.

# About the project

Database scripts can be found under resources.