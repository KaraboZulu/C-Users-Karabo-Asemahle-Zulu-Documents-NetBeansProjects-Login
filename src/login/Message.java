/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package login;

import java.util.Random;
import org.json.JSONObject;
import org.json.JSONArray;
import java.io.FileWriter;
import java.io.IOException;




/**
 *
 * @author Karabo Asemahle Zulu
 */
public class Message {

    private String messageID;
    private String messageHash;
    private String recipientCell;
    private String message;
    private int messageCount;

    public static int totalMessages = 0;
    public static String[] messageIDs = new String[100];
    public static String[] messageHashes = new String[100];
    public static String[] recipients = new String[100];
    public static String[] storedMessages = new String[100];

    public Message(int messageCount, String recipient, String message){
        this.messageCount = messageCount;
        this.recipientCell = recipient;
        this.message = message;
        this.messageID = createMessageID();
        this.messageHash = createMessageHash();
    }

    public String getMessageID() {
        return messageID;
    }

    public String getMessage() {
        return message;
    }

    public String getRecipientCell() {
        return recipientCell;
    }

    public String getMessageHash() {
        return messageHash;
    }

    private String createMessageID(){
        Random rand = new Random();
        long num = 1000000000L + (long)(rand.nextDouble() * 9000000000L);
        return String.valueOf(num);
    }

    public boolean checkMessageID(){
        return messageID!= null && messageID.length() == 10;
    }

    public String checkRecipientCell(){
        if (recipientCell!= null && recipientCell.length() <= 12 && recipientCell.charAt(0) == '+'){
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted";
        }
    }

    public String createMessageLength(){
        if (message.length() <= 250){
            return "Message ready to send.";
        } else {
            int excess = message.length() - 250;
            return "Message exceeds 250 characters by " + excess + " please reduce the size";
        }
    }

    public String createMessageHash(){
        if (message == null || message.isEmpty() || messageID == null) return "";
        String[] words = message.trim().split("\\s+");
        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase().replaceAll("[^A-Z]", "");
        String idPart = messageID.substring(0, 2);
        return idPart + ":" + messageCount + ":" + firstWord + lastWord;
    }

    public String sentMessage(int option){
        if (option == 1) return "Messages successfully sent";
        if (option == 3) return "Message successfully stored";
        return "Invalid option";
    }

    public void storeMessage(){
        try {
            FileWriter file = new FileWriter("messages.txt", true);
            file.write("ID:" + messageID + ",Hash:" + messageHash + ",To:" + recipientCell + ",Msg:" + message + "\n");
            file.close();
        } catch (Exception e){
            e.printStackTrace();  
        }
    }

    public String printMessage(){
        return "Message ID:" + messageID + "\nMessage Hash:" + messageHash + "\nRecipient:" + recipientCell + "\nMessage: " + message;
    }

    public static void saveStoredMessagesToJSON(){
        JSONArray msgArray = new JSONArray();

        for (int i = 0; i < totalMessages; i++){
            if (storedMessages[i]!= null){
                JSONObject obj = new JSONObject();
                obj.put("messageID", messageIDs[i]);
                obj.put("messageHash", messageHashes[i]);
                obj.put("recipient", recipients[i]);
                obj.put("message", storedMessages[i]);
                msgArray.put(obj);
            }
        }
        try (FileWriter file = new FileWriter("messages.json")){
            file.write(msgArray.toString(4));
            System.out.println("Stored messages saved to messages.json");
        } catch (IOException e){
            System.out.println("Error writing JSON:" + e.getMessage());
        }
    }
}




   
