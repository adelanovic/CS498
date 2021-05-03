package com.application.gui;

import com.application.connection.mongodbStream;
import com.application.databaseOps.employeeIO;
import com.application.databaseOps.requestsIO;
import com.mongodb.client.MongoCollection;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;


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
    @FXML public Pane timeOffRequests;

    /**
 * Handles the stage if the display schedule button is clicked.
 */  
    public void displaySchedulePane(ActionEvent actionEvent) {
        resourcesMainPane.setVisible(false);
        passdownsAnchor.setVisible(false);
        schedulingAnchor.setVisible(true);
        requestsAnchor.setVisible(false);
    }
    
/**
 * Handles the stage if request time off button is clicked.
 */  
    public void requestTimeOffPane(ActionEvent actionEvent) {
        resourcesMainPane.setVisible(false);
        passdownsAnchor.setVisible(false);
        schedulingAnchor.setVisible(false);
        requestsAnchor.setVisible(true);

        getTimeApproval();
    }
    
/**
 * Handles the stage if the daily passdowns button is clicked.
 */  
    public void displayDailyPassdownsPane(ActionEvent actionEvent) {
        passdownsAnchor.setVisible(true);
        resourcesMainPane.setVisible(false);
        schedulingAnchor.setVisible(false);
        requestsAnchor.setVisible(false);
    }
    
/**
 * Handles the stage for the Resources Pane. Currently takes a supervisor to resources for forms and information.
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

    public void getTimeApproval(){
        ColumnConstraints[] columnConstraintses = new ColumnConstraints[10];
        RowConstraints[] rowConstraintses = new RowConstraints[10];

        for (int i = 0 ; i < 10 ; i++) {
            columnConstraintses[i] = new ColumnConstraints(90);
            rowConstraintses[i] = new RowConstraints(50);
        }

        int i,j = 0,k = 0;

        requestsIO.getRequestsForSupervisor();
        GridPane gridPane = new GridPane();

        gridPane.getColumnConstraints().addAll(columnConstraintses);
        gridPane.getRowConstraints().addAll(rowConstraintses);

        for (i = 0; i < requestsIO.requests.size(); i++) {
            Button approveBtn = new Button();
            Button denyBtn = new Button();



            Text requestName = new Text();
            Text requestStart = new Text();
            Text requestEnd = new Text();
            Text status = new Text();
            Text requestReason = new Text();
            Text starTime = new Text();
            Text endTime = new Text();
            Text typeRequest = new Text();


            String nameofEmployee = requestsIO.requests.get(i).getFirstName() + " " + requestsIO.requests.get(i).getLastName();
            requestName.setText(nameofEmployee);
            requestStart.setText(requestsIO.requests.get(i).getRequest_start());
            requestEnd.setText(requestsIO.requests.get(i).getRequest_end());
            status.setText(requestsIO.requests.get(i).getRequest_Status());
            requestReason.setText(requestsIO.requests.get(i).getReason());
            starTime.setText(requestsIO.requests.get(i).getStartTime());
            endTime.setText(requestsIO.requests.get(i).getEndTime());
            typeRequest.setText(requestsIO.requests.get(i).getType());

            if(requestsIO.requests.get(i).getRequest_Status().equals("approved")){
                approveBtn.setMinHeight(23);
                approveBtn.setMinWidth(75);
                approveBtn.setText("Approved");
                approveBtn.setStyle("-fx-background-color:   #f6a91c; -fx-text-fill: black");

                denyBtn.setText("Deny");
                denyBtn.setMinHeight(23);
                denyBtn.setMinWidth(75);
                denyBtn.setStyle("-fx-background-color:  red; -fx-text-fill: white");
            }else if(requestsIO.requests.get(i).getRequest_Status().equals("denied")){
                approveBtn.setText("Approve");
                approveBtn.setMinHeight(23);
                approveBtn.setMinWidth(75);
                approveBtn.setStyle("-fx-background-color:  blue; -fx-text-fill: white");

                denyBtn.setText("Denied");
                denyBtn.setMinHeight(23);
                denyBtn.setMinWidth(75);
                denyBtn.setStyle("-fx-background-color:  #f6a91c; -fx-text-fill: black");
            } else{
                approveBtn.setText("Approve");
                approveBtn.setMinHeight(23);
                approveBtn.setMinWidth(75);
                approveBtn.setStyle("-fx-background-color:  blue; -fx-text-fill: white");


                denyBtn.setText("Deny");
                denyBtn.setMinHeight(23);
                denyBtn.setMinWidth(75);
                denyBtn.setStyle("-fx-background-color:  red; -fx-text-fill: white");
            }

            gridPane.add(requestName, k,j);
            gridPane.add(requestStart, k+1, j);
            gridPane.add(requestEnd, k+2, j);
            gridPane.add(starTime, k+3,j);
            gridPane.add(endTime, k+4,j);
            gridPane.add(requestReason, k+5,j);
            gridPane.add(typeRequest,k+6, j);
            gridPane.add(status, k+7,j);
            gridPane.add(approveBtn, k+8, j);
            gridPane.add(denyBtn, k+9, j);

            //Handles the approve button
            approveBtn.setOnMouseClicked(f -> {
                Node source = (Node) f.getSource();
                int row = GridPane.getRowIndex(source);
                MongoCollection<Document> requestsCollection = mongodbStream.database.getCollection("TimeOffRequests");
                Bson filter = and(eq("supervisor_id", employeeIO.getUserId()), eq("request_start",requestsIO.requests.get(row).getRequest_start()));

                Bson newValue = new Document("status", "approved");
                Bson operation = new Document("$set", newValue);

                requestsCollection.updateOne(filter, operation);
                approveBtn.setText("Approved");
                approveBtn.setStyle("-fx-background-color:   #f6a91c; -fx-text-fill: black");
            });

            //Handles the cancel button
            denyBtn.setOnMouseClicked(f -> {
                Node source = (Node) f.getSource();
                int row = GridPane.getRowIndex(source);
                MongoCollection<Document> requestsCollection = mongodbStream.database.getCollection("TimeOffRequests");
                Bson filter = and(eq("supervisor_id", employeeIO.getUserId()), eq("request_start",requestsIO.requests.get(row).getRequest_start()));

                Bson newValue = new Document("status", "denied");
                Bson operation = new Document("$set", newValue);

                requestsCollection.updateOne(filter, operation);
                denyBtn.setText("Denied");
                denyBtn.setStyle("-fx-background-color:   #f6a91c; -fx-text-fill: black");
            });

            j++;
        }
        timeOffRequests.getChildren().addAll(gridPane);

    }

    public void loadDefaultPane() {
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
