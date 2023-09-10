/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import java.io.IOException;

import controller.InicioController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Usuario
 */
public class POS extends Application {
    public static void main(String[] args) {
          launch(args);
    }

    // Variables para mover la ventana
    double yoffset;
    double xoffset;

    // Metodo para cargar la ventana con el estilo de la ventana de inicio
    // y con la funcionalidad de mover la ventana.

    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader loader = new FXMLLoader(); 
        loader.setLocation(getClass().getResource("/view/Inicio.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setTitle("Login");
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.getIcons().add(new Image(POS.class.
                getResourceAsStream("/assets/images/logo.png")));
        primaryStage.setScene(scene);
        primaryStage.show();

        InicioController inicioController = loader.getController();
        inicioController.cargarVentanaInicio();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xoffset = event.getSceneX();
                yoffset = event.getSceneY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xoffset);
                primaryStage.setY(event.getScreenY() - yoffset);
            }
        });
    }
}