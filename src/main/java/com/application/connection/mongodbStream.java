package com.application.connection;/*
    Name: Adis Delanovic
    Class: CS498 Capstone Project
    Instructor: Professor Spetka, Scott
    Date: 02/06/2021
    Last Revision: 02/06/2021
    Revision Number: 1
    Description: Create the PersonnelManager.Connections.MongoDriver class. The primary purpose of this class is to connect to MongoDB using the appropriate authentication.
*/

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


public class mongodbStream
{
    private String username;
    private String password;
    private String db_name;
    public static MongoClient mongo_client; //In documents referred to as 'cursor' for methods.
    public static MongoDatabase database; //In documentation referred to as 'db' for methods.

/*
    Name: Adis Delanovic
    Class: CS498 Capstone Project
    Date: 02/06/2021
    Last Revision: 02/06/2021
    Revision Number: 1
    Description: Successfully create a connection to the MongoDB database.
*/

    public void connectDatabase()
    {
        //Sets a level to the JULLogger, lots of visible text in red on console.
        java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);

        try
        {
            //Create a connection string
            ConnectionString connectString = new ConnectionString(
                    "mongodb://" + encodeValue(getUsername()) + ":" + getPassword() + "@realm.mongodb.com:27020/?authMechanism=PLAIN&authSource=%24external&ssl=true&appName=securityforces-fjzcg:Employees:local-userpass");




            //Set the settings for the connection
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(connectString)
                    .retryWrites(true)
                    .build();

            //Create the connection
            mongo_client = MongoClients.create(settings);
            System.out.println("Connected");
            database = mongo_client.getDatabase("Employees");
            MongoCollection<Document> collection = database.getCollection("Employees");

            // Retrieving the documents
            FindIterable<Document> iterDoc = collection.find();
            for (Document document : iterDoc) {
                System.out.println(document);
            }


        }
        catch(Exception e)
        {
            System.out.println("Did not connect to Database properly");
            System.out.println(e);
        }

    }

/*
    Name: Adis Delanovic
    Class: CS498 Capstone Project
    Date: 02/06/2021
    Last Revision: 02/06/2021
    Revision Number: 1
    Description: Terminate a connection to the MongoDB database.
*/

    public static void disconnect_database()
    {
        try
        {
            mongo_client.close();

        }
        catch(Exception e)
        {
            System.out.println("Unable to disconnect from Database!");
        }
    }

    /*
        Name: Adis Delanovic
        Class: CS498 Capstone Project
        Date: 02/06/2021
        Last Revision: 02/06/2021
        Revision Number: 1
        Description: Getters and Setter functions for password, username, and database names.
    */
    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setDbname(String db_name)
    {
        this.db_name = db_name;
    }

    public void setEmailAddress(String username)
    {
        this.username = username;
    }

    public String get_dbname()
    {
        return this.db_name;
    }

    public String getPassword()
    {
        return this.password;
    }

    public String getUsername()
    {
        return this.username;
    }

    private String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
}