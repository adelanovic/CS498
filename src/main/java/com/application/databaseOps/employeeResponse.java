package com.application.databaseOps;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;


/**
 * Handles certifications of users
 * Class: CS498 Capstone Project
 * Instructor: Professor Spetka, Scott
 * Date: 02/15/2021
 * Last Revision: 02/15/2021
 * @author Adis Delanovic
 *
 */
public class employeeResponse {

    @SerializedName("is_supervisor")
    @Expose
    private boolean isSupervisor;

    @SerializedName("user_id")
    @Expose
    private String userId;

    @SerializedName("first_name")
    @Expose
    private String firstName;

    @SerializedName("last_name")
    @Expose
    private String lastName;

    @SerializedName("certifications")
    @Expose
    private List<String> certifications;
    /**
     * Returns if the user is a supervisor
     * @return String, containing the user ID
     */
    public boolean getIsSupervisor(){
        return isSupervisor;
    }

    /**
     * Returns the user ID of the current user that made the request
     * @return String, containing the user ID
     */
    public String getUserId(){
        return userId;
    }

    /**
     * Returns the first name of the user
     * @return String, containing the user ID
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * Returns the last name of a user
     * @return String, containing the user ID
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * Returns a list of certificates of the user
     * @return List<String>, containing a list of the users current certifications
     */
    public List<String> getCerts() {

        return certifications;
    }
}
