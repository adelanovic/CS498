package com.application.gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

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

    public void displaySchedulePane(ActionEvent actionEvent) {
        resourcesMainPane.setVisible(false);
        passdownsAnchor.setVisible(false);
        schedulingAnchor.setVisible(true);
        requestsAnchor.setVisible(false);
    }

    public void requestTimeOffPanee(ActionEvent actionEvent) {
        resourcesMainPane.setVisible(false);
        passdownsAnchor.setVisible(false);
        schedulingAnchor.setVisible(false);
        requestsAnchor.setVisible(true);
    }

    public void displayDailyPassdownsPane(ActionEvent actionEvent) {
        passdownsAnchor.setVisible(true);
        resourcesMainPane.setVisible(false);
        schedulingAnchor.setVisible(false);
        requestsAnchor.setVisible(false);
    }

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
