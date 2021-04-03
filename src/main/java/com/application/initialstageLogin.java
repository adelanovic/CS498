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

        loginStage logger = new loginStage();
        regemployeeStage dash = new regemployeeStage();
        //Platform.setImplicitExit(false);

        try {

            FXMLLoader load_login = new FXMLLoader();
            load_login.setController(logger);
            Parent root = FXMLLoader.load(getClass().getResource("/stages/login.fxml"));
            primaryStage.getIcons().add(new Image(initialstageLogin.class.getResourceAsStream("/images/af_icon.png")));
            primaryStage.setScene(new Scene(root, 478, 503));
            primaryStage.show();
            primaryStage.setMaxWidth(478);
            primaryStage.setMaxHeight(503);
            primaryStage.setResizable(false);
            //primaryStage.close();

/*
            Stage secondaryStage = new Stage();
            FXMLLoader loadMainDash = new FXMLLoader();
            loadMainDash.setController(dash);
            Parent rootDash = FXMLLoader.load(getClass().getResource("/views/regularEmployee.fxml"));
            secondaryStage.getIcons().add(new Image(PersonnelManager.class.getResourceAsStream("/images/af_icon.png")));
            secondaryStage.setScene(new Scene(rootDash, 800, 600));
            secondaryStage.setResizable(false);
            secondaryStage.show();
*/

        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
