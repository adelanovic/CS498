package com.application.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class supervisorModeStage {
    @FXML public Button resourcesBtn;
    @FXML public Button passdownsBtn;
    @FXML public Button requestsOffBtn;
    @FXML public Button schedulingBtn;
    @FXML public AnchorPane supervisorMainAnchor;

    public void displaySchedulePane(ActionEvent actionEvent) {
        System.out.println("Test....");
    }

    public void requestTimeOffPanee(ActionEvent actionEvent) {
        System.out.println("Test....");
    }

    public void displayDailyPassdownsPane(ActionEvent actionEvent) {
        System.out.println("Test....");
    }

    public void displayResourcesPane(ActionEvent actionEvent) {
        System.out.println("Test....");
    }
}
