package PersonnelManager.GUI;

import PersonnelManager.MongoDriver;
import javafx.event.Event;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;


/* This class is responsible for logging into the Database */

public class loginControl {
    @FXML public AnchorPane loginPane;
    @FXML public PasswordField passwordField;

    @FXML private void passwordEntered(KeyEvent e) {
        if (e.getCode().equals(KeyCode.ENTER)) {
            MongoDriver mongo_driver = new MongoDriver();
            mongo_driver.connect_database();
        }
    }

    @FXML private void displayLogin(Event e){
        loginPane.setVisible(true);
    }
}
