package com.example.projet1javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import java.io.IOException;

public class Fenetre1Controller
{
    // Déclaration des attribus liés au fxml
    @FXML private VBox root;
    @FXML private TextField txfText;
    @FXML private Button btnOk;
    @FXML private Button btnValider;
    @FXML private Label dynamicLbl;

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Change le texte du label lorsque le bouton Ok est cliqué
    @FXML private void evtOnMouseClickedBtnOk()
    {
        dynamicLbl.setText(txfText.getText());
    }

    // Charge la deuxième fenêtre avec la valeur du txf de la première
    // et attend la validation sur la deuxième fenêtre pour renvoyer la
    // valeur du txf
    @FXML private void evtOnMouseClickedBtnValider()
    {
        try {
            // Chargement de la deuxième fenêtre et de ses paramètres
            FXMLLoader fxmlLoader = new FXMLLoader(Tp1.class.getResource("fenetre2.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 400);
            Stage stage = new Stage();
            stage.setTitle("Fenêtre 2");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);

            // Récupération des méthode public du controlleur de la deuxième fenêtre
            // puis récupération de la valeur du txf de la première fenêtre vers
            // la deuxième fenêtre
            Fenetre2Controller controller = fxmlLoader.getController();
            controller.setTxfText(txfText.getText());

            // Attend la fermeture de la deuxième fenêtre puis envoi des valeur du txf
            // de la deuxième fenêtre vers la première
            stage.showAndWait();
            if (controller.getIsBtnValiderClicked()) {
                txfText.setText(controller.getTxfText());
                dynamicLbl.setText(txfText.getText());
            }
        } catch (IOException e) {
            e.printStackTrace();
            showError(e.getMessage());
        }
    }

}
