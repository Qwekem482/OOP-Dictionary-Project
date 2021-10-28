package com.project.dictionary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import com.project.library.DictionaryManagement;

import java.io.IOException;
import java.sql.*;

public class DefaultOfApplication extends Application {

    @Override
    public void start(Stage stageDefault) throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader fxmlLoaderDefault = new FXMLLoader(DefaultOfApplication.class.getResource("DictionaryView.fxml"));
        Scene sceneDefault = new Scene(fxmlLoaderDefault.load(), 840, 610);
        stageDefault.setTitle("Simple Dictionary");
        stageDefault.setScene(sceneDefault);
        stageDefault.setResizable(false);
        stageDefault.show();
        Font.loadFont(DefaultOfApplication.class.getResourceAsStream("../../../../../data/freescript.ttf"), 82);
        DictionaryManagement.getConnect();
    }

    public static void main(String[] args) {

        launch();
    }
}