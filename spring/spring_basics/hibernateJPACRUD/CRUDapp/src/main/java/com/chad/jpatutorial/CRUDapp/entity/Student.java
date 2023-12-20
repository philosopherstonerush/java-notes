package com.chad.jpatutorial.CRUDapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {

    // Define the fields

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String email;

    // Define the constructors

    public Student() {
        // This is the no argument constructor.
    }

    // We don't need to define id as it is auto generated
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Define setters and getters

    // For this you do need id, or else you cant fetch id from a record.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // to String method

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
