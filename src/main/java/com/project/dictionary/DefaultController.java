package com.project.dictionary;

import com.project.library.DictionaryManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

public class DefaultController {

    @FXML
    public void fileToAdd(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DefaultOfApplication.class.getResource("AddNewWordView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 210);
        Stage stage = new Stage();
        stage.setTitle("Add New Word");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    public void fileToDelete(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DefaultOfApplication.class.getResource("DeleteWordView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 210);
        Stage stage = new Stage();
        stage.setTitle("Delete Word");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    private TextArea engList;

    @FXML
    public void defaultWordList() {
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
    private TextArea engSearchList;

    @FXML
    private TextArea vieSearchList;

    @FXML
    private TextField searchWord;

    @FXML
    public void enterToSearch() {
        int i = 1;
        engSearchList.clear();
        vieSearchList.clear();
        engSearchList.setEditable(false);
        vieSearchList.setEditable(false);
        TreeMap<String, String> allSearchWords = DictionaryManagement.search(searchWord.getText());
        for (String key : allSearchWords.keySet()) {
            engSearchList.appendText(i + "." + "\t" + key + "\n");
            vieSearchList.appendText(i + "." + "\t" + allSearchWords.get(key) + "\n");
            i++;
        }
    }
}