package com.project.dictionary;

import com.project.library.DictionaryManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class DeleteWordController {
    @FXML
    private TextField WordNeedDelete;

    @FXML
    public void Cancel(ActionEvent event) {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void Confirm(ActionEvent event) throws FileNotFoundException{
        String Notification = DictionaryManagement.DeleteWord(WordNeedDelete.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(Notification);
        alert.show();
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
