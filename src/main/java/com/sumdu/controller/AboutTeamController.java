package com.sumdu.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AboutTeamController implements Initializable {

    @FXML
    private Label performersLabel;

    @FXML
    private Label aboutProgramLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        performersLabel.setText(
                """
                1. Badyva Sergey Oleksandrovych
                2. Berezhny Vladyslav Oleksandrovych
                3. Bondarenko Oleksandr Fedorovych
                4. Borovyk Oleksandr Olehovych"""
        );

        aboutProgramLabel.setText(
                """
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
                do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                Ut enim ad minim veniam, quis nostrud exercitation ullamco
                laboris nisi ut aliquip ex ea commodo consequat."""
        );
    }
}
