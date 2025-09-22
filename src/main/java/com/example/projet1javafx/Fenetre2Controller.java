package com.example.projet1javafx;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Fenetre2Controller
{
    // Déclaration des attribus liés au fxml
    @FXML private VBox root;
    @FXML private TextField txfText;
    @FXML private Button btnValider;
    @FXML private Button btnAnnuler;

    // Déclaration des attribus
    private boolean isBtnValiderClicked = false;

    // Validation tu txf et passage a true puis ferme la fenêtre
    @FXML private void evtOnMouseClickedBtnValider ()
    {
        isBtnValiderClicked = true;
        evtOnMouseClickedBtnAnnuler();
    }

    // Ferme la fenêtre
    @FXML private void evtOnMouseClickedBtnAnnuler ()
    {
        Stage stage = (Stage) btnAnnuler.getScene().getWindow();
        stage.close();
    }

    // Change le text du txf avec la valeur de la première fenêtre
    @FXML public void setTxfText (String txt)
    {
        txfText.setText(txt);
    }

    // Renvoie la valeur du txf
    @FXML public String getTxfText ()
    {
        return txfText.getText();
    }

    // Renvoie true si Valider est cliqué sinon renvoie false
    public boolean getIsBtnValiderClicked()
    {
        return isBtnValiderClicked;
    }

}