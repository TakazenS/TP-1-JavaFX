package com.example.projet1javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Tp1 extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        // Chargement de la première fenêtre et de ses paramètres
        FXMLLoader fxmlLoader = new FXMLLoader(Tp1.class.getResource("fenetre1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        stage.setTitle("Fenêtre 1");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args)
    {
        // Lancement de l'application
        Application.launch(args);
    }

}