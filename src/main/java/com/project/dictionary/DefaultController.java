package com.project.dictionary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

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
}