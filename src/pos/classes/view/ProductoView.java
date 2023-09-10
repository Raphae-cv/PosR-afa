/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import java.io.IOException;
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
public class ProductoView extends Application {
    public static void main(String[] args) {
          launch(args);
    }

//     @Override
//     public void start(Stage stage) throws Exception {
//         Parent parent = FXMLLoader.load(
//                 getClass().getResource("/view/Inicio.fxml"));
//         Scene scene = new Scene(parent);
//         stage.setScene(scene);
//         stage.show();
//     }

// }

    double yoffset;
    double xoffset;

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass()
                .getResource("/view/Inicio.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Login");
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.getIcons().add(new Image(ProductoView.class.
                getResourceAsStream("/assets/images/logo.png")));
        primaryStage.setScene(scene);
        primaryStage.show();

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