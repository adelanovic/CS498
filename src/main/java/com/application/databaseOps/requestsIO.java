package com.application.databaseOps;

import com.application.connection.mongodbStream;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

public class requestsIO {
    public static MongoCollection<Document> requestsCollection = mongodbStream.database.getCollection("TimeOffRequests");

    public static void sendNewRequest(String requestStart, String requestEnd, String typeRequest, String startTime, String endTime, String reason){
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
                    .append("supervisor_name", employeeIO.getSupervisor());

            requestsCollection.insertOne(request);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void getAllRequests(){

    }
}
