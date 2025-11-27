package com.example.calculadoradedesempenhovesp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TelaCalculoDesempenhoController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}