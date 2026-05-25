/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;
 
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author Karabo Asemahle Zulu
 */
public class MainPart2 {
    static ArrayList<Message> sentMessages = new ArrayList<>();
      
    public static void main (String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to QuickChat.");
         
        boolean running = true;
        while (running){
            String menu = "Choose an option:\n"+ "1) Send Message\n" + "2) Show recently sent messages\n" + "3) Quit";
            String choice = JOptionPane.showInputDialog(null, menu, "QuickChat Menu", JOptionPane.QUESTION_MESSAGE);
             
               if (choice == null) break;
               
               switch (choice){
                   case "1":
                       sendMessages();
                       break;
                   case "2":
                       JOptionPane.showMessageDialog(null, "Coming Soon");
                       break;
                   case "3":
                       running = false;
                               JOptionPane.showMessageDialog(null, "Total messages sent:" + Message.returnTotalMessage());
                               break;
                   default: 
                       JOptionPane.showMessageDialog(null,"Invalid option. Please enter 1, 2, or 3.");
                       
                   
                       
               }
        }
        System.exit(0);
    }
    
    public static void sendMessages(){
        String numStr = JOptionPane.showInputDialog(null, "Howw many messages do want to send?");
         if (numStr == null) return;
         
         int numMessages;
         try { 
             numMessages = Integer.parseInt(numStr);
             if (numMessages<=0){
                 JOptionPane.showMessageDialog(null, "Please enter a numbber greater than 0.");
                 return;
                 
             }
         } catch (NumberFormatException e){
             JOptionPane.showMessageDialog(null, "Invalid number enetered.");
             return;
         }
         for (int i = 0; i < numMessages; i++){
             JOptionPane.showMessageDialog(null, "Message" + (i+1) + "of" + numMessages);
              
             String recipient = JOptionPane.showInputDialog(null, "Enter recipient cell number with international code, e.g. +27831234567");
             if (recipient == null) return;
             
             String message = JOptionPane.showInputDialog(null, "Enter your message(mex 250 chars):");
              if (message == null) return;
               
              Message msg = new Message(i + 1, recipient, message);
               
              String recCheck = msg.checkREcipientCell();
              JOptionPane.showMessageDialog(null, recCheck);
              if (!recCheck.equals("Cell phone number successfully captured.")){
                 i--;
                  continue;
          
         
   
              }
                String lenCheck = msg.createMessageLength();
         JOptionPane.showMessageDialog(null, lenCheck);
         if (!lenCheck.equals("Message ready to send.")) {
             
            i--;
            continue;   
                
          
       
         }
        JOptionPane.showMessageDialog(null, msg.printMessage(), "Message Details", JOptionPane.INFORMATION_MESSAGE);
    
    String[] options = {"Send Message", "Disregard Message", "Store Message to send later"};
    int sendChoice = JOptionPane.showOptionDialog(null, "What would you like to do with this message?", "Send Options", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    
    if (sendChoice == -1) return;
    
    String result = msg.SentMessage(sendChoice + 1);
    JOptionPane.showMessageDialog(null, result);
    
    if (sendChoice == 0 ){
        sentMessages.add(msg);
        
    }
    
    }
              JOptionPane.showMessageDialog(null, "All messages processed.");

    }
    
}
    
     


   