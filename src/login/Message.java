/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;
import java.util.Random;
  

/**
 *
 * @author Karabo Asemahle Zulu
 */
public class Message {

        
    private String messageID;
    private int messageNum;
    private String recipient;
    private String message;
    private String messageHash;
    private static int totalMessagesSent = 0;
    
    public Message(){
}

    
 public Message(int messageNum, String recipient, String message) {
     this.messageNum = messageNum;
     this.recipient = recipient;
     this.message = message;
     this.messageID = generateMessageID();
     this.messageHash = createMessageHash();

 }
  
private String generateMessageID(){ 
    Random rand = new Random();
    long num = 1000000000L + (long)(rand.nextDouble()* 9000000000L);
    return String.valueOf(num);
    
}


public boolean checKMessageID(){
   return messageID!= null && messageID.length()<=10;
   
}
   
public String checkREcipientCell(){
    if (recipient!= null && recipient.length() <=12 && recipient.startsWith("+")) {
        return "Cell phone number successfully captured.";
    }else{
        return "Cell phone number is incorrect.";
        
    }
     }
  
public String createMessageLength(){
    if (message == null) return "No message.";
    if (message.length()<=250){
        return "Message ready to send.";
    }else{
        int excess = message.length()- 250;
        return "Message exceeds 250 characters by" + excess + " please reduce the size";
        
    }
}
    public String createMessageHash(){
        if (message == null || message.isEmpty() || messageID == null)return"";
        String[] words = message.trim().split("\\s+");
        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase().replaceAll("[^A-Z]", "");
        String idPart = messageID.substring(0, 2);
        return idPart + ":" + messageNum + ":" + firstWord + lastWord;    
        
                 
   }
    public String SentMessage(int option){
        switch (option){
            case 1:
                totalMessagesSent++;
                return "Message succesfully sent.";
            case 2:
                return "Press 0 tp delete the message.";
            case 3:
                storeMessage();        
                return"Message successfully stored.";
            default:
                return "Invalid option.";
                
       }
    } 
        
      public void storeMessage(){
          
            try {
                java.io.FileWriter file = new java.io.FileWriter("messages.txt", true);
              file.write("ID:" + messageID + ", Hash:" + messageHash + ",To:" + recipient + ",Msg:" + message + ",\n");
              file.close();
        
            } catch (Exception e){
                e.printStackTrace();
            }
        } 
        public String printMessage(){
            return "Message ID:" + messageID + "\nMessage Hash:" + messageHash + "\nRecipient:" + recipient + ",\nMessage: " + message;
            
        }
        
        public static int returnTotalMessage(){
            return totalMessagesSent;
        }
        public String getMessageID(){ return messageID;}
        public String getMessageHash(){ return messageHash;}
        public String getRecipient() { return recipient; }
        public String getMessage(){ return message; }
        public static void restTotalMessages(){ totalMessagesSent =0;}
} 


    













   
