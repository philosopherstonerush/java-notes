
# Updating the information at the database through a form

Have a input tag with type hidden which has a field value of id which sends the id of the record to the server to update.


# Pre-populating our form:

check out updateEmployee under employeeController

You can prepopulate our form by adding the model attribute to the present information.

# Adding subfolders under templates:

Just mention the path starting inside the templates folder.

```html
templates 
    - employees
        - employee-list.html
    - students
        - student-attendance.html
```

to access employee-list.html, you do

```html

"employees/employee-list"

```

# Best practices:

`POST/Redirect/GET` pattern is used to prevent the user from submitting the same duplicate data.

```java

return "redirect:<url>"

```

# About this project

Access the list of employees at

```html

\employees\list

```

SQL scripts for database support can be found under `sql-scripts`

