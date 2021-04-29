package com.application.gui;

import com.application.databaseOps.employeeIO;
import com.application.databaseOps.requestsIO;
import com.application.databaseOps.scheduleIO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.time.format.DateTimeFormatter;

public class regemployeeStage {
    @FXML public AnchorPane mainDashboard;

    @FXML public Button editPersonalInfo;
    @FXML public Button savePersonalInfo;
    @FXML public TextField firstName;
    @FXML public TextField lastName;
    @FXML public TextField hireDate;
    @FXML public TextField salary;
    @FXML public TextArea certifications;
    @FXML public TextField nextEvaluation;
    @FXML public TextField shiftAssigned;
    @FXML public TextField supervisor;
    @FXML public TextField streetAddress;
    @FXML public TextField city;
    @FXML public TextField state;
    @FXML public TextField zipcode;
    @FXML public TextField jobTitle;
    @FXML public TextField emergencyName;
    @FXML public TextField relation;
    @FXML public TextField emergencyPhone;
    @FXML public TextArea emergencyAddress;
    @FXML public TextField emergencyWorkPhone;
    @FXML public Button editPrimaryContact;
    @FXML public Button savePrimaryContact;
    @FXML public TextField emergencyNameSec;
    @FXML public TextField emergencyPhoneSec;
    @FXML public TextField emergencyRelationSec;
    @FXML public TextField emergencyWorkPhoneSec;
    @FXML public TextArea emergencyAddressSec;
    @FXML public Button editSecondaryContact;
    @FXML public Button saveSecondaryContact;
    @FXML public TextField vacationTime;
    @FXML public TextField sickTime;
    @FXML public TextField vacationTimeYTD;
    @FXML public TextField sickTimeYTD;
    @FXML public DatePicker requestStartDate;
    @FXML public DatePicker requestEndDate;
    @FXML public Pane approvalNotifications;
    @FXML public ScrollPane resourceScrollPane;
    @FXML public WebView resourceWebView;
    @FXML public WebView bolowebView;
    public WebEngine webEngine;
    @FXML public Button submitRequest;
    @FXML public TextField requestReason;
    @FXML public TextField requestStartTime;
    @FXML public CheckBox sickTimeChecked;
    @FXML public CheckBox vacationTimeChecked;
    @FXML public TextField requestEndTime;
    @FXML public GridPane scheduleGridPane;
    @FXML public Text timeapprovalNotification;
    @FXML public Tab schedulePane;
    @FXML public Button closeErrorField;
    @FXML public AnchorPane requestErrorPane;
    @FXML public Text errorTexTField;
    @FXML public AnchorPane requestSuccessPane;
    @FXML public Text requestSuccessField;
    @FXML public Button requestSuccessBtn;


    //Sets up all the initial values on regular employee stage load
    @FXML
    public void setValues(){
        //Personal Information
        firstName.setText(employeeIO.getFirstName());
        firstName.setEditable(false);
        lastName.setText(employeeIO.getLastName());
        lastName.setEditable(false);
        streetAddress.setText(employeeIO.getAddress());
        streetAddress.setEditable(false);
        city.setText(employeeIO.getCity());
        city.setEditable(false);
        state.setText(employeeIO.getState());
        state.setEditable(false);
        zipcode.setText(employeeIO.getZipcode());
        zipcode.setEditable(false);

        //Job Related Information
        salary.setText(employeeIO.getSalary().toString());
        salary.setEditable(false);
        hireDate.setText(employeeIO.getHireDate());
        hireDate.setEditable(false);
        jobTitle.setText(employeeIO.getJobTitle());
        jobTitle.setEditable(false);

        //certifications.setText(employeeIO.getCertifications().toString());
        nextEvaluation.setText(employeeIO.getNextEval());
        nextEvaluation.setEditable(false);
        shiftAssigned.setText(employeeIO.getShiftAssigned());
        shiftAssigned.setEditable(false);
        supervisor.setText(employeeIO.getSupervisor());
        supervisor.setEditable(false);

        //Emergency Contact Primary
        emergencyName.setText(employeeIO.getPrimaryContact());
        emergencyPhone.setEditable(false);
        emergencyPhone.setText(employeeIO.getPrimaryPhone());
        emergencyName.setEditable(false);
        emergencyAddress.setText(employeeIO.getPrimaryAddress());
        emergencyAddress.setEditable(false);
        relation.setText(employeeIO.getPrimaryRelation());
        relation.setEditable(false);
        emergencyWorkPhone.setText(employeeIO.getPrimaryWorkPhone());
        emergencyWorkPhone.setEditable(false);

        //Emergency Contact Secondary
        emergencyNameSec.setText(employeeIO.getSecondaryContact());
        emergencyNameSec.setEditable(false);
        emergencyAddressSec.setText(employeeIO.getSecondaryAddress());
        emergencyAddressSec.setEditable(false);
        emergencyRelationSec.setText(employeeIO.getSecondaryRelation());
        emergencyRelationSec.setEditable(false);
        emergencyWorkPhoneSec.setText(employeeIO.getSecondaryWorkPhone());
        emergencyWorkPhoneSec.setEditable(false);
        emergencyPhoneSec.setText(employeeIO.getSecondaryPhone());
        emergencyPhoneSec.setEditable(false);

        //Leave Times
        vacationTime.setText(employeeIO.getVacationTime());
        vacationTime.setEditable(false);
        vacationTimeYTD.setText(employeeIO.getVacationTimeUsed());
        vacationTimeYTD.setEditable(false);
        sickTimeYTD.setText(employeeIO.getSickTimeUsed());
        sickTimeYTD.setEditable(false);
        sickTime.setText(employeeIO.getSickTime());
        sickTime.setEditable(false);

        if(employeeIO.getisSupervisor()){
            schedulePane.setDisable(true);
        }

    }

