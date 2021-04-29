package com.application.databaseOps;

import com.application.connection.mongodbStream;
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

import static com.mongodb.client.model.Filters.eq;

public class requestsIO {
    public static MongoCollection<Document> requestsCollection = mongodbStream.database.getCollection("TimeOffRequests");
    public static ArrayList<requestResponse> requests = new ArrayList<>();

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
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

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

    public static String getRequestStart() {
        Bson filter = eq("user_id", employeeIO.getUserId());
        return(String)(Objects.requireNonNull(requestsCollection.find(filter).first())).get("request_start");
    }

    public static String getRequestEnd() {
        Bson filter = eq("user_id", employeeIO.getUserId());
        return(String)(Objects.requireNonNull(requestsCollection.find(filter).first())).get("request_end");
    }

    public static String getRequestStatus() {
        Bson filter = eq("user_id", employeeIO.getUserId());
        return(String)(Objects.requireNonNull(requestsCollection.find(filter).first())).get("status");
    }




}
