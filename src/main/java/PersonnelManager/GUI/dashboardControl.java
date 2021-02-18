package PersonnelManager.GUI;

import javafx.event.Event;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;


public class dashboardControl {
   @FXML public AnchorPane loginPane;

   private void displayLogin(Event e){
       loginPane.setVisible(true);
   }
}
