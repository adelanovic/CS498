package PersonnelManager;

import PersonnelManager.GUI.loginControl;
import javafx.application.Application;
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

        try {

            FXMLLoader load_login = new FXMLLoader();
            load_login.setController(logger);
            Parent root = FXMLLoader.load(getClass().getResource("/views/login_page.fxml"));
            primaryStage.getIcons().add(new Image(PersonnelManager.class.getResourceAsStream("/images/af_icon.png")));
            primaryStage.setScene(new Scene(root, 478, 500));
            primaryStage.show();
            primaryStage.setMaxWidth(478);
            primaryStage.setMaxHeight(500);
            primaryStage.setResizable(false);

        }catch(Exception e){
            e.printStackTrace();
        }





    }
}
