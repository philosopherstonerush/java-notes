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
