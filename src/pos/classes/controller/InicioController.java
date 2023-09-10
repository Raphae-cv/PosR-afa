package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class InicioController implements Initializable {

    @FXML
    private Button btnSalir;

    @FXML
    private StackPane changeWindow;

    private DashboardController dashboardController;

    @FXML
    void setOnActionSalir(ActionEvent event) {
        Stage stage = (Stage) btnSalir.getScene().getWindow();
        stage.close();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarVentanaInicio();
    }

    public void cargarVentanaInicio () throws IOException {
        FXMLLoader root = new FXMLLoader();
        root.setLocation(getClass().getResource("/view/PerfilFXML.fxml"));
        root.load();
        Parent parent = root.getRoot();
        changeWindow.getChildren().add(parent);

        dashboardController = root.getController();
        // perfilFXMLController.set_valuePerfil(usuario.getUser_name());
    }

}
