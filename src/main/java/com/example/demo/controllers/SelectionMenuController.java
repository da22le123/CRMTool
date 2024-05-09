package com.example.demo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class SelectionMenuController {

    @Autowired
    private ApplicationContext context;
    @FXML
    private Button runnersButton;


    public SelectionMenuController() {
        // You may want to handle this differently based on your application logic
    }

    @FXML
    public void initialize() {
        // Set action for the "Runners" button
        runnersButton.setOnAction(this::handleRunnersButtonClick);
    }

    private void handleRunnersButtonClick(ActionEvent event) {
        try {
            URL fxmlFileUrl = getClass().getClassLoader().getResource("static/runners-table.fxml");
            if (fxmlFileUrl == null) {
                throw new IllegalArgumentException("File not found");
            }
            FXMLLoader loader = new FXMLLoader();
            loader.setControllerFactory(context::getBean);
            loader.setLocation(fxmlFileUrl);
            Parent root = loader.load();


            Stage primaryStage = (Stage) runnersButton.getScene().getWindow();
            primaryStage.setScene(new Scene(root));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
