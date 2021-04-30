package com.application.gui;

import com.application.connection.mongodbStream;
import com.application.databaseOps.employeeIO;
import com.mongodb.MongoCommandException;
import com.mongodb.MongoSecurityException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * Controller class for the login.fxml page. Controls all login procedures.
 * Class: CS498 Capstone Project
 * Instructor: Professor Spetka, Scott
 * Date: 02/15/2021
 * Last Revision: 02/15/2021
 * @author Adis Delanovic
 *
 */
public class loginStage {
    @FXML public AnchorPane loginPane;
    @FXML public PasswordField passwordField;
    @FXML public Pane loginErrorField;
    @FXML public Text errorReason;
    @FXML public CheckBox showPasswordChecked;
    @FXML public TextField passwordPlainText;
    @FXML private Button loginBtn;
    @FXML private CheckBox supervisorMode;
    public TextField usernameField;
    public static mongodbStream activeUser = new mongodbStream();
    public static parentmainStage mainStage;
    
/**
 * Handles all login requests after the login button was clicked. Loads the appropriate errors or *.fxml stages.
 */
    @FXML
    private void loginClicked()  {
        try {
            activeUser.setPassword(passwordField.getText());
            activeUser.setEmailAddress(usernameField.getText());
            activeUser.connectDatabase();

            if(supervisorMode.isSelected() && employeeIO.getisSupervisor()) {
                FXMLLoader mainStageLoader = new FXMLLoader(getClass().getResource("/stages/parentStage.fxml"));
                Parent root = mainStageLoader.load();
                mainStage = mainStageLoader.getController();
                loginBtn.getScene().setRoot(root);

                mainStage.viewsLoader = new FXMLLoader(getClass().getResource("/stages/supervisorMode.fxml"));
                Parent supervisorRoot = mainStage.viewsLoader.load();
                mainStage.supervisorMode = mainStage.viewsLoader.getController();
                mainStage.mainView.getChildren().setAll(supervisorRoot);

            }else if(supervisorMode.isSelected() && !employeeIO.getisSupervisor()){
                FXMLLoader mainStageLoader = new FXMLLoader(getClass().getResource("/stages/login.fxml"));
                loginErrorField.setVisible(true);
                errorReason.setText("Permission Denied! You are not a supervisor");
                Parent root = mainStageLoader.load();
                mainStage.mainView.getChildren().setAll(root);

            }else if(passwordField.getText().equals("")){
                FXMLLoader mainStageLoader = new FXMLLoader(getClass().getResource("/stages/login.fxml"));
                loginErrorField.setVisible(true);
                errorReason.setText("Password must be entered!");
                Parent root = mainStageLoader.load();
                mainStage.mainView.getChildren().setAll(root);

            }else if(usernameField.getText().equals("")){
                FXMLLoader mainStageLoader = new FXMLLoader(getClass().getResource("/stages/login.fxml"));
                loginErrorField.setVisible(true);
                errorReason.setText("Username must be entered!");
                Parent root = mainStageLoader.load();
                mainStage.mainView.getChildren().setAll(root);
            }
            else{
                FXMLLoader mainStageLoader = new FXMLLoader(getClass().getResource("/stages/parentStage.fxml"));
                Parent root = mainStageLoader.load();
                mainStage = mainStageLoader.getController();
                loginBtn.getScene().setRoot(root);
                mainStage.viewsLoader = new FXMLLoader(getClass().getResource("/stages/regularEmployee.fxml"));

                Parent employeesRoot = mainStage.viewsLoader.load();
                mainStage.regEmployees = mainStage.viewsLoader.getController();
                mainStage.mainView.getChildren().setAll(employeesRoot);
                mainStage.regEmployees.setValues();
            }

        } catch (MongoCommandException | MongoSecurityException e ) {
            System.out.println("Password Error");
        } catch (Exception loadException){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("An Error Occurred!");
            alert.setHeaderText("Warning");
            alert.setContentText("A restart of the application is required. An error unexpected error occurred!");
        }
    }
    
/**
 * Exits the application and disconnects from the database cleaning up any active threads..
 */  
    public void exitClicked(ActionEvent actionEvent) {
        Platform.exit();
    }

/**
 * Toggles the show password checkbox. The user is shown the password as either masked with '*' or plain text.
 */      
    public void toggleShowPassword(ActionEvent actionEvent) {
        if (showPasswordChecked.isSelected()) {
            passwordPlainText.setText(passwordField.getText());
            passwordPlainText.setVisible(true);
            passwordField.setVisible(false);
        } else {
            passwordField.setText(passwordPlainText.getText());
            passwordPlainText.setVisible(false);
            passwordField.setVisible(true);
        }
    }
}
