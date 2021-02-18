package PersonnelManager.GUI;

import PersonnelManager.MongoDriver;
import com.mongodb.MongoCommandException;
import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;


/* This class is responsible for logging into the Database */

public class loginControl {
    @FXML public AnchorPane loginPane;
    @FXML public PasswordField passwordField;


    //Method for controlling the Login Screen/Password verification
    @FXML private void passwordEntered(KeyEvent event) {
        try {
            if (event.getCode().equals(KeyCode.ENTER)) {
                if(passwordField.getText().isEmpty())
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Password is required!");
                    alert.setHeaderText(null);
                    alert.setContentText("Your password cannot be left blank.");
                    alert.showAndWait();
                }
                else {

                    MongoDriver mongo_driver = new MongoDriver();
                    mongo_driver.connect_database();
                }
            }
        }catch(MongoCommandException e){
            System.out.println("Incorrect Password or Username!");
            e.printStackTrace();
        }
    }

    @FXML private void displayLogin(Event e){
        loginPane.setVisible(true);
    }

    @FXML private void hideLogin(Event e){
        loginPane.setVisible(false);
    }
}
