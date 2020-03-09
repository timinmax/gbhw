package JavaFXWay;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GBChat {
    private TextField typedMessage;
    private TextArea conversationPanel;
    private ListView<String> contactsList;
    private Button sendBtn;

    private HashMap<String,String> chatHistory = new HashMap<>();
    private String currentChatName;

    public GBChat(TextField typedMessage, TextArea conversationPanel, ListView<String> contactsList, Button sendBtn) {
        this.typedMessage = typedMessage;
        this.conversationPanel = conversationPanel;
        this.contactsList = contactsList;
        this.sendBtn = sendBtn;
    }

    public void addMyMessage(){
        addMessage(typedMessage.getText().trim(), "Я");

        ////////DEMO\\\\\\\\\\\\
        addMessageFromContact("Reply to: " + typedMessage.getText(), currentChatName);
        ///////////////////////

        typedMessage.setText("");
    }

    public void addMessageFromContact(String message, String sender){
        addMessage(message, sender);
    }

    private void addMessage(String message, String Sender){
        if (message.isEmpty()||currentChatName.isEmpty()) {
            return;
        }

        chatHistory.compute(
                (Sender == "Я")?currentChatName:Sender.trim(),
                (chName,text)-> conversationPanel.getText() + Sender + ": " + message + System.lineSeparator()
        );
        refreshConversation();
    }

    public void setCurrentChatName(String currentChatName) {
        if (currentChatName == null){
            currentChatName = "";
        }
        this.currentChatName = currentChatName.trim();
        refreshConversation();
    }

    private void refreshConversation(){
        if (currentChatName == null || currentChatName.isEmpty()){
            conversationPanel.setText("");
            typedMessage.setText("");
            typedMessage.setEditable(false);
            sendBtn.setDisable(true);
        }else {
            typedMessage.setEditable(true);
            sendBtn.setDisable(false);
            conversationPanel.setText(
                chatHistory.getOrDefault(currentChatName.trim(),"")
            );
        }
    }

    public void refreshContactList(){

        contactList phBook = new contactList();
        phBook.fillDemo();
        HashMap<String, HashSet> phBookRecords = phBook.getPhoneBookRecords();
        ArrayList<String> tmpList = new ArrayList<>();
        phBookRecords.forEach((name, numbersHash)-> tmpList.add(name));

        ObservableList<String> items = FXCollections.observableArrayList (tmpList);


        contactsList.setItems(items);

        refreshConversation();
    }
}
