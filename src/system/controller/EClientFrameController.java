package system.controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import system.service.EncryptDecryptService;
import system.utils.FileUtil;
import system.utils.SimpleUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class EClientFrameController {
    private DServerFrameController parentController;
    @FXML
    private FontAwesomeIconView exitButton;
    @FXML
    void close(MouseEvent event) {
        Stage stage = (Stage)exitButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    private Stage clientStage;

    public void setClientStage(Stage stage) {
        this.clientStage = stage;
    }

    @FXML
    private ComboBox<String> algorithmComboBox;

    @FXML
    private TextField ip;

    @FXML
    private Button bt_connect;

    @FXML
    private TextArea ePlaintext;

    @FXML
    private Button bt_pFile1;

    @FXML
    private Button bt_pFile2;

    @FXML
    private TextField eKey;

    @FXML
    private TextArea eCiphertext;

    @FXML
    private Button bt_encrypt;

    private Button nullBT;

    @FXML
    private Button send;

    private SimpleUtil simpleUtil = new SimpleUtil();

    public void setParentController(DServerFrameController controller) {
        parentController = controller;
    }

    @FXML
    private void initialize() {
        ObservableList<String> algorithmObservableList = FXCollections.observableArrayList();
        algorithmObservableList.add("Caesar");
        algorithmObservableList.add("Keyword");
        algorithmObservableList.add("Multiliteral");
        algorithmObservableList.add("Vigenere");
        algorithmObservableList.add("Autokey ciphertext");
        algorithmObservableList.add("Autokey plaintext");
        algorithmObservableList.add("Playfair");
        algorithmObservableList.add("Permutation");
        algorithmObservableList.add("Column permutation");
        algorithmObservableList.add("RC4");
        algorithmObservableList.add("CA_1d");
        algorithmObservableList.add("DES");
        algorithmComboBox.setItems(algorithmObservableList);
    }


    @FXML
    void bt_encryptEvent(ActionEvent event) {
        encryption();
    }

    private void encryption() {
        String choice = this.algorithmComboBox.getSelectionModel().getSelectedItem();
        if (choice != null) {
            if (!simpleUtil.isEmpty(ePlaintext.getText())) {
                if (!simpleUtil.isEmpty(eKey.getText())) {
                    eCiphertext.setText(EncryptDecryptService.EncryptService(choice, ePlaintext.getText(), eKey.getText()));
                } else
                    simpleUtil.informationDialog(Alert.AlertType.ERROR, "提示", "警告", "密钥不能为空！");
            } else
                simpleUtil.informationDialog(Alert.AlertType.ERROR, "提示", "警告", "明文不能为空！");
        } else
            this.simpleUtil.informationDialog(Alert.AlertType.ERROR, "提示", "警告", "请选择加密算法!");
    }


    @FXML
    void bt_pFile1Event(ActionEvent event) throws IOException {
        ePlaintext.setText(FileUtil.initFileChooser(clientStage));
    }

    @FXML
    void bt_pFile2Event(ActionEvent event) throws IOException {
        eKey.setText(FileUtil.initFileChooser(clientStage));
    }


    private Socket client = null;
    private DataOutputStream out = null;
    private DataInputStream in = null;

    @FXML
    void bt_connectEvent(ActionEvent event) throws IOException {
        //Client.ClientTalk(ip);

        String[] ipStr = ip.getText().split("\\.");
        byte ipAddressTemp[] = new byte[4];
        for (int i = 0; i < 4; i++) {
            ipAddressTemp[i] = (byte) (Integer.parseInt(ipStr[i]) & 0xff);
        }
        InetAddress ipAddress = InetAddress.getByAddress(ipAddressTemp);

        //首先直接创建socket,端口号1~1023为系统保存，一般设在1023之外
        client = new Socket(ipAddress, 12345);
        out = new DataOutputStream(client.getOutputStream());
        in = new DataInputStream(client.getInputStream());
    }

    @FXML
    void bt_stopEvent(ActionEvent event) {
        //向服务器发送断开连接字符
        try {
            out.writeUTF("DISCONNECT");
            out.close();
            in.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void sendEvent(ActionEvent event) throws IOException {

        out.writeUTF(this.algorithmComboBox.getSelectionModel().getSelectedItem());
        out.writeUTF(this.eCiphertext.getText());
        out.writeUTF(this.eKey.getText());
    }

}
