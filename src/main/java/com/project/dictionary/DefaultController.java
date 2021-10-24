package com.project.dictionary;

import com.project.library.DictionaryManagement;
import com.project.library.Word;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.TreeMap;

public class DefaultController {

    @FXML
    public void fileToAdd(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DefaultOfApplication.class.getResource("AddNewWordView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        Stage stage = new Stage();
        stage.setTitle("Thêm từ mới");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void fileToDelete(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DefaultOfApplication.class.getResource("DeleteWordView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 355, 204);
        Stage stage = new Stage();
        stage.setTitle("Xóa từ");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void ReWriteWord(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DefaultOfApplication.class.getResource("ModifyEngView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 355, 204);
        Stage stage = new Stage();
        stage.setTitle("Sửa từ");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void RewriteMeaning(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DefaultOfApplication.class.getResource("ModifyVietView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 355, 204);
        Stage stage = new Stage();
        stage.setTitle("Sửa nghĩa từ");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void about(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DefaultOfApplication.class.getResource("DeleteWordView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 355, 204);
        Stage stage = new Stage();
        stage.setTitle("Tác giả");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private TextArea engList;

    @FXML
    public void defaultWordList() {
        ipaSound.setVisible(false);
        engList.clear();
        int i = 1;
        engList.setEditable(false);
        ArrayList<String> englishList = new ArrayList<String>();
        englishList = DictionaryManagement.showEngList();
        engList.setText(i + "." + "\t" + englishList.get(0));
        i++;
        for (int j = 1; j < englishList.size(); j++) {
            engList.appendText("\n" + i + "." + "\t" + englishList.get(j));
            i++;
        }
    }


    @FXML
    private TextArea engResult;
    @FXML
    private TextArea vieResult;
    @FXML
    private TextArea ipaResult;
    @FXML
    private TextArea grammarResult;
    @FXML
    private TextArea confirmation;
    @FXML
    private Button ipaSound;

    @FXML
    private TextField searchWord;

    @FXML
    public void enterToSearch() {
        int i = 1;
        engResult.clear();
        vieResult.clear();
        ipaResult.clear();
        grammarResult.clear();
        confirmation.clear();
        engResult.setEditable(false);
        vieResult.setEditable(false);
        ipaResult.setEditable(false);
        grammarResult.setEditable(false);
        confirmation.setEditable(false);
        if (searchWord.getText().equals("")) {
            defaultWordList();
            return;
        }
        TreeMap<String, Word> allSearchWords = DictionaryManagement.search(searchWord.getText());
        if (allSearchWords.size() > 1 || !allSearchWords.firstKey().equals(searchWord.getText())) {
            engList.clear();
            ipaSound.setVisible(false);
            for (String key : allSearchWords.keySet()) {
                engList.appendText(i + "." + "\t" + key + "\n");
                i++;
            }
            return;
        }
        if (allSearchWords.size() == 1 && allSearchWords.firstKey().equals(searchWord.getText())) {
            Word forDisplay = allSearchWords.get(searchWord.getText().toLowerCase());
            engResult.appendText(forDisplay.getWord_target().toUpperCase());
            vieResult.appendText("Nghĩa: " + forDisplay.getWord_explain());
            ipaResult.appendText("IPA: " + forDisplay.getIpa());
            grammarResult.appendText("Phân loại: " + forDisplay.getGrammar());
            ipaSound.setVisible(true);
            if (forDisplay.isDevCreateWord()) {
                confirmation.appendText("Từ này được xác nhận bởi tác giả");
            } else {
                confirmation.appendText("Từ này KHÔNG được xác nhận bởi tác giả");
            }
        }
    }

    @FXML
    private void sound() {
        String fileName = searchWord.getText().toLowerCase();
        Path currentDir = Path.of(System.getProperty("user.dir"));
        Path dataDir = currentDir.resolve("data//sounds//" + fileName + ".mp3");
        File dataFile = new File(String.valueOf(dataDir));
        Media sound = new Media(dataFile.toURI().toString());
        MediaPlayer player = new MediaPlayer(sound);
        player.play();
    }
}