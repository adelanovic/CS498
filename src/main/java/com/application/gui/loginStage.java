package com.application.gui;

import com.application.connection.mongodbStream;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;

/* This class is responsible for logging into the Database */

public class loginStage {
    @FXML public AnchorPane loginPane;
    @FXML public PasswordField passwordField;
    @FXML private Button loginBtn;
    @FXML private CheckBox supervisorMode;
    public TextField usernameField;
    public static mongodbStream activeUser = new mongodbStream();
    public static parentmainStage mainStage;


    @FXML
    private void loginClicked(Event e) {
        try {
            //activeUser.setPassword(passwordField.getText());
            //activeUser.setEmailAddress(usernameField.getText());
            //activeUser.connectDatabase();

            FXMLLoader mainStageLoader = new FXMLLoader(getClass().getResource("/stages/parentStage.fxml"));
            Parent root = mainStageLoader.load();
            mainStage = mainStageLoader.getController();
            loginBtn.getScene().setRoot(root);

            if(supervisorMode.isSelected()) {
                mainStage.viewsLoader = new FXMLLoader(getClass().getResource("/stages/supervisorMode.fxml"));
                Parent supervisorRoot = mainStage.viewsLoader.load();
                mainStage.regEmployees = mainStage.viewsLoader.getController();
                mainStage.mainView.getChildren().setAll(supervisorRoot);
            }
            else{
                mainStage.viewsLoader = new FXMLLoader(getClass().getResource("/stages/regularEmployee.fxml"));
                Parent employeesRoot = mainStage.viewsLoader.load();
                mainStage.regEmployees = mainStage.viewsLoader.getController();
                mainStage.mainView.getChildren().setAll(employeesRoot);
            }


        } catch (Exception loadException){
            //
        }
    }

    public void exitClicked(ActionEvent actionEvent) {
    }
}
