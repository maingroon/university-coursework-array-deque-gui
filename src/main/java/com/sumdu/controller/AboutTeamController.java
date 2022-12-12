package com.sumdu.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Objects;

public class AboutTeamController {

    @FXML
    private Label performersLabel;

    @FXML
    private Label aboutProgramLabel;

    public void setPerformersText(String performersText) {
        Objects.requireNonNull(performersText);
        performersLabel.setText(performersText);
    }

    public void setAboutProgramText(String aboutProgramText) {
        Objects.requireNonNull(aboutProgramText);
        aboutProgramLabel.setText(aboutProgramText);
    }
}
