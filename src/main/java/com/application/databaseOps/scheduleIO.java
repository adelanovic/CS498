package com.application.databaseOps;

import com.application.connection.mongodbStream;
import com.application.gui.loginStage;
import com.mongodb.client.MongoCollection;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.Objects;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;


/**
 * Defines the operations required to get the current schedule of the employee.
 * Class: CS498 Capstone Project
 * Instructor: Professor Spetka, Scott
 * Date: 02/15/2021
 * Last Revision: 02/15/2021
 * @author Adis Delanovic
 *
 */

public class scheduleIO {
    public static MongoCollection<Document> scheduleCollection = mongodbStream.database.getCollection("Schedule");
    public static MongoCollection<Document> employeesCollection = mongodbStream.database.getCollection("Members");


/**
 * Display the weekly schedule for the employee
 */
    public static void getSchedule(){
        String textStyle = "-fx-font-size: 16px;";
        Text date = new Text();
        Text postMonday = new Text();
        Text postTuesday = new Text();
        Text postWednesday = new Text();
        Text postThursday = new Text();
        Text postFriday = new Text();
        Text postSaturday = new Text();
        Text postSunday = new Text();

        postMonday.setStyle(textStyle);
        postMonday.setFill(Color.WHITE);
        postFriday.setFill(Color.WHITE);
        postFriday.setStyle(textStyle);
        postSaturday.setStyle(textStyle);
        postSaturday.setFill(Color.WHITE);
        postTuesday.setStyle(textStyle);
        postTuesday.setFill(Color.WHITE);
        postWednesday.setStyle(textStyle);
        postWednesday.setFill(Color.WHITE);
        postThursday.setStyle(textStyle);
        postThursday.setFill(Color.WHITE);
        postSunday.setStyle(textStyle);
        postSunday.setFill(Color.WHITE);
        date.setFill(Color.WHITE);
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

/**
 * Display the current date range of the schedule.
 * @return String, contains the current Date range of the schedule
 */
    public static String getDate() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(scheduleCollection.find(filter).first())).get("date");
    }
    
/**
 * Display the post for Monday.
 * @return String, contains the current post for Monday.
 */    
    public static String getPostMonday() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(scheduleCollection.find(filter).first())).get("post_monday");
    }
    
/**
 * Display the current post for Tuesday.
 * @return String, contains the current post for Tuesday.
 */     
    public static String getPostTuesday() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(scheduleCollection.find(filter).first())).get("post_tuesday");
    }
/**
 * Display the current post for Wednesday.
 * @return String, contains the current post for Wednesday.
 */     
    public static String getPostWednesday() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(scheduleCollection.find(filter).first())).get("post_wednesday");
    }
    
/**
 * Display the current post for Thursday.
 * @return String, contains the current post for Thursday.
 */     
    public static String getPostThursday() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(scheduleCollection.find(filter).first())).get("post_thursday");
    }
    
/**
 * Display the current post for Friday.
 * @return String, contains the current post for Friday.
 */     
    public static String getPostFriday() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(scheduleCollection.find(filter).first())).get("post_friday");
    }
    
/**
 * Display the current post Saturday.
 * @return String, contains the current post for Saturday.
 */     
    public static String getPostSaturday() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(scheduleCollection.find(filter).first())).get("post_saturday");
    }
    
/**
 * Display the current post Sunday
 * @return String, contains the current post for Sunday.
 */     
    public static String getPostSunday() {
        Bson filter = eq("email_address", loginStage.activeUser.getUsername());
        return (String) (Objects.requireNonNull(scheduleCollection.find(filter).first())).get("post_sunday");
    }

    /**
     * Creates a new schedule for an employee
     * @param  name, start, end, starTime, endTime, post
     */
    public static void createNewSchedule(String name, String start, String end, String startTime, String endTime, String post) {
        Document request = new Document("_id", new ObjectId());
        request.append("name", name)
                .append("post", post)
                .append("start_date", start)
                .append("end_date", end)
                .append("start_time", startTime)
                .append("end_time", endTime)
                .append("supervisor_id", employeeIO.getUserId())
                .append("supervisor_name", employeeIO.getFirstName() + " " + employeeIO.getLastName());

        scheduleCollection.insertOne(request);

    }
}
