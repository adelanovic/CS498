package com.application.databaseOps;

import com.application.connection.mongodbStream;
import com.application.gui.loginStage;
import com.mongodb.client.MongoCollection;
import org.bson.BsonArray;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Objects;

import static com.mongodb.client.model.Filters.eq;

public class employeeIO {
    public static MongoCollection<Document> employeesCollection = mongodbStream.database.getCollection("Members");

    //Returns the user_id of the logged in user
    public static String getUserId() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("user_id");
    }

    public static Boolean getisSupervisor() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (Boolean) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("is_supervisor");
    }

    public static String getFirstName() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("first_name");
    }

    public static String getLastName() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("last_name");
    }

    public static String getDob() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("dob");
    }

    public static String getHireDate() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("hire_date");
    }

    public static String getEmailAddress() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("email_address");
    }

    public static String getAddress() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("address");
    }

    public static String getCity() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("city");
    }

    public static String getZipcode() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("zipcode");
    }

    public static String getState() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("state");
    }

    public static String getNextEval() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("next_eval");
    }

    public static Double getSalary() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (Double) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("salary");
    }

    public static String getShiftAssigned() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("shift_assigned");
    }

    public static String getSupervisor() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("supervisor");
    }

    public static String getJobTitle() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("job_title");
    }

    public static BsonArray getCertifications() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (BsonArray) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("certifications");
    }

    public static String getPrimaryContact() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("primary_contact");
    }

    public static String getPrimaryPhone() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("primary_phone");
    }

    public static String getPrimaryRelation() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("primary_relation");
    }

    public static String getPrimaryWorkPhone() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("primary_work_phone");
    }

    public static String getPrimaryAddress() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("primary_address");
    }

    public static String getSecondaryContact() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("secondary_name");
    }

    public static String getSecondaryPhone() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("secondary_phone_number");
    }

    public static String getSecondaryRelation() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("secondary_relation");
    }

    public static String getSecondaryWorkPhone() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("secondary_work_phone");
    }

    public static String getSecondaryAddress() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("secondary_address");
    }

    public static String getVacationTime() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("vacation_time");
    }

    public static String getSickTime() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("sick_time");
    }

    public static String getVacationTimeUsed() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("vacation_time_used");
    }

    public static String getSickTimeUsed() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("sick_time_used");
    }
}