/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w2005142_planemanagement;

import java.io.FileWriter; //Imported class from Java standard library - Reference: Week 8 - Files and testing slide 11
import java.io.IOException; //Imported class from Java standard library - Reference: Week 8 - Files and testing slide 10
/**
 *
 * @author diego
 */
public class Ticket { //Declaration of class Ticket - Reference Week 7 Classes and Objects slide 18
    //Declaration for variables - Reference: Week 7 Classes and Objects slide 19
    private char row; //Row of seats declaration - Reference: Week 7 Classes and Objects slide 21
    private int seat; // Seat number declaration - Reference: Week 7 Classes and Objects slide 21
    private double[][] price; //Ticket prices for each seat declaration - Reference: Week 7 Classes and Objects slide 21
    private Person person; //Passenger info declaration - Reference: Week 7 Classes and Objects slide 21
    
    ////Constructor to assign parameter to object based on details - Reference: Week 7 Classes and Objects slide 26
    public Ticket(char row, int seat, double[][] price, Person person) {
        this.row = row; //Reference: Week 7 Classes and Objects slide 26
        this.seat = seat; //Reference: Week 7 Classes and Objects slide 26
        this.price = price; //Reference: Week 7 Classes and Objects slide 26
        this.person = person; //Reference: Week 7 Classes and Objects slide 26
    }
    
    //Getter method for ticket row when called - References: Week 7 Classes and Objects slide 34 and geeksforgeeks.org/getter-and-setter-in-java
    public char getRow(){
        return row;
    }
    
    //Setter method for setting ticket row - References: Week 7 Classes and Objects slide 35 and geeksforgeeks.org/getter-and-setter-in-java
    public void setRow(char row) {
        this.row = row;
    }
    
    //Getter method for ticket seat when called - References: Week 7 Classes and Objects slide 34 and geeksforgeeks.org/getter-and-setter-in-java
    public int getSeat(){
        return seat;
    }
    
    //Setter method for setting ticket seat - References: Week 7 Classes and Objects slide 35 and geeksforgeeks.org/getter-and-setter-in-java
    public void setSeat(int seat) {
        this.seat = seat;
    }
    
    //Getter method for ticket prices array when called - References: Week 7 Classes and Objects slide 34 and geeksforgeeks.org/getter-and-setter-in-java
    public double[][] getPrice() {
        return price;
    }
    
    //Setter method for setting ticket prices array - References: Week 7 Classes and Objects slide 35 and geeksforgeeks.org/getter-and-setter-in-java
    public void setPrice(double[][] price) {
        this.price = price;
    }
    
    //Getter method for passenger details when called - References: Week 7 Classes and Objects slide 34 and geeksforgeeks.org/getter-and-setter-in-java
    public Person getPerson() {
        return person;
    }
    
    //Setter method for setting passenger details - References: Week 7 Classes and Objects slide 35 and geeksforgeeks.org/getter-and-setter-in-java
    public void setPerson(Person person) {
        this.person = person;
    }
    
    public void printTicketInfo(){ //Method declaration to print ticket information 
        System.out.println("Ticket information:");
        System.out.println("Row: " + row);
        System.out.println("Seat: " + seat);
        System.out.println("Price: £" + price[row - 'A'][seat - 1]);
        System.out.println("Passenger information:");
        person.printPersonInfo();
    }

    public double[][] getTicketPrice() { //Reference: Week 4 Arrays, Sort and Search slide 8
        return price; //2D ticket prices array returned
    }
    
    public void save() { //Method declaration to save ticket information into a file
        String filename = row + Integer.toString(seat) + ".txt"; //File named based on row and seat number - Reference: Week 8 Files and Testing slide 16
        
        try (FileWriter writer = new FileWriter(filename)) { //File writer opens - Reference: Week 8 Files and Testing slide 10
            writer.write("Ticket information: \n");
            //Ticket and passenger details writes to a file
            writer.write("Row: " + row +  "\n");
            writer.write("Seat: " + seat +  "\n");
            writer.write("Price: £" + price[row - 'A'][seat - 1] + "\n");
            writer.write("Passenger information: \n");
            writer.write("Name: " + person.getName() + "\n");
            writer.write("Surname: " + person.getSurname() + "\n");
            writer.write("Email: " + person.getEmail() + "\n");
        } catch (IOException e) { //Excecption handling for file writing - Reference: Week 8 - Files and testing slide 10
            System.err.println("Error writing to file : " + filename); //Error message
        }
    }
}
