package system.controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import system.service.EncryptDecryptService;
import system.socket.SocketServerMainThread;
import system.utils.SimpleUtil;

import java.io.IOException;
import java.net.ServerSocket;

public class DServerFrameController {
    ServerSocket serverSocket = null;
    SocketServerMainThread ssmt = null;

    @FXML
    private FontAwesomeIconView exitButton;
    @FXML
    void close(MouseEvent event) {
        Stage stage = (Stage)exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Stage serverStage;

    public void setServerStage(Stage stage) {
        this.serverStage = stage;
    }

    @FXML
    private Button bt_startConnect;

    @FXML
    public Text algorithm;


    @FXML
    public TextArea dCiphertext;


    @FXML
    public TextField dKey;


    @FXML
    private TextArea dPlaintext;

    @FXML
    private Button bt_decrypt;

    @FXML
    private Button bt_refresh;


    SimpleUtil simpleUtil = new SimpleUtil();
//    Server server = new Server();

    public DServerFrameController() throws IOException {

    }


    @FXML
    void bt_decryptEvent(ActionEvent event) {
        if (!simpleUtil.isEmpty(dCiphertext.getText())) {
            if (!simpleUtil.isEmpty(dKey.getText())) {
                dPlaintext.setText(EncryptDecryptService.DecryptService(algorithm.getText(), dCiphertext.getText(), dKey.getText()));
            } else
                simpleUtil.informationDialog(Alert.AlertType.WARNING, "提示", "警告", "密钥不能为空！");
        } else
            simpleUtil.informationDialog(Alert.AlertType.WARNING, "提示", "警告", "密文不能为空！");

    }


    @FXML
    void bt_refreshEvent(ActionEvent event) throws IOException {
    }


    @FXML
    void bt_stopEvent(ActionEvent event) throws IOException {
          if(ssmt!=null){
              ssmt.setThreadStop(true);
          }
    }
    @FXML
    void bt_startConnectEvent(ActionEvent event) throws IOException {
        if (serverSocket == null)
            serverSocket = new ServerSocket(12345);

        //启动线程开始侦听客户端连接
        ssmt = new SocketServerMainThread();
        ssmt.setServerSocket(serverSocket);
        ssmt.setAlgorithm(algorithm);
        ssmt.setCiphertext(dCiphertext);
        ssmt.setKey(dKey);
        new Thread(ssmt).start();
    }
}

