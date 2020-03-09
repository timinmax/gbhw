package JavaFXWay;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable {
    @FXML
    private TextField typedMessage;
    @FXML
    private TextArea conversationPanel;
    @FXML
    private ListView<String> contactsList;

    @FXML
    private Button sendBtn;

    @FXML
    private GBChat gbChat;

    @FXML
    public void handleButtonAction() {
        this.gbChat.addMyMessage();
    }

    @FXML
    public void handleContactListClicked() {

        gbChat.setCurrentChatName(contactsList.getSelectionModel().getSelectedItem());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.gbChat  = new GBChat(typedMessage,conversationPanel,contactsList, sendBtn);
        gbChat.refreshContactList();
    }
}