    public void displayResourcesRegular(Event event) {
        webEngine = resourceWebView.getEngine();
        webEngine.load("https://www.afsfc.af.mil/");

        //Error Check loading
        webEngine.getLoadWorker().exceptionProperty().addListener(new ChangeListener<Throwable>() {
            @Override
            public void changed(ObservableValue<? extends Throwable> observable, Throwable oldValue, Throwable newValue) {
                System.out.println("Error Occured!");
            }
        });
    }

    public void displayBoloPage(Event event) {
        webEngine = bolowebView.getEngine();
        webEngine.load("https://www.fbi.gov/wanted/topten");

        //Error Check loading
        webEngine.getLoadWorker().exceptionProperty().addListener(new ChangeListener<Throwable>() {
            @Override
            public void changed(ObservableValue<? extends Throwable> observable, Throwable oldValue, Throwable newValue) {
                System.out.println("Error Occured!");
            }
        });
    }

    public void editPersonalInfoClicked(ActionEvent actionEvent) {
        savePersonalInfo.setVisible(true);
        editPersonalInfo.setVisible(false);
        firstName.setEditable(true);
        lastName.setEditable(true);
        streetAddress.setEditable(true);
        city.setEditable(true);
        zipcode.setEditable(true);
        state.setEditable(true);

    }

    public void savePersonalInfoClicked(ActionEvent actionEvent) {
        savePersonalInfo.setVisible(false);
        editPersonalInfo.setVisible(true);
        firstName.setEditable(false);
        lastName.setEditable(false);
        streetAddress.setEditable(false);
        city.setEditable(false);
        zipcode.setEditable(false);
        state.setEditable(false);

        String newFname = firstName.getText();
        String newLname = lastName.getText();
        String newAddress = streetAddress.getText();
        String newCity = city.getText();
        String newZipcode = zipcode.getText();
        String newState = state.getText();

        employeeIO.setFirstName(newFname);
        employeeIO.setLastName(newLname);
        employeeIO.setAddress(newAddress);
        employeeIO.setCity(newCity);
        employeeIO.setState(newState);
        employeeIO.setZipcode(newZipcode);

    }

    public void editPrimaryContactClicked(ActionEvent actionEvent) {
        emergencyName.setEditable(true);
        emergencyPhone.setEditable(true);
        relation.setEditable(true);
        emergencyWorkPhone.setEditable(true);
        emergencyAddress.setEditable(true);
        editPrimaryContact.setVisible(false);
        savePrimaryContact.setVisible(true);
    }

    public void savePrimaryContactClicked(ActionEvent actionEvent) {
        emergencyName.setEditable(false);
        emergencyPhone.setEditable(false);
        relation.setEditable(false);
        emergencyWorkPhone.setEditable(false);
        emergencyAddress.setEditable(false);
        editPrimaryContact.setVisible(true);
        savePrimaryContact.setVisible(false);

        String newEmergencyName = emergencyName.getText();
        String newEmergencyPhone = emergencyPhone.getText();
        String newRelation = relation.getText();
        String newAddress = emergencyAddress.getText();
        String newWorkPhone = emergencyWorkPhone.getText();

        employeeIO.setEmergencyName(newEmergencyName);
        employeeIO.setEmergencyPhone(newEmergencyPhone);
        employeeIO.setEmergencyRelation(newRelation);
        employeeIO.setEmergencyAddress(newAddress);
        employeeIO.setEmergencyWorkPhone(newWorkPhone);
    }

