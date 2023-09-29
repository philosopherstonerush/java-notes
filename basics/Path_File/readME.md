# Path

Path is a package used for I/O that does everything that file package does but also a lot more.

Why path was introduced?

Path was meant to be a better alternative for file package.

```java

// from first version of java
File file = new File("baeldung/tutorial.txt");

// from version 7
Path path = Paths.get("baeldung/tutorial.txt");

```

## Initializing path 

```java

// use the static instance

Path exPath = Paths.get("<random-path-to-a-file>");

```

## Advantages

- Compiler throws error compared to files.
- MetaData support - rename() works consistently across all platforms.