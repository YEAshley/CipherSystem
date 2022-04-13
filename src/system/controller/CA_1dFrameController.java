package system.controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import system.service.EncryptDecryptService;

public class CA_1dFrameController {

    private EncryptDecryptFrameController parentController;

    @FXML
    private Stage caStage;

    public Stage getCaStage() {
        return caStage;
    }

    public void setCaStage(Stage stage) {
        this.caStage = stage;
    }

    @FXML
    private TextField length;

    @FXML
    private TextField initialization;

    @FXML
    private TextField rule;

    @FXML
    private TextField random;

    @FXML
    private TextField plaintext;

    @FXML
    private Button okBT;

    @FXML
    private FontAwesomeIconView exitButton;

    @FXML
    void bt_okEvent(ActionEvent event) {
        this.caStage.close();
        this.parentController.setPlaintext1(plaintext.getText());
        this.parentController.setCiphertext1(EncryptDecryptService.CA_1dEncrypt(length, initialization, rule, random, plaintext));
        this.parentController.setKey1(EncryptDecryptService.getCA_key());
    }

    public void setParentController(EncryptDecryptFrameController controller) {
        parentController = controller;
    }

    @FXML
    void close(MouseEvent event) {
        Stage stage = (Stage)exitButton.getScene().getWindow();
        stage.close();
    }

}