    public void editSecondaryContactClicked(ActionEvent actionEvent) {
        emergencyNameSec.setEditable(true);
        emergencyPhoneSec.setEditable(true);
        emergencyRelationSec.setEditable(true);
        emergencyWorkPhoneSec.setEditable(true);
        emergencyAddressSec.setEditable(true);
        editSecondaryContact.setVisible(false);
        saveSecondaryContact.setVisible(true);
    }

    public void saveSecondaryContactClicked(ActionEvent actionEvent) {
        emergencyNameSec.setEditable(false);
        emergencyPhoneSec.setEditable(false);
        emergencyRelationSec.setEditable(false);
        emergencyWorkPhoneSec.setEditable(false);
        emergencyAddressSec.setEditable(false);
        editSecondaryContact.setVisible(true);
        saveSecondaryContact.setVisible(false);

        String newEmergencyName = emergencyNameSec.getText();
        String newEmergencyPhone = emergencyPhoneSec.getText();
        String newRelation = emergencyRelationSec.getText();
        String newAddress = emergencyAddressSec.getText();
        String newWorkPhone = emergencyWorkPhoneSec.getText();

        employeeIO.setSecEmergencyName(newEmergencyName);
        employeeIO.setSecEmergencyPhone(newEmergencyPhone);
        employeeIO.setSecEmergencyRelation(newRelation);
        employeeIO.setSecEmergencyAddress(newAddress);
        employeeIO.setSecEmergencyWorkPhone(newWorkPhone);

        String monday = requestsIO.getRequestStart();
        System.out.println(monday);

    }

    public void submitRequestClicked(ActionEvent actionEvent) {

        try {
            String requestStart = requestStartDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String requestEnd = requestEndDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String typeRequest;
            String startTime = requestStartTime.getText();
            String endTime = requestEndTime.getText();
            String reason = requestReason.getText();

            if(vacationTimeChecked.isSelected() && !sickTimeChecked.isSelected()){
                typeRequest = "Vacation";
                requestsIO.sendNewRequest(requestStart, requestEnd, typeRequest, startTime, endTime, reason);
                requestSuccessPane.setVisible(true);
                requestSuccessField.setText("Your request was successfully submitted!");

            }else if(sickTimeChecked.isSelected() && !vacationTimeChecked.isSelected()) {
                typeRequest = "Sick";
                requestsIO.sendNewRequest(requestStart, requestEnd, typeRequest, startTime, endTime, reason);
                requestSuccessPane.setVisible(true);
                requestSuccessField.setText("Your request was successfully submitted!");

            }else if(sickTimeChecked.isSelected() && vacationTimeChecked.isSelected()){
                requestErrorPane.setVisible(true);
                errorTexTField.setText("You can't select both sick and vacation time!");
            }else{
                typeRequest = "Unknown";
                requestsIO.sendNewRequest(requestStart, requestEnd, typeRequest, startTime, endTime, reason);
                requestSuccessPane.setVisible(true);
                requestSuccessField.setText("Your request was successfully submitted!");
            }

        }catch(Exception e){
            requestErrorPane.setVisible(true);
            errorTexTField.setText("Ensure all fields are properly filled out!");
        }

    }

    public void getScheduleForEmployee(Event event) {
        scheduleIO.getSchedule();
    }

    public void getTimeApproval(Event event) {
        requestsIO.getAllRequests();
    }

    public void closeErrorFieldClicked(ActionEvent actionEvent) {
        requestErrorPane.setVisible(false);

    }

    public void requestBtnConfirmationClicked(ActionEvent actionEvent) {
        requestSuccessPane.setVisible(false);
        requestReason.setText("");
        requestStartDate.getEditor().clear();
        requestEndDate.getEditor().clear();
        requestStartTime.setText("");
        requestEndTime.setText("");

        if(sickTimeChecked.isSelected() || vacationTimeChecked.isSelected()){
            sickTimeChecked.setSelected(false);
            vacationTimeChecked.setSelected(false);
        }
    }
}
