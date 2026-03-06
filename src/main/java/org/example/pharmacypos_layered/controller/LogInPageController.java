package org.example.pharmacypos_layered.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import org.example.pharmacypos_layered.Launcher;
import org.example.pharmacypos_layered.service.BOFactory;
import org.example.pharmacypos_layered.service.BOType;
import org.example.pharmacypos_layered.service.EmployeeBO;
import org.example.pharmacypos_layered.utility.References;

import java.net.URL;
import java.util.ResourceBundle;

// Handles login screen behavior: validation, focus flow, and navigation.
public class LogInPageController implements Initializable {
    @FXML
    private TextField nameField;

    @FXML
    private TextField passwordField;

    // Property Injection
    private final EmployeeBO employeeBO = (EmployeeBO) BOFactory.getInstance().getBO(BOType.EMPLOYEE);

    // Initialize UI behavior (focus flow between fields).
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Move from nameField to passwordField
        moveToNextOnEnter(nameField, passwordField);
    }

    // Triggered when the user submits login (button or Enter key).
    @FXML
    void btnSubmitOnAction(ActionEvent event) {
        String userName = nameField.getText();
        String password = passwordField.getText();

        // isEmpty Check username and password
        if (userName.isEmpty() || password.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Please fill the fields", ButtonType.OK).show();
            cleanFields();

        }else {
            try {
                // Validation Check for username and password
                boolean isValid = employeeBO.checkValidation(userName, password);

                if (isValid) {
                    System.out.println("Log In");

                    // set Current username to static Field
                    References.currentUserName = userName;
                    Launcher.setRoot("DashLayout");

                }else{
                    System.out.println("Unauthorised access");
                    new Alert(Alert.AlertType.ERROR, "Please Try Again", ButtonType.OK).show();
                    cleanFields();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Moves focus to the next control when Enter is pressed.
    private void moveToNextOnEnter(Control current, Control next) {
        current.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case ENTER -> {
                    next.requestFocus();
                    event.consume();
                }
            }
        });
    }

    // Clears input fields after invalid login or empty input.
    private void cleanFields() {
        nameField.clear();
        passwordField.clear();
    }
}
