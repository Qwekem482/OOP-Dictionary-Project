package com.project.dictionary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DefaultOfApplication extends Application {
    @Override
    public void start(Stage stageDefault) throws IOException {
        FXMLLoader fxmlLoaderDefault = new FXMLLoader(DefaultOfApplication.class.getResource("DictionaryView.fxml"));
        Scene sceneDefault = new Scene(fxmlLoaderDefault.load(), 840, 610);
        stageDefault.setTitle("Dictionary");
        stageDefault.setScene(sceneDefault);
        stageDefault.show();
    }

    public static void main(String[] args) {
        launch();
    }
}