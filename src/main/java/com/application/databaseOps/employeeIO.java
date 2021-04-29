package com.application.databaseOps;

import com.application.connection.mongodbStream;
import com.application.gui.loginStage;
import com.mongodb.client.MongoCollection;
import org.bson.BsonArray;
import org.bson.Document;
import org.bson.conversions.Bson;
import java.util.Objects;
import static com.mongodb.client.model.Filters.eq;

/**
 * Defines the Employee Operations to the database.
 * Class: CS498 Capstone Project
 * Instructor: Professor Spetka, Scott
 * Date: 02/15/2021
 * Last Revision: 02/15/2021
 * @author Adis Delanovic
 *
 */

public class employeeIO {
    public static MongoCollection<Document> employeesCollection = mongodbStream.database.getCollection("Members");

    /**
     * Returns the user ID that is currently logged in
     * @param none
     * @return String that contains the User Id from the database.
     */
    public static String getUserId() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("user_id");
    }
    
    /**
     * Returns the supervisor ID of the user that is currently logged in
     * @param none
     * @return String that contains the supervisor ID from the database.
     */
    public static String getSupervisorId() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("supervisor_id");
    }
    
    /**
     * Checks if the current user is a supervisor
     * @param none
     * @return boolean, returns true if the user is a supervisor, false otherwise.
     */
    public static Boolean getisSupervisor() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (Boolean) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("is_supervisor");
    }
    
    /**
     * Gets the first name of the current logged in user.
     * @param none
     * @return String that contains the first name.
     */
    public static String getFirstName() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("first_name");
    }
    
    /**
     * Gets the last name of the current logged in user.
     * @param none
     * @return String that contains the last name.
     */
    public static String getLastName() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("last_name");
    }
    
    /**
     * Gets the date of birth of the current logged in user.
     * @param none
     * @return String that contains the date of birth.
     */
    public static String getDob() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("dob");
    }
    
    /**
     * Gets the hire date of the current logged in user.
     * @param none
     * @return String that contains the hire date.
     */    
    public static String getHireDate() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("hire_date");
    }
    
    /**
     * Gets the email address of the current logged in user.
     * @param none
     * @return String that contains the email address.
     */
    public static String getEmailAddress() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("email_address");
    }
    
    /**
     * Gets the address of the current logged in user.
     * @param none
     * @return String that contains the address.
     */
    public static String getAddress() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("address");
    }
    
    /**
     * Gets the city of the current logged in user.
     * @param none
     * @return String that contains the city.
     */   
    public static String getCity() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("city");
    }
    
    /**
     * Gets the zipcode of the current logged in user.
     * @param none
     * @return String that contains the zipcode.
     */   
    public static String getZipcode() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("zipcode");
    }
    
    /**
     * Gets the state of the current logged in user.
     * @param none
     * @return String that contains the state.
     */
    public static String getState() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("state");
    }
    
    /**
     * Gets the next evaluation date of the current logged in user.
     * @param none
     * @return String that contains the evaluation date.
     */
    public static String getNextEval() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("next_eval");
    }
    
    /**
     * Gets the salary of the current logged in user.
     * @param none
     * @return Double that contains the salary.
     */
    public static Double getSalary() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (Double) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("salary");
    }
    
    /**
     * Gets the shift assigned of the current logged in user.
     * @param none
     * @return String that contains the shift assigned.
     */
    public static String getShiftAssigned() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("shift_assigned");
    }
    
    /**
     * Gets the supervisor name of the current logged in user.
     * @param none
     * @return String that contains the supervisor name.
     */
    public static String getSupervisor() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(employeesCollection.find(filter).first())).get("supervisor");
    }
    
    /**
     * Gets the jog title of the current logged in user.
     * @param none
     * @return String that contains the first name.
     */
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
