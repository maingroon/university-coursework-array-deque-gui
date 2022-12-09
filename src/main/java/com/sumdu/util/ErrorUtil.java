package com.sumdu.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class ErrorUtil {

    private ErrorUtil () {}

    private static Stage errorStage;

    public static void showError(String errorText) throws IOException {
        if (errorStage == null) {
            errorStage = new Stage();
            URL errorViewLocation = Objects.requireNonNull(ErrorUtil.class.getResource("/error-view.fxml"));
            Parent errorParent = FXMLLoader.load(errorViewLocation);
            Scene errorScene = new Scene(errorParent);

            errorStage.setTitle("ArrayDeque error");
            errorStage.setResizable(false);
            errorStage.setScene(errorScene);
        }

        Scene errorScene = errorStage.getScene();
        Label errorLabel = (Label) errorScene.lookup("#errorLabel");
        errorLabel.setText(errorText);
        errorStage.show();
    }
}
