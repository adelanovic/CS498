package com.application.gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;


/**
 * Controller for all operations on the supervisor stage. All updates, deletes and error handling
 * for a supervisor that is logged in are controlled by this class.
 * Class: CS498 Capstone Project
 * Instructor: Professor Spetka, Scott
 * Date: 02/15/2021
 * Last Revision: 02/15/2021
 * @author Adis Delanovic
 *
 */
public class supervisorModeStage {
    @FXML public Button resourcesBtn;
    @FXML public Button passdownsBtn;
    @FXML public Button requestsOffBtn;
    @FXML public Button schedulingBtn;
    @FXML public AnchorPane supervisorMainAnchor;
    @FXML public AnchorPane resourcesMainPane;
    @FXML public WebView supervisorWebView;
    @FXML public WebEngine webEngine;
    @FXML public AnchorPane passdownsAnchor;
    @FXML public AnchorPane requestsAnchor;
    @FXML public AnchorPane schedulingAnchor;
    
/**
 * Handles the stage if the display schedule button is clicked.
 * @param none
 * @return none
 */  
    public void displaySchedulePane(ActionEvent actionEvent) {
        resourcesMainPane.setVisible(false);
        passdownsAnchor.setVisible(false);
        schedulingAnchor.setVisible(true);
        requestsAnchor.setVisible(false);
    }
    
/**
 * Handles the stage if request time off button is clicked.
 * @param none
 * @return none
 */  
    public void requestTimeOffPanee(ActionEvent actionEvent) {
        resourcesMainPane.setVisible(false);
        passdownsAnchor.setVisible(false);
        schedulingAnchor.setVisible(false);
        requestsAnchor.setVisible(true);
    }
    
/**
 * Handles the stage if the daily passdowns button is clicked.
 * @param none
 * @return none
 */  
    public void displayDailyPassdownsPane(ActionEvent actionEvent) {
        passdownsAnchor.setVisible(true);
        resourcesMainPane.setVisible(false);
        schedulingAnchor.setVisible(false);
        requestsAnchor.setVisible(false);
    }
    
/**
 * Handles the stage for the Resources Pane. Currently takes a supervisor to resources for forms and information.
 * @param none
 * @return none
 */  
    public void displayResourcesPane(ActionEvent actionEvent) {
        resourcesMainPane.setVisible(true);
        passdownsAnchor.setVisible(false);
        schedulingAnchor.setVisible(false);
        requestsAnchor.setVisible(false);
        webEngine = supervisorWebView.getEngine();
        webEngine.load("https://www.e-publishing.af.mil/Product-Index/");


        webEngine.getLoadWorker().exceptionProperty().addListener(new ChangeListener<Throwable>() {
            @Override
            public void changed(ObservableValue<? extends Throwable> observable, Throwable oldValue, Throwable newValue) {
                System.out.println("Error Occured!");
            }
        });
    }
}
