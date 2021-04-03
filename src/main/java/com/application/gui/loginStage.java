package com.application.gui;

import com.application.connection.mongodbStream;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import org.graalvm.compiler.asm.sparc.SPARCAssembler;


/* This class is responsible for logging into the Database */

public class loginStage {
    @FXML public AnchorPane loginPane;
    @FXML public PasswordField passwordField;
    @FXML private Button loginBtn;
    public TextField usernameField;
    public static mongodbStream activeUser = new mongodbStream();
    private FXMLLoader mainStageLoader;
    public static parentmainStage mainStage;


    @FXML
    private void loginClicked(Event e) {
        try {
            activeUser.setPassword(passwordField.getText());
            activeUser.setEmailAddress(usernameField.getText());
            activeUser.connectDatabase();
            mainStageLoader = new FXMLLoader(getClass().getResource("/stages/parentStage.fxml"));
            Parent root = mainStageLoader.load();
            mainStage = mainStageLoader.getController();
            loginBtn.getScene().setRoot(root);

        } catch (Exception loadException){
            //
        }

    }

    @FXML private void displayLogin(Event e){
        loginPane.setVisible(true);
    }

    @FXML private void hideLogin(Event e){
        loginPane.setVisible(false);
    }
}
