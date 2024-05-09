package com.example.demo.controllers;

import com.example.demo.model.Runner;
import com.example.demo.services.RunnerService;
import com.example.demo.utility.Validator;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.converter.DoubleStringConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Controller {

    @Autowired
    private RunnerService runnerService;

    @FXML
    private TableView<Runner> tableView;

    @FXML
    private Text actionTarget;

    @FXML
    public void initialize() {
        BorderPane root = new BorderPane();

        tableView.setEditable(true);

        TableColumn<Runner, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Runner, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Runner, String> runnerStringCellEditEvent) {
                Runner runner = runnerStringCellEditEvent.getRowValue();
                runner.setName(runnerStringCellEditEvent.getNewValue());
                runnerService.updateRunner(runner);
            }
        }) ;

        TableColumn<Runner, String> addressColumn = new TableColumn<>("Address");
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        addressColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        addressColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Runner, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Runner, String> runnerStringCellEditEvent) {
                Runner runner = runnerStringCellEditEvent.getRowValue();
                runner.setAddress(runnerStringCellEditEvent.getNewValue());
                System.out.println(runnerService.updateRunner(runner));
            }
        }) ;

        TableColumn<Runner, String> postalCodeColumn = new TableColumn<>("Postal Code");
        postalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        postalCodeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        postalCodeColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Runner, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Runner, String> runnerStringCellEditEvent) {
                Runner runner = runnerStringCellEditEvent.getRowValue();
                if (Validator.isValidPostalCode(runnerStringCellEditEvent.getNewValue())) {
                    runner.setPostalCode(runnerStringCellEditEvent.getNewValue());
                    runnerService.updateRunner(runner);
                    actionTarget.setText("Value changed successfully");
                    actionTarget.setFill(Color.GREEN);
                } else {
                    actionTarget.setText("Postal code format is incorrect!");
                    actionTarget.setFill(Color.RED);
                }
            }
        }) ;

        TableColumn<Runner, String> cityColumn = new TableColumn<>("City");
        cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        cityColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        cityColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Runner, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Runner, String> runnerStringCellEditEvent) {
                Runner runner = runnerStringCellEditEvent.getRowValue();
                runner.setCity(runnerStringCellEditEvent.getNewValue());
                runnerService.updateRunner(runner);
            }
        }) ;

        TableColumn<Runner, String> countryColumn = new TableColumn<>("Country");
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        countryColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        countryColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Runner, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Runner, String> runnerStringCellEditEvent) {
                Runner runner = runnerStringCellEditEvent.getRowValue();
                runner.setCountry(runnerStringCellEditEvent.getNewValue());
                runnerService.updateRunner(runner);
            }
        }) ;

        TableColumn<Runner, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        emailColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Runner, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Runner, String> runnerStringCellEditEvent) {
                Runner runner = runnerStringCellEditEvent.getRowValue();
                if (Validator.isValidEmail(runnerStringCellEditEvent.getNewValue())) {
                    runner.setEmail(runnerStringCellEditEvent.getNewValue());
                    runnerService.updateRunner(runner);
                    actionTarget.setText("Value changed successfully");
                    actionTarget.setFill(Color.GREEN);
                } else{
                    actionTarget.setText("Email format is incorrect!");
                    actionTarget.setFill(Color.RED);
                }
            }
        }) ;

        TableColumn<Runner, String> phoneNumberColumn = new TableColumn<>("Phone Number");
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        phoneNumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        phoneNumberColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Runner, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Runner, String> runnerStringCellEditEvent) {
                Runner runner = runnerStringCellEditEvent.getRowValue();
                if (Validator.isValidPhoneNumber(runnerStringCellEditEvent.getNewValue())) {
                    runner.setPhoneNumber(runnerStringCellEditEvent.getNewValue());
                    runnerService.updateRunner(runner);
                    actionTarget.setText("Value changed successfully");
                    actionTarget.setFill(Color.GREEN);
                } else{
                    actionTarget.setText("Phone number format is incorrect!");
                    actionTarget.setFill(Color.RED);
                }
            }
        }) ;

        TableColumn<Runner, Double> registrationFeeColumn = new TableColumn<>("Registration Fee");
        registrationFeeColumn.setCellValueFactory(new PropertyValueFactory<>("registrationFee"));
        registrationFeeColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        registrationFeeColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Runner, Double>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Runner, Double> runnerStringCellEditEvent) {
                Runner runner = runnerStringCellEditEvent.getRowValue();
                if (runnerStringCellEditEvent.getNewValue() < 0) {
                    actionTarget.setText("Registration fee can't be less then 0");
                    actionTarget.setFill(Color.RED);
                }
                else {
                    runner.setRegistrationFee(runnerStringCellEditEvent.getNewValue());
                    runnerService.updateRunner(runner);
                    actionTarget.setText("Value changed successfully");
                    actionTarget.setFill(Color.GREEN);
                }
            }
        }) ;





        tableView.getColumns().addAll(nameColumn, addressColumn, postalCodeColumn, cityColumn, countryColumn, emailColumn, phoneNumberColumn, registrationFeeColumn);

        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.getItems().addAll(
                getRunnersData());


        KeyCombination keyCombination = new KeyCodeCombination(KeyCode.N, KeyCombination.SHIFT_DOWN);
        Runnable action = () -> addEmptyRow();
        tableView.sceneProperty().addListener((observable, oldScene, newScene) -> {
            System.out.println("Listener triggered");
            if (oldScene == null && newScene != null) { // Scene is set for the first time
                System.out.println("Setting accelerator");
                newScene.getAccelerators().put(keyCombination, action);
            }
        });

        KeyCombination keyCombination1 = new KeyCodeCombination(KeyCode.D, KeyCombination.SHIFT_DOWN);
        Runnable action1 = () -> deleteLastRow();
        tableView.sceneProperty().addListener((observable, oldScene, newScene) -> {
            System.out.println("Listener triggered");
            if (oldScene == null && newScene != null) { // Scene is set for the first time
                System.out.println("Setting accelerator");
                newScene.getAccelerators().put(keyCombination1, action1);
            }
        });
    }

    private void addEmptyRow() {
        tableView.getItems().add(new Runner());
    }


    private void deleteLastRow() {
        tableView.getItems().remove(tableView.getItems().size()-1);
    }



    private ArrayList<Runner> getRunnersData() {
        return (ArrayList<Runner>) runnerService.readRunners();
    }

}
