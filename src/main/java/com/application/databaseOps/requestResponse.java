package com.application.databaseOps;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Defines the Time Off request JSON to GSON Array.
 * Class: CS498 Capstone Project
 * Instructor: Professor Spetka, Scott
 * Date: 02/15/2021
 * Last Revision: 02/15/2021
 * @author Adis Delanovic
 *
 */

public class requestResponse {
    @SerializedName("user_id")
    @Expose
    private String userId;

    @SerializedName("request_start")
    @Expose
    private String requestStart;

    @SerializedName("request_end")
    @Expose
    private String request_end;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("start_time")
    @Expose
    private String startTime;

    @SerializedName("end_time")
    @Expose
    private String endTime;

    @SerializedName("reason")
    @Expose
    private String reason;

    @SerializedName("supervisor_id")
    @Expose
    private String supervisorId;

    @SerializedName("supervisor_name")
    @Expose
    private String supervisorName;

    @SerializedName("status")
    @Expose
    private String status;


/**
 * Returns the user ID of the current user that made the request
 * @param none
 * @return String, containing the user ID
 */
    public String getUserId() {
        return userId;
    }
    
/**
 * Returns the request end date of the current user that made the request
 * @param none
 * @return String, containing the request end date
 */
    public String getRequest_end() {
        return request_end;
    }
    
/**
 * Returns the request start date of the current user that made the request
 * @param none
 * @return String, containing the request start date
 */
    public String getRequest_start(){
        return requestStart;
    }
    
/**
 * Returns the request status of the current user that made the request
 * @param none
 * @return String, containing the status of the request (pending/approved)
 */
    public String getRequest_Status(){
        return status;
    }
    
/**
 * Returns the reason of the current user that made the request
 * @param none
 * @return String, containing the reason for the request
 */
    public String getReason(){
        return reason;
    }
}
