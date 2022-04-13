package system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import system.controller.*;

import java.io.IOException;

public class Main extends Application {
    private Stage primaryStage;
    private static double yOffSet;
    private static double xOffSet;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        initMenuFrame();
    }


    public static void main(String[] args) {
        launch(args);
    }

    /*CA_1d*/

    public void initMenuFrame() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/MenuFrame.fxml"));
        AnchorPane root = loader.load();

        primaryStage.setTitle("加解密系统");
        root.setOnMousePressed(event -> {
            xOffSet = event.getSceneX();
            yOffSet = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffSet);
            primaryStage.setY(event.getScreenY() - yOffSet);
        });
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        MenuFrameController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);
        primaryStage.show();
    }

    public void initEnDeFrame() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/EncryptDecryptFrame.fxml"));
        GridPane root = loader.load();
        Stage EnDeStage = new Stage();
        EnDeStage.setTitle("单机加解密系统");
        root.setOnMousePressed(event -> {
            xOffSet = event.getSceneX();
            yOffSet = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            EnDeStage.setX(event.getScreenX() - xOffSet);
            EnDeStage.setY(event.getScreenY() - yOffSet);
        });
        EnDeStage.initStyle(StageStyle.UNDECORATED);
        EnDeStage.setScene(new Scene(root));
        EnDeStage.setResizable(false);
        EnDeStage.getIcons().add(new Image("system\\view\\images\\logo.png"));
        EncryptDecryptFrameController controller = loader.getController();
        controller.setEnDeStage(EnDeStage);
        EnDeStage.show();
    }

    public static Object initCA_1dFrame() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/CA_1dFrame.fxml"));
        AnchorPane root = loader.load();
        Stage caStage = new Stage();
        Scene scene = new Scene(root);
        caStage.setTitle("一维CA加密");
        root.setOnMousePressed(event -> {
            xOffSet = event.getSceneX();
            yOffSet = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            caStage.setX(event.getScreenX() - xOffSet);
            caStage.setY(event.getScreenY() - yOffSet);
        });
        caStage.initStyle(StageStyle.UNDECORATED);
        caStage.setScene(scene);
        caStage.setResizable(false);
        caStage.getIcons().add(new Image("system\\view\\images\\lock.png"));
        CA_1dFrameController controller = loader.getController();
        controller.setCaStage(caStage);
        caStage.show();
        return loader.getController();
    }

    public void initDHFrame() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/DHFrame.fxml"));
        AnchorPane root = loader.load();
        Stage DHStage = new Stage();
        Scene scene = new Scene(root);
        DHStage.setTitle("DH密钥交换过程实现");
        root.setOnMousePressed(event -> {
            xOffSet = event.getSceneX();
            yOffSet = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            DHStage.setX(event.getScreenX() - xOffSet);
            DHStage.setY(event.getScreenY() - yOffSet);
        });
        DHStage.initStyle(StageStyle.UNDECORATED);
        DHStage.setScene(scene);
        DHStage.setResizable(false);
        DHFrameController controller = loader.getController();
        controller.setDHStage(DHStage);
        DHStage.show();
    }

    public void initDH2Frame() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/DH2Frame.fxml"));
        AnchorPane root = loader.load();
        Stage DH2Stage = new Stage();
        Scene scene = new Scene(root);
        DH2Stage.setTitle("DH密钥交换过程实现2");
        root.setOnMousePressed(event -> {
            xOffSet = event.getSceneX();
            yOffSet = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            DH2Stage.setX(event.getScreenX() - xOffSet);
            DH2Stage.setY(event.getScreenY() - yOffSet);
        });
        DH2Stage.initStyle(StageStyle.UNDECORATED);
        DH2Stage.setScene(scene);
        DH2Stage.setResizable(false);
        DH2FrameController controller = loader.getController();
        controller.setDH2Stage(DH2Stage);
        DH2Stage.show();
    }

    public void initRASFrame() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/RSAFrame.fxml"));
        AnchorPane root = loader.load();
        Stage RSAStage = new Stage();
        Scene scene = new Scene(root);
        RSAStage.setTitle("RSA实现展示");
        root.setOnMousePressed(event -> {
            xOffSet = event.getSceneX();
            yOffSet = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            RSAStage.setX(event.getScreenX() - xOffSet);
            RSAStage.setY(event.getScreenY() - yOffSet);
        });
        RSAStage.initStyle(StageStyle.UNDECORATED);
        RSAStage.setScene(scene);
        RSAStage.setResizable(false);
        RSAFrameController controller = loader.getController();
        controller.setRSAStage(RSAStage);
        RSAStage.show();
    }

    public void initEClientFrame() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/e_ClientFrame.fxml"));
        AnchorPane root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("加密端");
        root.setOnMousePressed(event -> {
            xOffSet = event.getSceneX();
            yOffSet = event.getSceneY();
        });
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


    public void initDServerFrame() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/d_ServerFrame.fxml"));
        AnchorPane root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("解密端");
        stage.setScene(scene);
        stage.setResizable(false);
        DServerFrameController controller = loader.getController();
        controller.setServerStage(stage);
        stage.show();
    }


}
