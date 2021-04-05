package com.application.databaseOps;

import com.application.connection.mongodbStream;
import com.application.gui.loginStage;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.eq;

public class employeeIO {
    public static MongoCollection<Document> employeesCollection = mongodbStream.database.getCollection("users");

    public static String getUserId() {
        Bson filter = eq("emailAddress", loginStage.activeUser.getUsername());
        return (String) (employeesCollection.find(filter).first()).get("owner_id");
    }

}
