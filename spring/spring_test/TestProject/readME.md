# Testing

There are quite a bit of libraries available for you to test your code

Those are 
- Hamcrest
- AssertJ
- JUnit

Junit is the default testing library that is used with spring boot.

## Note - spring boot starter test

When this dependency is included then all the above test packages are automatically included to your system.

# AAA (Arrange, Act, Assert)

The steps involved in Testing can be broken down into three categories

```java

Naming conventions: names should be compliant with MethodName_StateUnderTest_ExpectedBehavior

void literally_any_test() {
    
    // Arrange
    
    Gather and make ready all the requirements for the test - Create mock beans (scroll down to know more)
    
    // Act
    
    Test out the function or anything that you want to make sure that it works alright
        
    // Assert
        
        See if the output that we get is actually right to what is needed
}

```

# Testing different layers

## Web/Service layer

### Without the server

Mock beans are used to test the app without a server being there. These are particularly useful if you are planning to test for the logic involved at the controller layer over anything else.

With MockMvc, you're typically setting up a whole web application context and mocking the HTTP requests and responses. So, although a fake DispatcherServlet is up and running, simulating how your MVC stack will function, there are no real network connections made.

Use when: testing server side application

void method: [what to do when my method returns void](notes/void_method.html)

Check if the html

```java

@WebMvcTest(GreetingController.class)
class WebMockTest {

	@Autowired
	private MockMvc mockMvc;

    /**
     * 
     * When you use WebMvcTest then the beans associated with service and stuff or anything are not injected automatically into this bean, you have to mock or define their behaviour yourself.
     * 
     */

    @MockBean
	private GreetingService service;

	@Test
	void greetingShouldReturnMessageFromService() throws Exception {

        /**
         * 
         * Mocking the behaviour of our mock bean greeting service
         * 
         */
        when(service.greet()).thenReturn("Hello, Mock");
		
        this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello, Mock")));
	}
}

```

#### MockMvcRequestBuilders

```
NewObject newObjectInstance = new NewObject();
// setting fields for the NewObject  

mockMvc.perform(MockMvcRequestBuilders.post(uri)
  .content(asJsonString(newObjectInstance))
  .contentType(MediaType.APPLICATION_JSON)
  .accept(MediaType.APPLICATION_JSON));

```

```
public static String asJsonString(final Object obj) {
    try {
        final ObjectMapper mapper = new ObjectMapper();
        final String jsonContent = mapper.writeValueAsString(obj);
        return jsonContent;
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}  

```

### With the Server

These tests involve starting up the server and you emulate the normal sending and receiving via the server itself

RestTemplate can conveniently be initialized with a custom ClientHttpRequestFactory. Implementations usually create ClientHttpRequest objects that open actual TCP/HTTP(s) connections. But you don't have to. You can provide a mock implementation where you can do whatever you want. In fact, this is how the MockRestServiceServer utility operates, you could use that.

Use when: test Rest Client-side application:

If you have code using the RestTemplate, you’ll probably want to test it and to that you can target a running server or mock the RestTemplate. The client-side REST test support offers a third alternative, which is to use the actual RestTemplate but configure it with a custom ClientHttpRequestFactory that checks expectations against actual requests and returns stub responses.

For example, if your code with restTemplate calls an external api then you must

```java

/**
 * 
 * The WebEnvironment keywork starts the server at a random available port so it doesnt clash with anything
 * 
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HttpRequestTest {
    
    // This apparently cannot be static.
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void greetingShouldReturnDefaultMessage() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
				String.class)).contains("Hello, World");
	}
}

```

## Pitfalls

### Disable CSRF

[Disable](notes/csrf.html)

### Overcome authorization

[Unauthorized](notes/unauthorized.html)

## Database (or jpa) layer

[Article does a good job explaining](notes/jpa_testing.html)