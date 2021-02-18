package PersonnelManager;

import PersonnelManager.GUI.dashboardControl;
import PersonnelManager.GUI.loginControl;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.io.IOException;


public class PersonnelManager extends Application
{

    @Override
    public void start(Stage primaryStage) throws IOException {

        loginControl logger = new loginControl();
        dashboardControl dash = new dashboardControl();
        //Platform.setImplicitExit(false);

        try {

            FXMLLoader load_login = new FXMLLoader();
            load_login.setController(logger);
            Parent root = FXMLLoader.load(getClass().getResource("/views/login_page.fxml"));
            primaryStage.getIcons().add(new Image(PersonnelManager.class.getResourceAsStream("/images/af_icon.png")));
            primaryStage.setScene(new Scene(root, 478, 503));
            primaryStage.show();
            primaryStage.setMaxWidth(478);
            primaryStage.setMaxHeight(503);
            primaryStage.setResizable(false);
            //primaryStage.close();


            Stage secondaryStage = new Stage();
            FXMLLoader loadMainDash = new FXMLLoader();
            loadMainDash.setController(dash);
            Parent rootDash = FXMLLoader.load(getClass().getResource("/views/dashboard.fxml"));
            secondaryStage.getIcons().add(new Image(PersonnelManager.class.getResourceAsStream("/images/af_icon.png")));
            secondaryStage.setScene(new Scene(rootDash, 800, 600));
            secondaryStage.setResizable(false);
            secondaryStage.show();


        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
