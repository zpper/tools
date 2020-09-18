package com.zipper.xff;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class FXMLExampleController {

    @FXML
    private TextField actionbar;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Text alert;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        alert.setText("Sign in button pressed");
        try {

            StartApplication.onSwitch();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
