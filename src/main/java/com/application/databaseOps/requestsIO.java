package com.application.databaseOps;

import com.application.connection.mongodbStream;
import com.application.gui.regemployeeStage;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.*;
import java.util.function.Consumer;

import static com.application.gui.loginStage.mainStage;
import static com.mongodb.client.model.Filters.eq;

/**
 * Defines the Employee request operations for requesting time off.
 * Class: CS498 Capstone Project
 * Instructor: Professor Spetka, Scott
 * Date: 02/15/2021
 * Last Revision: 02/15/2021
 * @author Adis Delanovic
 *
 */

public class requestsIO {
    public static MongoCollection<Document> requestsCollection = mongodbStream.database.getCollection("TimeOffRequests");
    public static ArrayList<requestResponse> requests = new ArrayList<>();
    
/**
 * Returns the user ID of the current user that made the request
 * @param requestStart date request end date, type of request, start time, end time and reason. All update certain things in the DB for the request.
 */
    public static void sendNewRequest(String requestStart, String requestEnd, String typeRequest, String startTime, String endTime, String reason) {
        try {
            Document request = new Document("_id", new ObjectId());
            request.append("user_id", employeeIO.getUserId())
                    .append("request_start", requestStart)
                    .append("request_end", requestEnd)
                    .append("type", typeRequest)
                    .append("start_time", startTime)
                    .append("end_time", endTime)
                    .append("reason", reason)
                    .append("supervisor_id", employeeIO.getSupervisorId())
                    .append("supervisor_name", employeeIO.getSupervisor())
                    .append("status", "pending");

            requestsCollection.insertOne(request);

            //Fixing Bug on Dyanmic Loading
            //mainStage.regEmployees.setValues();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
/**
 * Returns all requests of a user. Utilizes the google GSON library to convert from JSON to 
 * an ArrayList. The requestResponse ArrayList is populated.
 */
    public static void getAllRequests() {
        Consumer<Document> printConsumer = new Consumer<Document>() {
            @Override
            public void accept(final Document document) {
                String response = document.toJson();
                JsonElement je = JsonParser.parseString(response);
                Gson gson = new GsonBuilder().create();
                requestResponse responses  = gson.fromJson(je, requestResponse.class);
                requests.add(responses);
            }
        };

        requestsCollection.find(eq("user_id", employeeIO.getUserId()))
                .forEach(printConsumer);
    }
    
/**
 * Returns the request start date of the current user that made the request
 * @return String, containing the request start date.
 */
    public static String getRequestStart() {
        Bson filter = eq("user_id", employeeIO.getUserId());
        return(String)(Objects.requireNonNull(requestsCollection.find(filter).first())).get("request_start");
    }

/**
 * Returns the request end of the current user that made the request
 * @return String, containing request end.
 */    
    public static String getRequestEnd() {
        Bson filter = eq("user_id", employeeIO.getUserId());
        return(String)(Objects.requireNonNull(requestsCollection.find(filter).first())).get("request_end");
    }
    
/**
 * Returns the request status of the current user that made the request
 * @return String, containing the request status (pending/approved)
 */    
    public static String getRequestStatus() {
        Bson filter = eq("user_id", employeeIO.getUserId());
        return(String)(Objects.requireNonNull(requestsCollection.find(filter).first())).get("status");
    }
}
