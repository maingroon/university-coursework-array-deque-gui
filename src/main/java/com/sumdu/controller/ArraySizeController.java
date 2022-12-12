package com.sumdu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ArraySizeController {

    @FXML
    private Label arraySizeLabel;

    public void setArraySize(int arraySize) {
        if (arraySize < 0) {
            throw new IllegalStateException("Array size cannot be less than 0");
        }
        arraySizeLabel.setText("ArrayDeque size: " + arraySize);
    }

    @FXML
    private void onOkButtonClick(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}