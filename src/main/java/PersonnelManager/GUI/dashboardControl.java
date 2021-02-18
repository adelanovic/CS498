package PersonnelManager.GUI;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;


import java.awt.*;
import java.io.IOException;


public class dashboardControl {
    @FXML private AnchorPane mainDashboard;
    @FXML private TabPane tabPane;
    @FXML private Tab contactTab;
    @FXML private Tab leaveTab;
    @FXML private Tab scheduleTab;

    @FXML private void displayMainDash(ActiveEvent event) throws IOException {
       mainDashboard.setVisible(true);
    }
}
