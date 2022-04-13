package system.controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import system.cipher.RSA.RSA;
import system.cipher.RSA.RSASimple;

import java.io.IOException;

public class RSAFrameController {
    @FXML
    private FontAwesomeIconView exitButton;
    @FXML
    void close(
            MouseEvent event) {
        Stage stage = (Stage)exitButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    private Stage RSAStage;

    public void setRSAStage(Stage stage) {
        this.RSAStage = stage;
    }

    @FXML
    private Text text1;

    @FXML
    private TextArea textArea1;

    @FXML
    private Text text2;

    @FXML
    private TextArea textArea2;

    @FXML
    private Text text3;

    @FXML
    private TextArea textArea3;

    @FXML
    private TextField p;

    @FXML
    private TextField q;

    @FXML
    private TextField d;

    @FXML
    private TextArea plaintext;

    @FXML
    private TextArea encryption;

    @FXML
    private Button bt_encrypt;

    @FXML
    private TextArea decryption;

    @FXML
    private Button bt_decrypt;

    @FXML
    private Button bt_back;

    @FXML
    private ComboBox<String> RSAChoice;


    @FXML
    private void initialize() {
        ObservableList<String> choiceObservableList = FXCollections.observableArrayList();
        choiceObservableList.add("公钥加密私钥解密过程");
        choiceObservableList.add("私钥加密公钥解密过程");
        choiceObservableList.add("私钥签名过程");
        choiceObservableList.add("公钥校验签名");
        RSAChoice.setItems(choiceObservableList);

        /*随机生成大素数p，q，g*/
        p.setText(String.valueOf(RSASimple.safePGen()));
        q.setText(String.valueOf(RSASimple.getQ()));
        d.setText(String.valueOf(RSASimple.getD()));
    }


    @FXML
    void RSAChoiceEvent(ActionEvent event) {
        String choice = this.RSAChoice.getSelectionModel().getSelectedItem();
        if (choice.equals("私钥签名过程")) {
            text1.setText("签名原串");
            text2.setText("签名结果");
            text3.setVisible(false);
            textArea3.setVisible(false);

        } else if (choice.equals("公钥校验签名")) {
            text3.setVisible(true);
            textArea3.setVisible(true);
            text1.setText("签名原串");
            text2.setText("签名结果");
            text3.setText("验签结果");
        } else {
            text3.setVisible(true);
            textArea3.setVisible(true);
        }
    }

    @FXML
    void bt_startEvent(ActionEvent event) throws Exception {
        String choice = this.RSAChoice.getSelectionModel().getSelectedItem();
        switch (choice) {
            case "公钥加密私钥解密过程":
                textArea2.setText(RSA.getCiphertext1(textArea1.getText()));
                textArea3.setText(RSA.getPlaintext1(RSA.getCiphertext1(textArea1.getText())));
                break;
            case "私钥加密公钥解密过程":
                textArea2.setText(RSA.getCiphertext2(textArea1.getText()));
                textArea3.setText(RSA.getPlaintext2(RSA.getCiphertext2(textArea1.getText())));
            case "私钥签名过程":
                textArea2.setText(RSA.getSignStr(textArea1.getText()));
            case "公钥校验签名":
                textArea2.setText(RSA.getSignStr(textArea1.getText()));
                textArea3.setText(RSA.getSignStr(textArea1.getText()));
        }
    }


    @FXML
    void bt_backEvent(ActionEvent event) {
           RSAStage.close();
    }

    @FXML
    void bt_decryptEvent(ActionEvent event) throws IOException {
        decryption.setText(RSASimple.getPString(p.getText(), q.getText(), d.getText(), plaintext.getText()));
    }

    @FXML
    void bt_encryptEvent(ActionEvent event) throws IOException {
        encryption.setText(RSASimple.getCString(p.getText(), q.getText(), d.getText(), plaintext.getText()));
    }


}
