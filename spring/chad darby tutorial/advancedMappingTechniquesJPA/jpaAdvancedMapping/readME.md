# JPA Advanced Mapping Techniques

# One to One mapping:

Happens when one entity is associated with another entity.

```html

instructor ---> instructorDetail

```

primary key ---> foreign key constraints are applied to set up such mapping when you create database.

Suppose we have a User with address stored in a different table, then we have one-to-one mapping as :-

```java

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

# Bi-directional Mapping

Establishes a bidirectional mapping from child entity to parent entity. 

```java

// At the child entity class

// mappedby value must be the property name from parent entity class ---> private InstructorDetail instructorDetail;
// cascade helps to propagate changes to the parent entity class.
@OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
private Instructor instructor;

```

## Deleting while keeping one entity

```java

InstructorDetail temp = entityManager.find(InstructorDetail.class, id);
Instructor ins = temp.getInstructor();
ins.setInstructorDetail(null);
entityManager.remove(temp);

```


# Pitfalls

- Unknown field "<name>" in field list ---> Double check for spelling/naming mistakes, check the database to see if you have mispelled anything.

# About the project

Database scripts can be found under resources.