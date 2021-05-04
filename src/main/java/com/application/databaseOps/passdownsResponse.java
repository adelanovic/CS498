package com.application.databaseOps;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class passdownsResponse {
    @SerializedName("user_id")
    @Expose
    private String userId;

    @SerializedName("supervisor_name")
    @Expose
    private String supervisorName;

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("passdown")
    @Expose
    private String passdown;

    /**
     * Returns the first name of the user
     * @return String, containing the user ID
     */
    public String getUserId(){
        return userId;
    }

    /**
     * Returns the first name of the user
     * @return String, containing supervisor that created the passdown
     */
    public String getSupervisorName(){
        return supervisorName;
    }
    /**
     * Returns the first name of the user
     * @return String, containing the date of the passdown
     */
    public String getDate(){
        return date;
    }
    /**
     * Returns the first name of the user
     * @return String, containing the passdown
     */
    public String getPassdown(){
        return passdown;
    }


}
