package com.sumdu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ShowElementController {

    @FXML
    Label rectangleLabel;

    @FXML
    private void onOkButtonClick(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void setRectangleValue(int value) {
        rectangleLabel.setText(String.valueOf(value));
    }
}
