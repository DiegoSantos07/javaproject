/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w2005142_planemanagement;

/**
 *
 * @author diego
 */
public class Person { //Declaration of class Person - Reference Week 7 Classes and Objects slide 18
    //Declaration for variables - Reference: Week 7 Classes and Objects slide 19
    private String name; //Name declaration - Reference: Week 7 Classes and Objects slide 21
    private String surname; //Surname declaration - Reference: Week 7 Classes and Objects slide 21
    private String email; //Email declaration - Reference: Week 7 Classes and Objects slide 21
    
    //Constructor to assign parameter to object - Reference: Week 7 Classes and Objects slide 26
    public Person (String name, String surname, String email) {
        this.name = name; //Reference: Week 7 Classes and Objects slide 26
        this.surname = surname; //Reference: Week 7 Classes and Objects slide 26
        this.email = email; //Reference: Week 7 Classes and Objects slide 26
    }
    
    //Getter method for name when called - References: Week 7 Classes and Objects slide 34 and geeksforgeeks.org/getter-and-setter-in-java
    public String getName() {
        return name;
    }
    
    //Setter method for setting name value when called - References: Week 7 Classes and Objects slide 35 and geeksforgeeks.org/getter-and-setter-in-java
    public void setName(String name) {
        this.name = name;
    }
    
    //Getter method for surname when called - References: Week 7 Classes and Objects slide 34 and geeksforgeeks.org/getter-and-setter-in-java
    public String getSurname() {
        return surname;
    }
    
    //Setter method for setting surname value when called - References: Week 7 Classes and Objects slide 35 and geeksforgeeks.org/getter-and-setter-in-java
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    //Getter method for email when called - References: Week 7 Classes and Objects slide 34 and geeksforgeeks.org/getter-and-setter-in-java
    public String getEmail() {
        return email;
    }
    
    //Setter method for setting email value when called - References: Week 7 Classes and Objects slide 35 and geeksforgeeks.org/getter-and-setter-in-java
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void printPersonInfo() { //Method used to print passenger information
        System.out.println("Name : " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Email: " + email);
    }
}
