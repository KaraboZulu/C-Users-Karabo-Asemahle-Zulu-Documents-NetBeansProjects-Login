/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;
import java.util.Scanner;
/**
 *
 * @author Karabo Asemahle Zulu
 */
public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
         
        System.out.println("Enter first name:");
        String firstName = input.nextLine();
         
        System.out.println("Enter last name:");
        String lastName = input.nextLine();
        
        Login login = new Login(firstName,lastName);
        
        System.out.println("Enter username");
        String username = input.nextLine();
        
        System.out.println("Enter password:");
        String password = input.nextLine();
        
        System.out.println("Enter cellphonenumber (+27...");
        String cellphonenumber = input.nextLine(); 
        
        String registerMessage = login.registerUser(username, password, cellphonenumber);
        System.out.println(registerMessage);
        
        
        System.out.println("\nlogin now");
        
        System.out.println("Enter username:");
        String loginUser = input.nextLine();
        
        System.out.println("Enter password:");
        String loginPassword = input.nextLine();
      
        boolean loginStatus = login.loginUser(loginUser, loginPassword);
         String message = login.returnLoginStatus(loginStatus, firstName, lastName);
        System.out.println(message);
    }
    
}


