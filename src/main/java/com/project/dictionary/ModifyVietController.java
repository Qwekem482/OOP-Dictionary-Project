package com.project.dictionary;

import com.project.library.DictionaryManagement;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class ModifyVietController {
    @FXML
    private TextField WordChange;
    @FXML
    private TextField ChangeInto;

    @FXML
    public void Cancel(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void Confirm(ActionEvent event) throws FileNotFoundException {

    }
}
