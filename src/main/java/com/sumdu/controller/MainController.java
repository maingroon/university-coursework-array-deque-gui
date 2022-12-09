package com.sumdu.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class MainController {

    private Stage aboutTeamStage;
    private Stage arraySizeStage;

    @FXML
    private void onAboutButtonClick() throws IOException {
        if (aboutTeamStage == null) {
            URL aboutTeamViewLocation = Objects.requireNonNull(getClass().getResource("/about-team-view.fxml"));
            Parent aboutTeamParent = FXMLLoader.load(aboutTeamViewLocation);
            Scene aboutTeamScene = new Scene(aboutTeamParent);

            aboutTeamStage = new Stage();
            aboutTeamStage.setScene(aboutTeamScene);
            aboutTeamStage.setResizable(false);
            aboutTeamStage.setTitle("About team 17 - ARRAY DEQUE");
            aboutTeamStage.show();
        }
        aboutTeamStage.show();
    }

    @FXML
    private void onArraySizeButtonClick() throws IOException {
        if (arraySizeStage == null) {
            URL arraySizeViewLocation = Objects.requireNonNull(getClass().getResource("/array-size-view.fxml"));
            Parent arraySizeParent = FXMLLoader.load(arraySizeViewLocation);
            Scene arraySizeScene = new Scene(arraySizeParent);

            arraySizeStage = new Stage();
            arraySizeStage.setScene(arraySizeScene);
            arraySizeStage.setResizable(false);
            arraySizeStage.setTitle("ARRAY DEQUE");
            arraySizeStage.show();
        }

        Scene arraySizeScene = arraySizeStage.getScene();
        Label arraySizeLabel = (Label) arraySizeScene.lookup("#arraySizeLabel");
        arraySizeLabel.setText("ArrayDeque size: " + 10);
        arraySizeStage.show();
    }
}