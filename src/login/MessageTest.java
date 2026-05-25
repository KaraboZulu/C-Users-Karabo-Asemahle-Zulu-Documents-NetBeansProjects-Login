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
public class MessageTest {
    
  private  Message msg;
  
  public MessageTest(){
      
  }
  @Test
  public void testCheckMessageLength_Success(){
              String recipient = "+27123456789";
              String message = "Hi Mike, can you join us for dinner tonight?";
              msg = new Message(1, recipient, message);
               
              String result = msg.createMessageLength();
              
              assertEquals("Message ready to send.", result);
          }
  @Test
  public void testCheckMessageLength_Failure(){
      String recipient = "+27123456789";
      String message = "A".repeat(251);
      msg = new Message(1, recipient, message);
      
      String result = msg.createMessageLength();
      
      assertEquals("Message exceeds 250 characters ny 1, please reduce size.", result);
  }
  @Test 
  public void testCheckREcipientCell_Success(){
      msg = new Message(1, "+27123456789", "Test message");
      
      String result = msg.checkREcipientCell();
      
      assertEquals("Cell phone number successfully captured.", result); 
  }
  @Test
   public void testCheckREcipientCell_Failure(){
       
       msg = new Message(1, "0821234567", "Test message");
       
       String result = msg.checkREcipientCell();
       
       assertEquals("Cell phone number is incorrectly formatted or does not cpntain an international code", result);
       
   }
}
