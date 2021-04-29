package com.application;

import com.application.gui.regemployeeStage;
import com.application.gui.loginStage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.io.IOException;

/**
 * Defines how the initial stage is set up and what stages are loaded first. Currently takes you to the login panes.
 * Class: CS498 Capstone Project
 * Instructor: Professor Spetka, Scott
 * Date: 02/15/2021
 * Last Revision: 02/15/2021
 * @author Adis Delanovic
 *
 */

public class initialstageLogin extends Application
{

    @Override
    public void start(Stage primaryStage) throws IOException {

        loginStage logIn = new loginStage();

        try {

            FXMLLoader loadLogin = new FXMLLoader();
            loadLogin.setController(logIn);
            Parent root = FXMLLoader.load(getClass().getResource("/stages/login.fxml"));
            primaryStage.getIcons().add(new Image(initialstageLogin.class.getResourceAsStream("/images/af_icon.png")));
            primaryStage.setScene(new Scene(root, 919, 690));
            primaryStage.show();
            primaryStage.setMaxWidth(1000);
            primaryStage.setMaxHeight(1000);
            primaryStage.setResizable(false);

        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
