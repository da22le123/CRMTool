package com.example.demo.controllers;

import com.example.demo.utility.Validator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class LogInController {

    @Autowired
    private ApplicationContext context;

    @FXML
    private TextField userNameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Text actionTarget;

//    @FXML
//    public Label label;

//    @FXML
//    public Button button;


    public LogInController() {

    }

    @FXML
    private void initialize() {
        // Setup the key pressed event for the username field
        userNameField.setOnKeyPressed(event -> handleEnterPressed(event));

        // Setup the key pressed event for the password field
        passwordField.setOnKeyPressed(event -> handleEnterPressed(event));
    }

    private void handleEnterPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            signIn();
        }
    }

    @FXML
    public void signIn(){
        String email = userNameField.getText();
        String password = passwordField.getText();

        if (email.isEmpty() || password.isEmpty())
            actionTarget.setText("Password and email fields should not be empty!");
        else if (!Validator.isValidEmail(email))
            actionTarget.setText("Email is not valid, provide a valid email!");
        else {
            actionTarget.setText("Signed IN!");
            try {
                URL fxmlFileUrl = getClass().getClassLoader().getResource("static/selection-menu.fxml");
                if (fxmlFileUrl == null) {
                    throw new IllegalArgumentException("File not found");
                }
                FXMLLoader loader = new FXMLLoader();
                loader.setControllerFactory(context::getBean);
                loader.setLocation(fxmlFileUrl);
                Parent root = loader.load();


                Stage primaryStage = (Stage) userNameField.getScene().getWindow();
                primaryStage.setScene(new Scene(root));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(email + " " + password); //debug
    }



}
