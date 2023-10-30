
Check out API Security as well.

# Spring Security Model In Action

![img.png](notes/img.png)

# Specifying our login page

```java

http.formLogin(
        form ->
            form
                .loginPage(<The url corresponding to the where the html points to>)
                .loginProcessingUrl(<Url where you plan to post to>)
                .permitAll()
        )

```

`loginProcessingUrl` provides automatic support for authentication and doesnt require us to specify a controller logic.

If the processing is performed automatically, then you have to let the default `name` be present for example: username must be `username` and password must be `password`.

Check out login.html

if the login fails then you can inform the user by checking if there is a `error` key in the url.

```html

th:if=${param.error}

```