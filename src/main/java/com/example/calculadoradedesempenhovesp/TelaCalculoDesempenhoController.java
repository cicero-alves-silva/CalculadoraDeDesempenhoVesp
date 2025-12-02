package com.example.calculadoradedesempenhovesp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TelaCalculoDesempenhoController {

    @FXML
    private Label lbResultado;

    @FXML
    private TextField tfMediaBimestre1;

    @FXML
    private TextField tfMediaBimestre2;

    @FXML
    private TextField tfMediaBimestre3;

    @FXML
    private TextField tfMediaBimestre4;

    @FXML
    void cliqueCalcular(ActionEvent event) {
        String mb1String = tfMediaBimestre1.getText();
        String mb2String = tfMediaBimestre2.getText();
        String mb3String = tfMediaBimestre3.getText();
        String mb4String = tfMediaBimestre4.getText();
        if (mb1String.isBlank() || mb2String.isBlank() || mb3String.isBlank()) {
            lbResultado.setText("Você precisa preencher pelo menos as médias " +
                    "dos bimestre 1, 2 e 3.");
            lbResultado.setStyle("-fx-text-fill: #FF0000");
        } else {
            try {
                int mb1 = Integer.parseInt(mb1String);
                int mb2 = Integer.parseInt(mb2String);
                int mb3 = Integer.parseInt(mb3String);
                if (mb4String.isBlank()) {
                    int mb4 = 280 - mb1 - mb2 - mb3;
                    if (mb4 > 100) {
                        lbResultado.setText("Você precisará fazer a prova final.");
                        lbResultado.setStyle("-fx-text-fill: #FF0000");
                    } else if (mb4 > 0) {
                        lbResultado.setText("Você precisa de " + mb4 + " no Bimestre 4.");
                        lbResultado.setStyle("-fx-text-fill: #000000");
                    } else {
                        lbResultado.setText("Você passou no Bimestre 3.");
                        lbResultado.setStyle("-fx-text-fill: #008000");
                    }
                } else {
                    int mb4 = Integer.parseInt(mb4String);
                    double ma = (mb1 + mb2 + mb3 + mb4) / 4.0;
                    long maArredondada = Math.round(ma);
                    if (maArredondada >= 70) {
                        lbResultado.setText("Média anual " + maArredondada + ".\nAPROVADO");
                        lbResultado.setStyle("-fx-text-fill: #008000");
                    } else {
                        double af = (500 - 6 * maArredondada) / 4.0;
                        long afArredondada = Math.round(af);
                        lbResultado.setText("Média anual " + maArredondada +
                                ".\nVocê precisa de " + afArredondada + " na AF.");
                        lbResultado.setStyle("-fx-text-fill: #FF0000");
                    }
                }
            } catch (NumberFormatException nfe) {
                lbResultado.setText("As médias precisam ser números inteiros.");
                lbResultado.setStyle("-fx-text-fill: #FF0000");
            }
        }
    }

    @FXML
    void cliqueLimpar(ActionEvent event) {
        tfMediaBimestre1.clear();
        tfMediaBimestre2.clear();
        tfMediaBimestre3.clear();
        tfMediaBimestre4.clear();
        lbResultado.setText("");
    }

}
