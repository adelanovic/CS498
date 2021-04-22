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

    public static String getSupervisorId() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("supervisor_id");
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

    //Setter Methods
    public static void setFirstName(String firstName){
        Document find = employeesCollection.find(new Document("first_name", getFirstName())).first();

        try {
            if (find != null) {
                Bson newValue = new Document("first_name", firstName);
                Bson operation = new Document("$set", newValue);
                employeesCollection.updateOne(find, operation);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void setLastName(String lastName){
        Document find = employeesCollection.find(new Document("last_name", getLastName())).first();

        try {
            if (find != null) {
                Bson newValue = new Document("last_name", lastName);
                Bson operation = new Document("$set", newValue);
                employeesCollection.updateOne(find, operation);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void setAddress(String address){
        Document find = employeesCollection.find(new Document("address", getAddress())).first();

        try {
            if (find != null) {
                Bson newValue = new Document("address", address);
                Bson operation = new Document("$set", newValue);
                employeesCollection.updateOne(find, operation);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void setZipcode(String zipcode){
        Document find = employeesCollection.find(new Document("zipcode", getZipcode())).first();

        try {
            if (find != null) {
                Bson newValue = new Document("zipcode", zipcode);
                Bson operation = new Document("$set", newValue);
                employeesCollection.updateOne(find, operation);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void setCity(String city){
        Document find = employeesCollection.find(new Document("city", getCity())).first();

        try {
            if (find != null) {
                Bson newValue = new Document("city", city);
                Bson operation = new Document("$set", newValue);
                employeesCollection.updateOne(find, operation);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void setState(String state){
        Document find = employeesCollection.find(new Document("state", getState())).first();

        try {
            if (find != null) {
                Bson newValue = new Document("state", state);
                Bson operation = new Document("$set", newValue);
                employeesCollection.updateOne(find, operation);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //Primary Contact
    public static void setEmergencyName(String newEmergencyName) {
        Document find = employeesCollection.find(new Document("primary_contact", getPrimaryContact())).first();

        try {
            if (find != null) {
                Bson newValue = new Document("primary_contact", newEmergencyName);
                Bson operation = new Document("$set", newValue);
                employeesCollection.updateOne(find, operation);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void setEmergencyPhone(String newEmergencyPhone) {
        Document find = employeesCollection.find(new Document("primary_phone", getPrimaryPhone())).first();

        try {
            if (find != null) {
                Bson newValue = new Document("primary_phone", newEmergencyPhone);
                Bson operation = new Document("$set", newValue);
                employeesCollection.updateOne(find, operation);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void setEmergencyRelation(String newRelation) {
        Document find = employeesCollection.find(new Document("primary_relation", getPrimaryRelation())).first();

        try {
            if (find != null) {
                Bson newValue = new Document("primary_relation", newRelation);
                Bson operation = new Document("$set", newValue);
                employeesCollection.updateOne(find, operation);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void setEmergencyAddress(String newAddress) {
        Document find = employeesCollection.find(new Document("primary_address", getPrimaryAddress())).first();

        try {
            if (find != null) {
                Bson newValue = new Document("primary_address", newAddress);
                Bson operation = new Document("$set", newValue);
                employeesCollection.updateOne(find, operation);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void setEmergencyWorkPhone(String newWorkPhone) {
        Document find = employeesCollection.find(new Document("primary_work_phone", getPrimaryWorkPhone())).first();

        try {
            if (find != null) {
                Bson newValue = new Document("primary_work_phone", newWorkPhone);
                Bson operation = new Document("$set", newValue);
                employeesCollection.updateOne(find, operation);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //Secondary Contact
    public static void setSecEmergencyName(String newEmergencyName) {
        Document find = employeesCollection.find(new Document("secondary_name", getSecondaryContact())).first();

        try {
            if (find != null) {
                Bson newValue = new Document("secondary_name", newEmergencyName);
                Bson operation = new Document("$set", newValue);
                employeesCollection.updateOne(find, operation);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void setSecEmergencyPhone(String newEmergencyPhone) {
        Document find = employeesCollection.find(new Document("secondary_phone_number", getSecondaryPhone())).first();

        try {
            if (find != null) {
                Bson newValue = new Document("secondary_phone_number", newEmergencyPhone);
                Bson operation = new Document("$set", newValue);
                employeesCollection.updateOne(find, operation);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void setSecEmergencyRelation(String newRelation) {
        Document find = employeesCollection.find(new Document("secondary_relation", getSecondaryRelation())).first();

        try {
            if (find != null) {
                Bson newValue = new Document("secondary_relation", newRelation);
                Bson operation = new Document("$set", newValue);
                employeesCollection.updateOne(find, operation);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void setSecEmergencyAddress(String newAddress) {
        Document find = employeesCollection.find(new Document("secondary_address", getSecondaryAddress())).first();

        try {
            if (find != null) {
                Bson newValue = new Document("secondary_address", newAddress);
                Bson operation = new Document("$set", newValue);
                employeesCollection.updateOne(find, operation);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void setSecEmergencyWorkPhone(String newWorkPhone) {
        Document find = employeesCollection.find(new Document("secondary_work_phone", getSecondaryWorkPhone())).first();

        try {
            if (find != null) {
                Bson newValue = new Document("secondary_work_phone", newWorkPhone);
                Bson operation = new Document("$set", newValue);
                employeesCollection.updateOne(find, operation);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}