package com.application.connection;

import com.mongodb.ConnectionString;
import com.mongodb.client.*;
import com.mongodb.MongoClientSettings;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.logging.Level;

/**
 * Creates a connection between the application and the MongoDB Cluster.
 * Class: CS498 Capstone Project
 * Instructor: Professor Spetka, Scott
 * Date: 02/06/2021
 * Last Revision: 02/06/2021
 * @author Adis Delanovic
 *
 */

public class mongodbStream {
    private String username;
    private String password;
    private String db_name;
    public static MongoClient mongo_client; //In documents referred to as 'cursor' for methods.
    public static MongoDatabase database; //In documentation referred to as 'db' for methods.

/**
 * Creates the connection to the Database using provided password and username
 * @param none
 * @return 1 on success, -1 on failure
 */

    public void connectDatabase() {
        //Sets a level to the JULLogger, lots of visible text in red on console.
        java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);

        try {
           // Create a connection string
           ConnectionString connectString = new ConnectionString(
            "mongodb://" + encodeValue(getUsername()) + ":" + getPassword() +  "@realm.mongodb.com:27020/?authMechanism=PLAIN&authSource=%24external&ssl=true&appName=securityforces-otexj:mongodb-atlas:local-userpass");

            //Set the settings for the connection
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(connectString)
                    .retryWrites(true)
                    .build();

            //Create the connection
            mongo_client = MongoClients.create(settings);
            System.out.println("Connected");
            database = mongo_client.getDatabase("SecurityForcesCollection");
            MongoCollection<Document> collection = database.getCollection("Members");

        }
        catch(Exception e) {
            System.out.println("Did not connect to Database properly");
            System.out.println(e);
        }

    }

    
/**
 * Disconnects the connection from the database.
 * @param none
 * @return 1 on success, -1 on failure
 */

    public static void disconnect_database() {
        try {
            mongo_client.close();
        }
        catch(Exception e) {
            System.out.println("Unable to disconnect from Database!");
        }
    }

/**
 * Sets the user password.
 * @param password, String that contains a user provided password
 * @return none
 */
    
    public void setPassword(String password) {
        this.password = password;
    }
    
/**
 * Sets the database name.
 * @param db_name, String that contains a user provided database
 * @return none
 */
    public void setDbname(String db_name) {
        this.db_name = db_name;
    }
    
/**
 * Sets the user email.
 * @param username, String that contains a user provided email for logging in.
 * @return none
 */
 
    public void setEmailAddress(String username) {
        this.username = username;
    }
    
/**
 * Gets the current Database.
 * @param none
 * @return db_name, String
 */
  
    public String get_dbname() {
        return this.db_name;
    }
/**
 * Gets the current user provided password.
 * @param none
 * @return password, String
 */
   
    public String getPassword() {
        return this.password;
    }
    
/**
 * Gets the current Database.
 * @param none
 * @return db_name, String
 */
    
    public String getUsername() {
        return this.username;
    }
    
/**
 * Encode an email address so that it can be used as the login method.
 * @param value, user provided email address
 * @return value, encoded email address
 */
    
    private String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
}
