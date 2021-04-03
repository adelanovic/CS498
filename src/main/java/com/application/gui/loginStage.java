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


/* This class is responsible for logging into the Database */

public class loginStage {
    @FXML public AnchorPane loginPane;
    @FXML public PasswordField passwordField;
    @FXML public TextField usernameField;
    public static mongodbStream activeUser = new mongodbStream();
    public static mainStage parentStage;
    public Button loginBtn;


    @FXML
    private void loginClicked(Event e) {
        try {
            activeUser.setPassword(passwordField.getText());
            activeUser.setEmailAddress(usernameField.getText());
            activeUser.connectDatabase();

            FXMLLoader loadParentStage = new FXMLLoader(getClass().getResource("/views/parentStage.fxml"));
            Parent root = (Parent) loadParentStage.load();
            parentStage = loadParentStage.getController();
            loginBtn.getScene().setRoot(root);

            parentStage.viewsLoader = new FXMLLoader(getClass().getResource("/views/regemployeeStage.fxml"));
            Parent regEmployeesMain = (Parent) parentStage.viewsLoader.load();
            parentStage.employeeVew = parentStage.viewsLoader.getController();
            parentStage.mainstageAnchorPane.getChildren().setAll(regEmployeesMain);

        } catch (Exception loadException){
            // Handle exception if fxml document fails to load and show properly
        }

    }

    @FXML private void displayLogin(Event e){
        loginPane.setVisible(true);
    }

    @FXML private void hideLogin(Event e){
        loginPane.setVisible(false);
    }
}
