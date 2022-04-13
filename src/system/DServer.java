package system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import system.controller.DServerFrameController;

import java.io.IOException;

public class DServer extends Application {
    private Stage stage;
    private static double yOffSet;
    private static double xOffSet;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.stage = primaryStage;
        initDServerFrame();
    }

    public void initDServerFrame() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/d_ServerFrame.fxml"));
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);
        stage.setTitle("½âÃÜ¶Ë");
        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffSet);
            stage.setY(event.getScreenY() - yOffSet);
        });
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.setResizable(false);
        DServerFrameController controller = loader.getController();
        controller.setServerStage(stage);
        stage.show();
    }

}
