package com.application.gui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * Controller for the main and primary stage of the application after a successful login.
 * All other stages are attached to it. This is the parent stage. 
 * Class: CS498 Capstone Project
 * Instructor: Professor Spetka, Scott
 * Date: 02/15/2021
 * Last Revision: 02/15/2021
 * @author Adis Delanovic
 *
 */

public class parentmainStage {
    public FXMLLoader viewsLoader;
    public regemployeeStage regEmployees;
    public supervisorModeStage supervisorMode;
    @FXML
    public AnchorPane mainstageAnchorPane;
    @FXML
    public AnchorPane mainView;
    @FXML
    public AnchorPane menuBarAnchorPane;
    @FXML
    public Pane applicationPane;
    @FXML
    public Button exitApplication;
    @FXML
    public Button logOutBtn;
    @FXML
    public Button cancelBtn;


    public void openExitMenu(MouseEvent mouseEvent) {
        if (!applicationPane.isVisible()) {
            applicationPane.setVisible(true);
        } else {
            applicationPane.setVisible(false);
        }
    }

    public void exitApplicationBtnClicked(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void logOutBtnClicked(ActionEvent actionEvent) {

    }

}
