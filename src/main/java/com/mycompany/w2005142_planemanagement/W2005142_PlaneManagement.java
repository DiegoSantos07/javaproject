/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.w2005142_planemanagement;

import java.util.ArrayList; //Imported class from Java standard library
import java.util.Scanner; //Imported class from Java standard library
/**
 *
 * @author diego
 */
public class W2005142_PlaneManagement { //Class declaration - Reference: Tutorial week 1 Exercise 2
    
    private static final int rows_of_seats = 4; //Defines the number of rows 
    private static final int[] seats_per_row = {14, 12, 12, 14}; //Defines the seats per each row array - Reference: Week 4 Arrays, Sort and Search slide 8  
    private static final int[][] seats = new int [rows_of_seats][]; //2D representation of the seats array - Reference: Week 4 Arrays, Sort and Search slide 8
    private static final double [][] ticket_price = { // Array representing the prices for each seat - Reference: Week 4 Arrays, Sort and Search slide 31
        {200, 200, 200, 200, 200, 150, 150, 150, 150, 180, 180, 180, 180, 180},
        {200, 200, 200, 200, 200, 150, 150, 150, 150, 180, 180, 180},
        {200, 200, 200, 200, 200, 150, 150, 150, 150, 180, 180, 180},
        {200, 200, 200, 200, 200, 150, 150, 150, 150, 180, 180, 180, 180, 180}
    };
    
