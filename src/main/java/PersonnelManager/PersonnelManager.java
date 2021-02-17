package PersonnelManager;

import PersonnelManager.GUI.dashboardControl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class PersonnelManager extends Application
{

    @Override
    public void start(Stage primaryStage) throws IOException {

        dashboardControl dash = new dashboardControl();
        FXMLLoader load_login = new FXMLLoader();
        Parent root = FXMLLoader.load(getClass().getResource("/views/login_page.fxml"));
        primaryStage.setScene(new Scene(root, 443, 443));
        primaryStage.setMaxWidth(443.0);
        primaryStage.setMaxHeight(598);
        primaryStage.show();

        /*
        primaryStage.setTitle("Personnel Manager");

        Button connect_btn = new Button();
        connect_btn.setMaxSize(80,20);
        connect_btn.setText("Connect");
        connect_btn.setStyle("-fx-border-width: 3; -fx-text-fill: black; " +
                "-fx-font-size: 15; -fx-base: rgb(211, 174, 20); -fx-font-family: 'Agency FB'");

        Button exit_btn = new Button();
        exit_btn.setMaxSize(80,20);
        exit_btn.setText("Exit");
        exit_btn.setStyle("-fx-border-width: 3; -fx-text-fill: black; " +
                "-fx-font-size: 15; -fx-base: rgb(211, 174, 20); -fx-font-family: 'Agency FB'");

        //User name label and text field
        TextField user_name = new TextField(null);
        user_name.setMaxSize(150,40);
        user_name.setMinSize(150,40);
        Label username_label = new Label("Username ", user_name);
        username_label.setStyle("-fx-font-family: 'Agency FB'; -fx-font-size: 20");
        username_label.setContentDisplay(ContentDisplay.TOP);

        //Password label and text field
        PasswordField password = new PasswordField();
        password.setMaxSize(150,40);
        password.setMinSize(150,40);
        Label password_lbl = new Label("Password", user_name);
        password_lbl.setStyle("-fx-font-family: 'Agency FB'; -fx-font-size: 20");
        password_lbl.setContentDisplay(ContentDisplay.TOP);

        VBox root = new VBox(15);
        root.setStyle("-fx-border-color: black; -fx-border-width: 3; -fx-base: rgb(211, 174, 20)");
        root.setAlignment(Pos.CENTER);

        //Add items to vertical box
        root.getChildren().addAll(user_name, username_label, password_lbl, password, connect_btn, exit_btn);
        primaryStage.setScene(new Scene(root, 300, 350));
        primaryStage.setMaxHeight(350);
        primaryStage.setMaxWidth(300);
        primaryStage.show();

        //Lamba Functions for buttons
        connect_btn.setOnMouseClicked(e ->
        {
            MongoDriver mongo_driver = new MongoDriver();
            mongo_driver.set_password(password.getText());
            mongo_driver.set_username(user_name.getText());
            mongo_driver.connect_database();
        });

        exit_btn.setOnMouseClicked(e ->
        {
            System.out.println("Program Exiting");
            System.exit(0);
        });

        password.setOnKeyPressed((event) -> {
            if(event.getCode() == KeyCode.ENTER)
            {
                MongoDriver mongo_driver = new MongoDriver();
                mongo_driver.connect_database();
            }
        });

         */

    }
}
