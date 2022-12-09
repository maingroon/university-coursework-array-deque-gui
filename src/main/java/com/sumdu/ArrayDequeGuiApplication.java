package com.sumdu;

import com.sumdu.util.ErrorUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class ArrayDequeGuiApplication extends Application {

    @Override
    public void start(Stage mainStage) throws IOException {
        try {
            URL mainViewLocation = Objects.requireNonNull(getClass().getResource("/main-view.fxml"));
            Parent mainParent = FXMLLoader.load(mainViewLocation);
            Scene mainScene = new Scene(mainParent);

            mainStage.setTitle("ARRAY DEQUE");
            mainStage.setResizable(false);
            mainStage.setScene(mainScene);
            mainStage.show();
        } catch (Exception e) {
            ErrorUtil.showError(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}