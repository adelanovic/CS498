package com.application.gui;


import com.application.databaseOps.employeeIO;
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
    }
}
