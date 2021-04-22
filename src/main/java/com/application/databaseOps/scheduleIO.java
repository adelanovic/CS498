package com.application.databaseOps;

import com.application.connection.mongodbStream;
import com.application.gui.loginStage;
import com.mongodb.client.MongoCollection;
import javafx.scene.text.Text;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Objects;

import static com.mongodb.client.model.Filters.eq;

public class scheduleIO {
    public static MongoCollection<Document> scheduleCollection = mongodbStream.database.getCollection("Schedule");

    public static void createNewSchedule(){

    }

    public static void getSchedule(){
        String textStyle = "-fx-text-color: red; -fx-font-size: 16px;";
        Text date = new Text();
        Text postMonday = new Text();
        Text postTuesday = new Text();
        Text postWednesday = new Text();
        Text postThursday = new Text();
        Text postFriday = new Text();
        Text postSaturday = new Text();
        Text postSunday = new Text();

        postMonday.setStyle(textStyle);
        postFriday.setStyle(textStyle);
        postSaturday.setStyle(textStyle);
        postTuesday.setStyle(textStyle);
        postWednesday.setStyle(textStyle);
        postThursday.setStyle(textStyle);
        postSunday.setStyle(textStyle);
        date.setStyle(textStyle);

        postMonday.setText(getPostMonday());
        postTuesday.setText(getPostFriday());
        postWednesday.setText(getPostWednesday());
        postThursday.setText(getPostThursday());
        postFriday.setText(getPostFriday());
        postSaturday.setText(getPostSaturday());
        postSunday.setText(getPostSunday());
        date.setText(getDate());

        loginStage.mainStage.regEmployees.scheduleGridPane.add(date, 1,0);
        loginStage.mainStage.regEmployees.scheduleGridPane.add(postMonday, 1,2);
        loginStage.mainStage.regEmployees.scheduleGridPane.add(postTuesday, 2,2);
        loginStage.mainStage.regEmployees.scheduleGridPane.add(postWednesday, 3,2);
        loginStage.mainStage.regEmployees.scheduleGridPane.add(postThursday, 4,2);
        loginStage.mainStage.regEmployees.scheduleGridPane.add(postFriday, 5,2);
        loginStage.mainStage.regEmployees.scheduleGridPane.add(postSaturday, 6,2);
        loginStage.mainStage.regEmployees.scheduleGridPane.add(postSunday,7,2);
    }

    public static String getDate() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(scheduleCollection.find(filter).first())).get("date");
    }
    public static String getPostMonday() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(scheduleCollection.find(filter).first())).get("post_monday");
    }
    public static String getPostTuesday() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(scheduleCollection.find(filter).first())).get("post_tuesday");
    }
    public static String getPostWednesday() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(scheduleCollection.find(filter).first())).get("post_wednesday");
    }
    public static String getPostThursday() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(scheduleCollection.find(filter).first())).get("post_thursday");
    }
    public static String getPostFriday() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(scheduleCollection.find(filter).first())).get("post_friday");
    }
    public static String getPostSaturday() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(scheduleCollection.find(filter).first())).get("post_saturday");
    }
    public static String getPostSunday() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(scheduleCollection.find(filter).first())).get("post_sunday");
    }

}
