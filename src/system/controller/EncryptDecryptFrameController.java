package system.controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import system.Main;
import system.service.EncryptDecryptService;
import system.utils.FileUtil;
import system.utils.SimpleUtil;

import java.io.IOException;

public class EncryptDecryptFrameController {

    @FXML
    private Stage EnDeStage;

    public void setEnDeStage(Stage stage) {
        this.EnDeStage = stage;
    }

    @FXML
    private TextArea plaintext1;

    @FXML
    private TextArea ciphertext1;

    @FXML
    private TextField key1;

    @FXML
    private Button bt_start1;

    @FXML
    private TextArea ciphertext2;

    @FXML
    private TextArea plaintext2;

    @FXML
    private TextField key2;

    @FXML
    private Button bt_start2;

    @FXML
    private RadioButton encryptBT;

    @FXML
    private RadioButton decryptBT;

    @FXML
    private Text algorithmText;

    @FXML
    private FontAwesomeIconView exitButton;

    @FXML
    private Button kFile;

    @FXML
    private Button cFile;

    @FXML
    private Button pFile;

    @FXML
    private ComboBox<String> algorithmComboBox;

    private SimpleUtil simpleUtil = new SimpleUtil();


    @FXML
    private void initialize() throws Exception {
        ToggleGroup group = new ToggleGroup();
        encryptBT.setToggleGroup(group);
        decryptBT.setToggleGroup(group);
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
        algorithmObservableList.add("RSA");
        algorithmObservableList.add("DH");
        algorithmObservableList.add("DH2");

        algorithmComboBox.setItems(algorithmObservableList);

    }


    @FXML
    void algorithmEvent(ActionEvent event) throws Exception {
        String choice = this.algorithmComboBox.getSelectionModel().getSelectedItem();
        if (choice.equals("CA_1d")) {
            CA_1dFrameController controller = (CA_1dFrameController) Main.initCA_1dFrame();
            controller.setParentController(this);
        }
        if (choice.equals("RSA")) {
            new Main().initRASFrame();
        }
        if (choice.equals("DH")) {
            new Main().initDHFrame();
        }
        if (choice.equals("DH2")) {
            new Main().initDH2Frame();
        }
    }


    @FXML
    void bt_start1Event(ActionEvent event) {
        if (this.algorithmComboBox.getSelectionModel().getSelectedItem() == null) {
            this.simpleUtil.informationDialog(Alert.AlertType.ERROR, "提示", "警告", "请选择加密算法!");
        }
        EncryptDecryptService.isStart1(this.algorithmComboBox.getSelectionModel().getSelectedItem(), this.plaintext1, this.ciphertext1,
                this.key1, this.encryptBT, this.decryptBT);

    }

    @FXML
    void bt_start2Event(ActionEvent event) {
        if (this.algorithmComboBox.getSelectionModel().getSelectedItem() == null) {
            this.simpleUtil.informationDialog(Alert.AlertType.ERROR, "提示", "警告", "请选择加密算法!");
        }
        EncryptDecryptService.isStart1(this.algorithmComboBox.getSelectionModel().getSelectedItem(), this.plaintext2, this.ciphertext2,
                this.key2, this.encryptBT, this.decryptBT);
    }


    @FXML
    void cFileEvent(ActionEvent event) throws IOException {
        ciphertext2.setText(FileUtil.initFileChooser(EnDeStage));
    }

    @FXML
    void kFileEvent(ActionEvent event) throws IOException {
        key2.setText(FileUtil.initFileChooser(EnDeStage));
    }

    @FXML
    void pFileEvent() throws IOException {
        plaintext2.setText(FileUtil.initFileChooser(EnDeStage));
    }

    @FXML
    void close(MouseEvent event) {
        Stage stage = (Stage)exitButton.getScene().getWindow();
        stage.close();
    }

    public void setPlaintext1(String plaintext1) {
        this.plaintext1.setText(plaintext1);
    }

    public void setKey1(String key1) {
        this.key1.setText(key1);
    }

    public void setCiphertext1(String ciphertext1) {
        this.ciphertext1.setText(ciphertext1);
    }


}
