package com.project.dictionary;

import com.project.library.DictionaryManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class AddNewWordController {

    @FXML
    private TextField englishInput;
    @FXML
    private TextField vietnameseInput;

    @FXML
    public void confirmAction(ActionEvent event) throws FileNotFoundException {
        DictionaryManagement.insertFromApp(englishInput.getText(), vietnameseInput.getText());
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void cancelAction(ActionEvent event) {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
