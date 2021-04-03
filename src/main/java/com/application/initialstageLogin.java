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
            primaryStage.setScene(new Scene(root, 478, 503));
            primaryStage.show();
            primaryStage.setMaxWidth(1000);
            primaryStage.setMaxHeight(1000);
            primaryStage.setResizable(true);

        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
