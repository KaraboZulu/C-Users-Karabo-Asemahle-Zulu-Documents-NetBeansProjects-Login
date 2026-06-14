/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter first name:");
        String firstName = scan.nextLine();
        
        System.out.print("Enter last name:");
        String lastName = scan.nextLine();
        
        Login login = new Login(firstName, lastName);
        
        System.out.print("Enter username:");
        String username = scan.nextLine();
        
        System.out.print("Enter password:");
        String password = scan.nextLine();
        
        System.out.print("Enter SA phone number (+27...):");
        String phone = scan.nextLine();
        
        String registerMsg = login.registerUser(username, password, phone);
        System.out.println(registerMsg);
        
        System.out.print("Enter username to login:");
        String loginUser = scan.nextLine();
        
        System.out.print("Enter password to login:");
        String loginPass = scan.nextLine();
        
        boolean loggedIn = login.loginUser(loginUser, loginPass);
        System.out.println(login.returnLoginStatus(loggedIn, firstName, lastName));
        
        if(loggedIn) {
            System.out.println("Welcome to QuickChat.");
            int option = 0;
            
            while(option != 3) {
                System.out.println("--- Main Menu ---");
                System.out.println("1. Send Messages");
                System.out.println("2. Show Recently Sent Messages");
                System.out.println("3. Quit");
                System.out.println("4. Stored Messages");
                System.out.print("Choose an option: ");
                
                option = scan.nextInt();
                scan.nextLine();
                
                switch(option) {
                    case 1:
                        System.out.print("How many messages do you want to send?");
                        int num = scan.nextInt();
                        scan.nextLine();
                        
                        for(int i = 0; i < num; i++) {
                            System.out.print("Enter recipient (+27...):");
                            String recipient = scan.nextLine();
                            
                            System.out.print("Enter message:");
                            String message = scan.nextLine();
                            
                            Message msg = new Message(i + 1, recipient, message);
                            System.out.println(msg.createMessageLength());
                            System.out.println(msg.checkRecipientCell());
                            System.out.println("Message Hash: " + msg.createMessageHash());
                        }
                        break;
                        
                    case 2:
                        System.out.println("Coming Soon.");
                        break;
                        
                    case 3:
                        System.out.println("Bye Bye!");
                        break;
                        
                    case 4:
                        System.out.println("Coming Soon.");
                        break;
                        
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } 
        scan.close();
    }
}