/**
 * 
 * Author: Jared Morris
 * Course Number: CMSY-167-002
 * Program Name: Lab2C
 * 
 * Purpose:
 * The program is designed to use data from file "Lab2A.txt" and the newly created file "howardBeeMailing.txt"
 * The program is to read in email addresses from Lab2A.txt and trim them of their whitespaces
 * The program is to decide if the email is valid. If no, print out an error for that specific email
 * If the email is valid, the program will count the length of the email as well as the amount of characters before and after the "@" symbol
 * If the email ends in "howardcc.edu", the program will put that email into howardBeeMailing.txt
 * The program will loop through this process until there are no more emails to read from Lab2A.txt
 * 
 * Output:
 *      new.student@howardcc.edu
 *               Length: 24
 *               Characters before @: 11
 *               Characters after @: 12
 *               Moved to howardBeeMailing.txt: True
 * 
 *      SweetTooth@gmail.com
 *               Length: 20
 *               Characters before @: 10
 *               Characters after @: 9
 *               Moved to howardBeeMailing.txt: False
 * 
 *        namenotfoundyahoo.com  
 *               Invalid email
 * 
 *      mQuinn@howardcc.edu
 *               Length: 19
 *               Characters before @: 6
 *               Characters after @: 12
 *               Moved to howardBeeMailing.txt: True
 * 
 *      java.student@howardcc.edu
 *               Length: 25
 *               Characters before @: 12
 *               Characters after @: 12
 *               Moved to howardBeeMailing.txt: True
 * 
 *         chocolatelover@gmail.com
 *               Length: 24
 *               Characters before @: 14
 *               Characters after @: 9
 *               Moved to howardBeeMailing.txt: False
 * 
 *      dud2Atmsn  
 *              Invalid Email
 * 
 *      dmilburn@howardcc.edu
 *              Length: 21
 *              Characters before @: 8
 *              Characters after @: 12
 *              Moved to howardBeeMailing.txt: True
 * 
 *         candyKrunch@cocoa.com
 *              Length: 21
 *              Characters before @:11
 *              Characters after @: 9
 *              Moved to howardBeeMailing.txt: False
 * 
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.SecurityException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Lab2C{

    public static void main(String[] args){

        // Create a scanner object called input and open Lab2A.txt
        try(Scanner input = new Scanner(Paths.get("Lab2A.txt"))){

            // Create a PrintWriter object called writer and open howardBeeMailing.txt
            try(PrintWriter writer = new PrintWriter("howardBeeMailing.txt")){

                while(input.hasNext()){
	
                    // Get email from Lab2A.txt
                    String email = input.next();
                
                    // Trim whitespace from email
                    email = email.trim();
                
                    // Look for @ symbol
                    int atLocation = email.indexOf("@");
                    // If @ symbol appears 
                    if(atLocation != -1){

                        // Get substring of characters after @
                        String emailAfterAt = email.substring(atLocation+1);

                        //  Count length of email
                        int emailLength = email.length();

                        //  Count characters before @ symbol
                        int charBeforeAt = email.substring(0, (atLocation)).length();

                        //  Count characters after @ symbol
                        int charAfterAt = email.substring((atLocation+1)).length();
                        
                        //  Print the information
                        System.out.printf("%s%nLength: %d%nCharacters before @: %d%nCharacters after @: %d%n%n", email,
                        emailLength, charBeforeAt, charAfterAt);
                        
                        // Change the case type of the email
                        email = caseManip(email);

                        //  If characters after @ symbol == howardcc.edu, write the email to howardBeeMailing.txt
                        if(emailAfterAt.equals("howardcc.edu")){

                            writer.println(email);

                        } // End if statement
                        
                    } else if(email.equals("endoftextfile")){ // If endoftextfile appears, break to not showcase anything  to output

                        break;

                    } else { // If @ symbol does not appear 
                
                        // Print error message saying not valid email
                        System.out.printf("%s - Email address unreadable%n%n", email);
                
                    } // End if statement
                
                } // End while loop
                
                writer.close();
                input.close();

            } catch (SecurityException | FileNotFoundException e){

                System.out.println("Error opening howardBeeMailing.txt");

            } // End try catch for opening howardBeeMailing.txt

        } catch(IOException | NoSuchElementException | IllegalStateException e){

            System.out.println("Error opening Lab2A.txt");

        } // End try catch statement for opening Lab2A.txt

    } // End main method

    // Decides whether to make the email lower case or uppercase
    public static String caseManip(String email){

        // If email equals dmilburn@howardcc.edu
        if (email.equals("dmilburn@howardcc.edu")){

            // Set the email to uppercase 
            email = email.toUpperCase();
            return email;
            
        } else {// If emails do not equal dmilburn@howardcc.edu

            // Set the email to lowercase 
            email = email.toLowerCase();
            return email;
            
        }// End if/else statement

    } // End caseManip method

} // End Lab2C class