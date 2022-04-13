package system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import system.controller.EClientFrameController;

import java.io.IOException;

public class EClient extends Application {
    private Stage stage;
    private static double yOffSet;
    private static double xOffSet;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
          this.stage = primaryStage;
          initEClientFrame();
    }

    public void initEClientFrame() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/e_ClientFrame.fxml"));
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);
        stage.setTitle("¼ÓÃÜ¶Ë");
        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffSet);
            stage.setY(event.getScreenY() - yOffSet);
        });
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.setResizable(false);
        EClientFrameController controller = loader.getController();
        controller.setClientStage(stage);
        stage.show();
    }
}