    private static final ArrayList<Ticket> tickets = new ArrayList<>(); //Declaration to store sold tickets - Reference: www.w3schools.com/java/java_arraylist.asp

    
    public static void main(String[] args) { //Main program method - Reference: Week 5 Methods Overloading Recursion slide 26
        System.out.println("Welcome to the Plane Management application"); //Displays welcome message
        
        for (int i = 0; i < rows_of_seats; i++) { //Initialisation of seats array - Reference: www.freecodecamp.org/news/java-array-declaration-how-to-initialize-an-array-in-java-with-example-code/
            seats[i] = new int[seats_per_row[i]];
        }
        
        Scanner scanner = new Scanner(System.in); //Declared to read user input
        int option;
        
        do {
            display_menu(); //Displays menu
            if (scanner.hasNextInt()){ //Checks integer input
            option = scanner.nextInt(); //After reading the integer input, variable is stored
            
            switch (option) { //Switch statement - Reference: Tutorial Week 5 Methods Overloading Recursion Exercise 2
                case 0 -> System.out.println("Program closing..."); //Handles quit option
                case 1 -> buy_seat(); //Handles method buy_seat
                case 2 -> cancel_seat(); //Handles method cancel_seat
                case 3 -> find_first_available_seat(); //Handles find_first_available_seat
                case 4 -> show_seating_plan(); //Handles method show_seating_plan
                case 5 -> print_tickets_info(); //Handles method print_tickets_info
                case 6 -> search_ticket(); //Handles method search_ticket
                default -> System.out.println("Invalid option. Please try again."); //Message displays when invalid input is entered
            }
         } else { //If the input is not an integer
            scanner.nextLine(); //Clear scanner
            option = -1;
           }
        } while (option != 0); //Loop until option 0 is entered
    }

    
    private static void display_menu() { //Method to display menu options - Reference: Week 5 Methods Overloading Recursion slide 28
        //Menu options - Reference: Tutorial Week 5 Methods Overloading Recursion Exercise 2
        System.out.println("**************************************************");
        System.out.println("*                  MENU OPTIONS                  *");
        System.out.println("**************************************************");
        System.out.println("1) Buy a seat");
        System.out.println("2) Cancel a seat");
        System.out.println("3) Find first available seat");
        System.out.println("4) Show seating plan");
        System.out.println("5) Print tickets information and total sales");
        System.out.println("6) Search ticket");
        System.out.println("0) Quit");
        System.out.println("**************************************************");
        System.out.println("Please select an option:");
    }

   
    private static void buy_seat() { //Method to allow user buy a seat - Reference: Week 5 Methods Overloading Recursion slide 28
        Scanner scanner = new Scanner(System.in); //Read user input
        
        char selected_row; //Requirement to input a row //Switch statement - Reference:  Week 2 Data types and Control structures slide 11
        boolean validInput = false; //Input validation for rows A, B, C or D - Reference:  Week 2 Data types and Control structures slide 13
        
        do { //Input validation for row
            System.out.println("Row: ");
            selected_row = Character.toUpperCase(scanner.next().charAt(0)); //Character conversion to uppercase
            
            if (selected_row >= 'A' && selected_row <= 'D') { //Range validation for row - Reference:  Week 2 Data types and Control structures slide 25
                validInput = true;
            } else {
                System.out.println("Please select between A, B, C or D.");
            }
        } while (!validInput); //While loop Reference:  Week 3 Loops Validation and Debugging slide 20
        
        int selected_seat; //Corresponding variable selected seat to its index
        int rowIndex = selected_row - 'A';
        
        do { //Input validation for seat
            System.out.println("Seat number: "); 
    while (!scanner.hasNextInt()) { //Integer validation
            System.out.println("Please enter a valid seat number: ");
            scanner.next(); 
    }
    
    selected_seat = scanner.nextInt(); //Read seat number
    
    if (selected_seat < 1 || selected_seat > seats_per_row[rowIndex]) { //Range validation for chosen row  - Reference:  Week 4 Arrays, Sort and Search slide 40
        System.out.println("Invalid seat number selection for row " + selected_row + ". Number of seats per row: A/D 14 seats and B/C 12 seats."); // Error message
    }
} while (selected_seat < 1 || selected_seat > seats_per_row[rowIndex]);

        if (seats[rowIndex][selected_seat - 1] == 1){ //Validation for unavailable seat
            System.out.println("This seat has been purchased already. Please select a different seat."); //Error message
            System.out.println("Seat number: "); //If seat has already been purchased, message asking for a different seat
            selected_seat = scanner.nextInt();
        }
        
        scanner.nextLine();
        
    //Message requiring passenger details
    System.out.println("Enter passenger details:"); 
    System.out.println("Name:");
    String name = scanner.nextLine();
    while (!name.matches("[A-Za-z\\s]{1,30}")) { //Name validation - Reference: stackoverflow.com/questions/16817031/how-to-iterate-over-regex-expression
        System.out.println("Please enter a valid name: ");
        name = scanner.nextLine();
    }
    
    System.out.println("Surname:");
    String surname = scanner.nextLine();
    while (!surname.matches("[A-Za-z\\s]{1,30}")) { //Surname validation - Reference: stackoverflow.com/questions/16817031/how-to-iterate-over-regex-expression
        System.out.println("Please enter a valid surname: ");
        surname = scanner.nextLine();
    }
    
    System.out.println("Email:");
    String email = scanner.nextLine();
    while (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) { //Email validation - Reference: howtodoinjava.com/java/regex/java-regex-validate-email-address/
        System.out.println("Please enter a valid email: ");
        email = scanner.nextLine();
    }
    
    Person person = new Person(name, surname, email); //Person object is created based on the passenger details - Reference: Weel 7 Classes and Objects slide 27
    Ticket ticket = new Ticket(selected_row, selected_seat, ticket_price, person); //Ticket object is created for the respective seat
    tickets.add(ticket); //Ticket added to a list
    ticket.save(); //Details saved
    
        seats[rowIndex][selected_seat - 1] = 1; //Make the seat unavailable after a purchase
        System.out.println("Seat " + selected_row + selected_seat + " was purchased successfully."); //Message confirming the purchase
    }
    
    
    private static void cancel_seat() { //Method to allow user cancel a seat - Reference: Week 5 Methods Overloading Recursion slide 28
       Scanner scanner = new Scanner(System.in); //Read user input
       
        char selected_row; //Requirement to input a row
        boolean validInput = false; //Input validation for rows A, B, C or D
        
        do { //Input validation for row
            System.out.println("Row: "); 
            selected_row = Character.toUpperCase(scanner.next().charAt(0)); //Character conversion to uppercase
            
            if (selected_row >= 'A' && selected_row <= 'D') { //Range validation for row
                validInput = true;
            } else {
                System.out.println("Please select between A, B, C or D.");
            }
        } while (!validInput);
        
        int selected_seat; //Corresponding variable selected seat to its index
        int rowIndex = selected_row - 'A';
        
        do { //Input validation for seat
    System.out.println("Seat number: "); 
    while (!scanner.hasNextInt()) { //Integer validation
        System.out.println("Please enter a valid seat number: ");
        scanner.next(); 
    }
    
    selected_seat = scanner.nextInt(); //Read seat number
    
    if (selected_seat < 1 || selected_seat > seats_per_row[rowIndex]) { //Range for seat validation for chosen row
        System.out.println("Invalid selection seat number for row " + selected_row + ". Number of seats per row: A/D 14 seats and B/C 12 seats."); //Error message for invalid seat number
    }
        } while (selected_seat < 1 || selected_seat > seats_per_row[rowIndex]);
        
        if (seats[rowIndex][selected_seat - 1] == 0) { //Validation for purchased seat
            System.out.println("The seat " + selected_row + selected_seat + " has not been purchased yet."); //Message for seat availability
            return;
        }
        seats[rowIndex][selected_seat - 1] = 0; //Set seat as available
        System.out.println( selected_row + "" + selected_seat + " cancelled."); //Message confirming the cancelled seat     
      
        for (int i = 0; i <tickets.size(); i++) { //Ticket is removed from tickets list
            Ticket ticket = tickets.get(i);
            if (ticket.getRow() == selected_row && ticket.getSeat() == selected_seat){
                tickets.remove(i);
                break;
            }
        }
    }
    
    
    private static void find_first_available_seat() { //Method checks seat availability - Reference: Week 5 Methods Overloading Recursion slide 28
        boolean seatFound = false;
        
        for (int i = 0; i < rows_of_seats; i++) { //Row of seats iteration 
        for (int j = 0; j < seats_per_row[i]; j++) { //Iteration on all seats in the chosen row
            char row = (char) ('A' + i); //Row calculation by index
            
            if (seats[i][j] == 0) { //Availability valiadation
                System.out.println("First available seat is: " + row + (j + 1)); //First available seat is displayed
                seatFound = true;
                break; //Inner loop ends
            }
        }
        
        if (seatFound) {
            break; //Once finds a seat, outer loop ends
        }
    }
}
    
    
    //Reference: Week 3 Loops Validationd and Debugging slide 13
    private static void show_seating_plan() { //Method to display seating plan - Reference: Week 5 Methods Overloading Recursion slide 28
        System.out.println("Seating Plan: ");
        
        for (int i = 0; i < rows_of_seats; i++) { //Row iteration 
            for (int j = 0; j < seats_per_row[i]; j++) { //Iteration on all seats in the chosen row
                if (seats[i][j] == 0){ //Seat available (0) and unavailable (1)
                    System.out.print("O"); //Displays 'O' for available seats
                } else {
                    System.out.print("X"); //Displays 'X' for available seats
                }
            }
            System.out.println(); //Next line for following row
        }
    }
    
    
    private static void print_tickets_info() { //Method to display ticket information - Reference: Week 5 Methods Overloading Recursion slide 28
        
        if (tickets.isEmpty()) { //Validation for tickets sold
            System.out.println("No tickets have been sold.");
            return;
        }
        
        //Variables initialisation to control total sales and ticket numbers
        double totalSales = 0;
        int ticketCounter = 1;
        
        System.out.println("Tickets sold:");
        for (Ticket ticket : tickets) { //Iteration for each ticket in the sold list
            //Recover ticket details
            char row = ticket.getRow();
            int seat = ticket.getSeat();
            double price = ticket.getTicketPrice()[row - 'A'][seat - 1]; //Reference: Week 4 Arrays, Sort and Search slide 31
            totalSales += price;
            
            //Ticket information is displayed including all details of the passenger
            System.out.println("Ticket " + ticketCounter);
            System.out.println("-----------------------------");
            System.out.println("Ticket information: ");
            System.out.println("Row: " + row);
            System.out.println("Seat: " + seat);
            System.out.println("Price: £" + price);
            Person person = ticket.getPerson();
            System.out.println("Name: " + person.getName());
            System.out.println("Surname: " + person.getSurname());
            System.out.println("Email: " + person.getEmail());
            
            ticketCounter++; //Ticket counter addition
        }
        
        System.out.println("Total sales is: £" + totalSales); //Total value for every seat purchase
    }

    
    private static void search_ticket() { //Method to search a specific ticket - Reference: Week 5 Methods Overloading Recursion slide 28
        Scanner scanner = new Scanner(System.in); //Read user input
        
        //Variables initialisation to store chosen row and seat
        char searchRow;
        int searchSeat;
        
        do{ //Ask user input of valid row 
            System.out.println("Enter a row: ");
            searchRow = Character.toUpperCase(scanner.next().charAt(0));
            
            //Row input validation
            if (searchRow >= 'A' && searchRow <='D') {
                break;
            } else {
                System.out.println("Invalid row. Please select between A, B, C or D.");
            }
        } while(true);
        
        //Ask user to enter a valid seat
        do{
            System.out.println("Enter a seat number: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid seat number: ");
                scanner.next();
            }
            
            //Seat number validation
            searchSeat = scanner.nextInt(); 
            
            if(searchSeat >=1 && searchSeat <= 14) {
                break;
            } else {
                System.out.println("Invalid seat number. Please enter a valid seat. ");
            }
        } while(true);
        
        //Input row and seat is searched
        boolean ticketFound = false;
        for (Ticket ticket : tickets) {
            //If input matches to a purchased seat, ticket information is displayed
            if (ticket.getRow() == searchRow && ticket.getSeat() == searchSeat) { 
                ticket.printTicketInfo();
                ticketFound = true;
                break;
            }
        }
        
        //If input does not match to a purchased seat, displays a message of seat available
        if (!ticketFound) {
            System.out.println("This seat is available");
        }
    }
}

