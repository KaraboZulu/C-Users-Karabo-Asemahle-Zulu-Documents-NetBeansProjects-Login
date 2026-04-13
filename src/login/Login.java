/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package login;

/**
 *
 * @author Karabo Asemahle Zulu
 */
public class Login {
 private String registeredUsername;
 private String registeredPassword;
 private String firstName;
 private String lastName;
  
 public Login(){
     
 }
 public Login(String firstName, String lastName){
     this.firstName = firstName;
     this.lastName = lastName;
 }

 
 public boolean checkUserName(String username) {
     return username.contains("_")&& username.length()<=5;
 }
 
 
 public boolean checkPasswordComplexity(String Password){
     boolean hasCapital = !Password.equals(Password.toLowerCase());
     boolean hasNumber = Password.matches(".*\\d.*");
     boolean hasSpecial = Password.matches(".*[!#$%%^&*(),.?:{}|<>].*");
     boolean hasLength = Password.length()>=8;
     return hasCapital && hasNumber && hasSpecial && hasLength;
     
 }
 
 
 public boolean checkCellPhoneNumber(String cellNumber){
       return cellNumber.matches("\\+27\\d{7,9}");
 }
  
 
 public String registerUser(String username, String password, String number){
     if (!checkUserName(username)){
         return "Username must have _ and be more than 5 characters in length";
     }
     if (!checkPasswordComplexity(password)){
         return "Passwords must at least 8 characters, a capital letter, a number, and a special character.";
         
     }
     if (!checkCellPhoneNumber(number)){
         return "Cellphone number must have an international code."; 
     }
  
 registeredUsername = username;
 registeredPassword = password;
 firstName = firstName;
 lastName = lastName;
 return "Username successfully captured.\nPassword successfully captured.\nCell number successfully captured.";
  
 }
  

 public boolean loginUser(String username,String password){
     return username.equals(this.registeredUsername)&& password.equals(this.registeredPassword);
 }
  
 
 public String returnLoginStatus(boolean loginStatus, String firstName, String lastName){
     if (loginStatus){
         return"Welcome " + firstName  + "," + lastName + "it isbgreat to see you";
     }else{ 
         return "Username or password incorrect, please try again.";
                 
                 
     }
 }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
