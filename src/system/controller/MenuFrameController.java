package system.controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import system.Main;

import java.io.IOException;

public class MenuFrameController {

    @FXML
    private Stage primaryStage;

    public void setPrimaryStage(Stage stage){
        this.primaryStage = stage;
    }

    @FXML
    private FontAwesomeIconView exitButton;

    @FXML
    private Button bt_Single;

    @FXML
    private Button bt_enClient;

    @FXML
    private Button bt_deServer;

    @FXML
    void bt_SingleEvent(ActionEvent event) throws IOException {
           primaryStage.close();
           new Main().initEnDeFrame();
    }

    @FXML
    void bt_deServerEvent(ActionEvent event) throws IOException {
           primaryStage.close();
          new Main().initDServerFrame();
    }

    @FXML
    void bt_enClientEvent(ActionEvent event) throws IOException {
            primaryStage.close();
           new Main().initEClientFrame();
    }

    @FXML
    void close(MouseEvent event) {
        Stage stage = (Stage)exitButton.getScene().getWindow();
        stage.close();
    }

}
