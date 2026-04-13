/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author Karabo Asemahle Zulu
 */



public class LoginTest {
    Login login = new Login("Kyle", "Smith");
    
    
    @Test
    public void testUsernameCorrectlyFormatted(){
   boolean result = login.checkUserName("kyl_1");
   assertTrue(result);
    }
     @Test
     public void testUsernameIncorrectlyFormatted(){
         boolean result= login.checkUserName("kyle!!!");
         assertFalse(result);  
     }
     
     @Test
     public void testPasswordCorrect(){
         boolean result = login.checkPasswordComplexity("Ch8&sec@ke99!");
         assertTrue(result);
     }
     @Test 
     public void testPasswordIncorrect(){
         boolean result = login.checkPasswordComplexity("password");
         assertFalse(result);
     }
    
     @Test
     public void testCellPhoneCorrect(){
         boolean result = login.checkCellPhoneNumber("+27838968976");
         assertTrue(result);
     }
    @Test
     public void testCellPhoneIncorrect(){
    boolean result = login.checkCellPhoneNumber("08966553");
     assertFalse(result);
     }
    
     @Test
     public void testLoginSuccess(){
         login.registerUser("kyl_1", "Ch8&sec@ke99!", "+27838968976");
         boolean result = login.loginUser("wrong", "wrong");
         assertTrue(result);
     }
    
     public void testLoginFailure(){
           login.registerUser("kyl_1", "Ch8&sec@ke99!", "+27838968976");
       boolean result = login.loginUser("wrong","wrong");
        assertFalse(result);
      
     }
        
}
     



