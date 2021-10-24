package com.project.dictionary;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.stage.Stage;

public class AboutController extends Application {

    @FXML
    public void Qwekem482() {
        getHostServices().showDocument("https://github.com/Qwekem482");
    }

    @FXML
    public void letthai() {
        getHostServices().showDocument("https://github.com/letthai");
    }
    @FXML
    public void Cambridge() {
        getHostServices().showDocument("https://dictionary.cambridge.org/vi/dictionary/english-vietnamese/");
    }
    @FXML
    public void SoundofText() {
        getHostServices().showDocument("https://soundoftext.com/");
    }
    @FXML
    public void freepik() {
        getHostServices().showDocument("https://www.freepik.com/free-vector/classic-border-set_4948926.htm#page=1&query=frame&position=4&from_view=keyword");
    }

    @Override
    public void start(Stage stage) throws Exception {
    }
}
