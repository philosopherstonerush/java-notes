A simple e-commerce spring boot app made with latest java features. 

# ER diagram

![spring_intern](https://github.com/philosopherstonerush/java-notes/assets/77642143/dc2389d5-4983-4217-a0cc-cc25a7552e98)

# Endpoints

1) GET `localhost:8080/inventory`
2) GET `localhost:8080/fetchCoupons`
3) POST `localhost:8080/{userId}/order?qty=10&coupon="OFF5"`
4) POST `localhost:8080/{userId}/{orderId}/pay?amount=950`
5) GET `localhost:8080/{userId}/orders`
6) GET `localhost:8080/{userId}/orders/{orderId}`

# Assumptions

1) A single product is being sold and its primary key is always `1L`

# Steps to run the project

1) Install JDK 17 or later
2) Download the jar file from /target or build using `mvnw install` while in project root directory
3) Use Postman, Insomnia or curl to test any of the endpoints above.
4) You can see values stored in the database at `localhost:8080/h2-console/`
