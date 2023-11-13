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



# About the project

Database scripts can be found under resources.