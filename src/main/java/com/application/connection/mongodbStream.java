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

    public void connect_database()
    {
        //Sets a level to the JULLogger, lots of visible text in red on console.
        java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);

        try
        {
            //Create a connection string
            ConnectionString conn_string = new ConnectionString(
                    "mongodb+srv://" +this.get_username() + ":" + this.get_password() +
                            "@employees.8i0hk.mongodb.net/Employees?retryWrites=true&w=majority");


            //Set the settings for the connection
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(conn_string)
                    .retryWrites(true)
                    .build();

            //Create the connection
            mongo_client = MongoClients.create(settings);

            try
            {
                //Access particular database
                database = mongo_client.getDatabase("Employees");
                MongoCollection<Document> collection = database.getCollection("Employees");
                //Retrieving the documents
                FindIterable<Document> iterDoc = collection.find();
                Iterator it = iterDoc.iterator();
                while (it.hasNext()) {
                    System.out.println(it.next());
                }
            }
            catch(IllegalArgumentException e)
            {
                System.out.println("Not a proper Database!");
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
    public void set_password(String password)
    {
        this.password = password;
    }

    public void set_dbname(String db_name)
    {
        this.db_name = db_name;
    }

    public void set_username(String username)
    {
        this.username = username;
    }

    public String get_dbname()
    {
        return this.db_name;
    }

    public String get_password()
    {
        return this.password;
    }

    public String get_username()
    {
        return this.username;
    }
}