package com.application.gui;


import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;


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
    @FXML public TextField requestTime;
    @FXML public TextField requestTime1;
    @FXML public TextField requestDate11;
    @FXML public DatePicker requestStartDate;
    @FXML public DatePicker requestEndDate;
    @FXML public Button editPersonalInfo11;
    @FXML public Pane approvalNotifications;
}
