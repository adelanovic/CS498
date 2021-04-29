package com.application.databaseOps;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


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



    public String getUserId() {
        return userId;
    }

    public String getRequest_end() {
        return request_end;
    }

    public String getRequest_start(){
        return requestStart;
    }

    public String getRequest_Status(){
        return status;
    }

    public String getReason(){
        return reason;
    }
}
