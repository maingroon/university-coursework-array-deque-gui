package com.sumdu.controller;

import com.sumdu.service.ArrayDequeService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private Stage aboutTeamStage;
    private Stage arraySizeStage;
    private Stage showElementStage;

    private ArraySizeController arraySizeController;
    private ShowElementController showElementController;

    private ArrayDequeService arrayDequeService;

    @FXML
    private FlowPane flowPane;
    @FXML
    private TextField inputField;
    @FXML
    private RadioButton firstRadio;
    @FXML
    private RadioButton lastRadio;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        arrayDequeService = new ArrayDequeService();

        flowPane.setPadding(new Insets(5));
        flowPane.setVgap(5);
        flowPane.setHgap(5);
        firstRadio.setSelected(false);
        lastRadio.setSelected(true);

        inputField.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER)  {
                try {
                    onAddButtonClick();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    @FXML
    public void onFirstRadioClick() {
        firstRadio.setSelected(true);
        lastRadio.setSelected(false);
    }

    @FXML
    public void onLastRadioClick() {
        firstRadio.setSelected(false);
        lastRadio.setSelected(true);
    }

    @FXML
    private void onAboutButtonClick() throws IOException {
        if (aboutTeamStage == null) {
            URL aboutTeamViewLocation = Objects.requireNonNull(getClass().getResource("/about-team-view.fxml"));
            FXMLLoader fxmlLoader = new FXMLLoader(aboutTeamViewLocation);
            Scene aboutTeamScene = new Scene(fxmlLoader.load());

            AboutTeamController aboutTeamController = fxmlLoader.getController();
            aboutTeamController.setPerformersText("Performers");
            aboutTeamController.setAboutProgramText("About program text");

            aboutTeamStage = new Stage();
            aboutTeamStage.setScene(aboutTeamScene);
            aboutTeamStage.setResizable(false);
            aboutTeamStage.setTitle("About team 17 - ARRAY DEQUE");
            aboutTeamStage.show();
        }
        aboutTeamStage.show();
    }

    @FXML
    private void onAddButtonClick() throws IOException {
        boolean successfullyAdded = arrayDequeService.add(inputField.getText(), firstRadio.isSelected());
        if (!successfullyAdded) {
            return;
        }

        Rectangle rectangle = new Rectangle(73, 73);
        rectangle.setFill(new Color(0.45, 0.45, 0.45, 1));

        Label textLabel = new Label(inputField.getText());
        textLabel.setFont(new Font("Arial bold", 18));
        textLabel.setTextFill(new Color(0.94, 0.94, 0.94, 1));

        StackPane pane = new StackPane(rectangle, textLabel);
        pane.setAlignment(Pos.CENTER);

        var nodes = flowPane.getChildren();
        if (firstRadio.isSelected()) {
            nodes.add(0, pane);
        } else {
            nodes.add(nodes.size(), pane);
        }
        inputField.clear();
    }

    @FXML
    private void onPollButtonClick() throws IOException {
        Integer value = arrayDequeService.poll(firstRadio.isSelected());
        if (value == null) {
            return;
        }

        var nodes = flowPane.getChildren();
        if (firstRadio.isSelected()) {
            nodes.remove(0);
        } else {
            nodes.remove(nodes.size() - 1);
        }

        if (showElementStage == null) {
            initShowElementStage();
        }
        showElementController.setRectangleValue(value);
        showElementStage.show();
    }

    @FXML
    private void onPeekButtonClick() throws IOException {
        Integer value = arrayDequeService.peek(firstRadio.isSelected());
        if (value == null) {
            return;
        }

        if (showElementStage == null) {
            initShowElementStage();
        }
        showElementController.setRectangleValue(value);
        showElementStage.show();
    }

    private void initShowElementStage() throws IOException {
        URL showElementViewLocation = Objects.requireNonNull(getClass().getResource("/show-element-view.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(showElementViewLocation);
        Scene showElementScene = new Scene(fxmlLoader.load());

        showElementController = fxmlLoader.getController();

        showElementStage = new Stage();
        showElementStage.setScene(showElementScene);
        showElementStage.setResizable(false);
        showElementStage.setTitle("ARRAY DEQUE");
        showElementStage.show();
    }

    @FXML
    private void onRemoveButtonClick() throws IOException {
        boolean successfullyDropped = arrayDequeService.remove(firstRadio.isSelected());
        if (!successfullyDropped) {
            return;
        }

        var nodes = flowPane.getChildren();
        if (firstRadio.isSelected()) {
            nodes.remove(0);
        } else {
            nodes.remove(nodes.size() - 1);
        }
    }

    @FXML
    private void onClearButtonClick() {
        arrayDequeService.clear();
        flowPane.getChildren().clear();
    }

    @FXML
    private void onSizeButtonClick() throws IOException {
        if (arraySizeStage == null) {
            URL arraySizeViewLocation = Objects.requireNonNull(getClass().getResource("/array-size-view.fxml"));
            FXMLLoader fxmlLoader = new FXMLLoader(arraySizeViewLocation);
            Scene arraySizeScene = new Scene(fxmlLoader.load());

            arraySizeController = fxmlLoader.getController();

            arraySizeStage = new Stage();
            arraySizeStage.setScene(arraySizeScene);
            arraySizeStage.setResizable(false);
            arraySizeStage.setTitle("ARRAY DEQUE");
            arraySizeStage.show();
        }
        arraySizeController.setArraySize(arrayDequeService.getSize());
        arraySizeStage.show();
    }
}