package com.application.gui;

import com.application.connection.mongodbStream;
import com.application.databaseOps.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mongodb.client.MongoCollection;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Consumer;

import static com.application.gui.loginStage.mainStage;
import static com.mongodb.client.model.Filters.*;


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
    @FXML
    public Button resourcesBtn;
    @FXML
    public Button passdownsBtn;
    @FXML
    public Button requestsOffBtn;
    @FXML
    public Button schedulingBtn;
    @FXML
    public AnchorPane supervisorMainAnchor;
    @FXML
    public AnchorPane resourcesMainPane;
    @FXML
    public WebView supervisorWebView;
    @FXML
    public WebEngine webEngine;
    @FXML
    public AnchorPane passdownsAnchor;
    @FXML
    public AnchorPane requestsAnchor;
    @FXML
    public AnchorPane schedulingAnchor;
    @FXML
    public Pane timeOffRequests;
    @FXML
    public Button submitPassdowns;
    @FXML
    public Pane viewPassDownsPane;
    @FXML
    public Button viewPassdowns;
    @FXML
    public ScrollPane viewPassDownsScrollPane;
    @FXML
    public Button closePassdownsBtn;
    @FXML
    public TextArea passdownsTextArea;
    @FXML
    public AnchorPane requestSuccessPane;
    @FXML
    public Text requestSuccessField;
    @FXML
    public Button requestSuccessBtn;
    @FXML
    public Button printPassdowns;
    @FXML
    public Button savePassdowns;
    @FXML
    public Pane currentRoster;
    @FXML
    public Pane schedulePane;
    @FXML
    public Pane createaSchedulePane;
    @FXML
    public DatePicker dateSchedule;
    @FXML
    public VBox rosterVbox;
    @FXML public ComboBox comboBox;

    public GridPane gridPane = new GridPane();
    public VBox vbox = new VBox();
    public static ArrayList<passdownsResponse> requestPassdowns = new ArrayList<passdownsResponse>();
    public static ArrayList<employeeResponse> employeeRoster = new ArrayList<employeeResponse>();


    /**
     * Handles the stage if the display schedule button is clicked.
     */
    public void displaySchedulePane(ActionEvent actionEvent) {
        resourcesMainPane.setVisible(false);
        passdownsAnchor.setVisible(false);
        schedulingAnchor.setVisible(true);
        requestsAnchor.setVisible(false);

        this.vbox.getChildren().removeAll(this.vbox.getChildren());
        getRoster();
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


    /**
     * Handles getting all the day off requests created by an employee.
     */

    public void getTimeApproval() {
        ColumnConstraints[] columnConstraintses = new ColumnConstraints[10];
        RowConstraints[] rowConstraintses = new RowConstraints[10];

        for (int i = 0; i < 10; i++) {
            columnConstraintses[i] = new ColumnConstraints(90);
            rowConstraintses[i] = new RowConstraints(50);
        }

        int i, j = 0, k = 0;

        requestsIO.getRequestsForSupervisor();


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

            if (requestsIO.requests.get(i).getRequest_Status().equals("approved")) {
                approveBtn.setMinHeight(23);
                approveBtn.setMinWidth(75);
                approveBtn.setText("Approved");
                approveBtn.setStyle("-fx-background-color:   #f6a91c; -fx-text-fill: black");

                denyBtn.setText("Deny");
                denyBtn.setMinHeight(23);
                denyBtn.setMinWidth(75);
                denyBtn.setStyle("-fx-background-color:  red; -fx-text-fill: white");
            } else if (requestsIO.requests.get(i).getRequest_Status().equals("denied")) {
                approveBtn.setText("Approve");
                approveBtn.setMinHeight(23);
                approveBtn.setMinWidth(75);
                approveBtn.setStyle("-fx-background-color:  blue; -fx-text-fill: white");

                denyBtn.setText("Denied");
                denyBtn.setMinHeight(23);
                denyBtn.setMinWidth(75);
                denyBtn.setStyle("-fx-background-color:  #f6a91c; -fx-text-fill: black");
            } else {
                approveBtn.setText("Approve");
                approveBtn.setMinHeight(23);
                approveBtn.setMinWidth(75);
                approveBtn.setStyle("-fx-background-color:  blue; -fx-text-fill: white");


                denyBtn.setText("Deny");
                denyBtn.setMinHeight(23);
                denyBtn.setMinWidth(75);
                denyBtn.setStyle("-fx-background-color:  red; -fx-text-fill: white");
            }

            gridPane.add(requestName, k, j);
            gridPane.add(requestStart, k + 1, j);
            gridPane.add(requestEnd, k + 2, j);
            gridPane.add(starTime, k + 3, j);
            gridPane.add(endTime, k + 4, j);
            gridPane.add(requestReason, k + 5, j);
            gridPane.add(typeRequest, k + 6, j);
            gridPane.add(status, k + 7, j);
            gridPane.add(approveBtn, k + 8, j);
            gridPane.add(denyBtn, k + 9, j);

            //Handles the approve button
            approveBtn.setOnMouseClicked(f -> {
                Node source = (Node) f.getSource();
                int row = GridPane.getRowIndex(source);
                MongoCollection<Document> requestsCollection = mongodbStream.database.getCollection("TimeOffRequests");
                Bson filter = and(eq("supervisor_id", employeeIO.getUserId()), eq("request_start", requestsIO.requests.get(row).getRequest_start()));

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
                Bson filter = and(eq("supervisor_id", employeeIO.getUserId()), eq("request_start", requestsIO.requests.get(row).getRequest_start()));

                Bson newValue = new Document("status", "denied");
                Bson operation = new Document("$set", newValue);

                requestsCollection.updateOne(filter, operation);
                denyBtn.setText("Denied");
                denyBtn.setStyle("-fx-background-color:   #f6a91c; -fx-text-fill: black");
            });

            j++;
        }
        mainStage.supervisor.timeOffRequests.getChildren().clear();
        mainStage.supervisor.timeOffRequests.getChildren().addAll(mainStage.supervisor.gridPane);
    }

    /**
     * Handles displaying the default pane for supervisor mode
     */

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

    /**
     * Handles submitting a new passdown to the database for storage.
     */
    public void submitPassdownsClicked(ActionEvent actionEvent) {
        MongoCollection<Document> passdowns = mongodbStream.database.getCollection("Passdowns");
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            String currentDate = formatter.format(date);
            Document request = new Document("_id", new ObjectId());
            request.append("user_id", employeeIO.getUserId())
                    .append("supervisor_name", employeeIO.getLastName() + " " + employeeIO.getFirstName())
                    .append("date", currentDate)
                    .append("passdown", passdownsTextArea.getText());

            passdowns.insertOne(request);

            requestSuccessPane.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles displaying all the passdowns in the database
     */
    public void viewPassdownsClicked(ActionEvent actionEvent) {
        viewPassDownsPane.setVisible(true);
        MongoCollection<Document> passdowns = mongodbStream.database.getCollection("Passdowns");

        ColumnConstraints[] columnConstraintses = new ColumnConstraints[10];
        RowConstraints[] rowConstraintses = new RowConstraints[10];

        for (int i = 0; i < 10; i++) {
            columnConstraintses[i] = new ColumnConstraints(120);
            rowConstraintses[i] = new RowConstraints(50);
        }

        int i, j = 0, k = 0;

        requestsIO.getRequestsForSupervisor();
        GridPane gridPane = new GridPane();

        gridPane.getColumnConstraints().addAll(columnConstraintses);
        gridPane.getRowConstraints().addAll(rowConstraintses);

        Consumer<Document> printConsumer = new Consumer<Document>() {
            @Override
            public void accept(final Document document) {
                String response = document.toJson();
                JsonElement je = JsonParser.parseString(response);
                Gson gson = new GsonBuilder().create();
                passdownsResponse responses = gson.fromJson(je, passdownsResponse.class);
                requestPassdowns.add(responses);
            }
        };

        passdowns.find()
                .forEach(printConsumer);

        for (i = 0; i < requestPassdowns.size(); i++) {
            Text supervisorName = new Text();
            Text dateOfPassdown = new Text();
            Text passDown = new Text();

            supervisorName.setText(requestPassdowns.get(i).getSupervisorName());
            dateOfPassdown.setText(requestPassdowns.get(i).getDate());
            passDown.setText(requestPassdowns.get(i).getPassdown());
            gridPane.add(supervisorName, k, j);
            gridPane.add(dateOfPassdown, k + 1, j);
            gridPane.add(passDown, k + 2, j);

            j++;
        }

        viewPassDownsScrollPane.setContent(gridPane);
    }

    /**
     * Handles closing the passdowns and viewing a new scene
     */
    public void closePassdownsClicked(ActionEvent actionEvent) {
        viewPassDownsPane.setVisible(false);
    }

    /**
     * Handles confirming that a new passdown was submitted
     */
    public void requestBtnConfirmationClicked(ActionEvent actionEvent) {
        requestSuccessPane.setVisible(false);
        passdownsTextArea.setText("");
    }

    /**
     * Handles printing the passdowns to a local printer
     */
    public void printPassdownsClicked(ActionEvent actionEvent) {

    }

    /**
     * Handles saving the passdowns for local storage
     */
    public void savePassdownsBtnClicked(ActionEvent actionEvent) throws IOException {

    }

    /**
     * Handles getting the current employees roster for a supervisor
     */
    public void getRoster() {

        MongoCollection<Document> employeesCollection = mongodbStream.database.getCollection("Members");
        Consumer<Document> printConsumer = new Consumer<Document>() {
            @Override
            public void accept(final Document document) {
                String response = document.toJson();
                JsonElement je = JsonParser.parseString(response);
                Gson gson = new GsonBuilder().create();
                employeeResponse responses = gson.fromJson(je, employeeResponse.class);
                employeeRoster.add(responses);
            }
        };

        employeesCollection.find(eq("supervisor_id", employeeIO.getUserId()))
                .forEach(printConsumer);

        setUpRoster();

        comboBox.getItems().removeAll(comboBox.getItems());
        comboBox.getItems().addAll("Dispatch Operations", "Logistics", "Patrol 1", "Patrol 2", "Patrol 3", "Perimeter");

    }

    /**
     * Handles setting up the roster for the current supervisor logged in
     */
    public void setUpRoster(){
        mainStage.supervisor.currentRoster.getChildren().clear();
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.setSpacing(10);
        for (com.application.databaseOps.employeeResponse employeeResponse : employeeRoster) {
            Text employee = new Text();
            employee.setStyle("-fx-font-size: 12px; -fx-font-weight: bold");
            employee.setText(employeeResponse.getFirstName() + " " + employeeResponse.getLastName());
            vbox.getChildren().add(employee);

        }
        mainStage.supervisor.currentRoster.getChildren().addAll(vbox);
    }
}
