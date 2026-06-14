/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MessageTest {
    
    private Message msg;  
    private Login login;

    
    public void setUp() {
        login = new Login("Kyle", "Smith");
    }

    @Test
    public void testCheckUsername_CorrectFormat() {
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testCheckUsername_IncorrectFormat() {
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }

    @Test
    public void testCheckPasswordComplexity_Success() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testCheckPasswordComplexity_Failure() {
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCheckCellPhoneNumber_Success() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCheckCellPhoneNumber_Failure() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    @Test
    public void testRegisterUser_Success() {
        String result = login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("User has been registered successfully", result);
    }

    @Test
    public void testLoginUser_Success() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testReturnLoginStatus_Success() {
        String result = login.returnLoginStatus(true, "Kyle", "Smith");
        assertEquals("Welcome Kyle, Smith it is great to see you again", result);
    }

    @Test
    public void testCheckMessageLength_Success() {
        String recipient = "+27123456789";
        String message = "Hi Mike, can you join us for dinner tonight?";
        msg = new Message(1, recipient, message);
        String result = msg.createMessageLength();
        assertEquals("Message ready to send.", result);
    }

    @Test
    public void testCheckMessageLength_Failure() {
        String recipient = "+27123456789";
        String message = "A".repeat(251);
        msg = new Message(1, recipient, message);
        String result = msg.createMessageLength();
        assertEquals("Message exceeds 250 characters by 1 please reduce size.", result);
    }

    @Test 
    public void testCheckRecipientCell_Success() {
        msg = new Message(1, "+27123456789", "Test message");
        String result = msg.checkRecipientCell();
        assertEquals("Cell phone number successfully captured.", result); 
    }

    @Test
    public void testCheckRecipientCell_Failure() {
        msg = new Message(1, "0821234567", "Test message");
        String result = msg.checkRecipientCell();
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code", result);
    }

    @Test
    public void testCreateMessageHash() {
        msg = new Message(1, "+27718693002", "Hi Mike, can you join us for dinner tonight");
        String hash = msg.createMessageHash();
        String idPart = msg.getMessageID().substring(0, 2);
        assertEquals(idPart + ":1:HITONIGHT", hash);
    }

    @Test
    public void testSentMessage_Send() {
        msg = new Message(1, "+2712345678", "Test");
        assertEquals("Messages successfully sent", msg.sentMessage(1));
    }

    @Test
    public void testSentMessage_Store() {
        msg = new Message(1, "+2712345678", "Test");
        assertEquals("Message successfully stored", msg.sentMessage(3));
    }
}