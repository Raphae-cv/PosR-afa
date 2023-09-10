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
    private Button btnCliente;

    @FXML
    private Button btnInicio;

    @FXML
    private Button btnProducto;

    @FXML
    private Button btnSalir;

    @FXML
    private Button btnVenta;

    @FXML
    private StackPane changeWindow;

    @FXML
    void setOnActionSalir(ActionEvent event) {
        Stage stage = (Stage) btnSalir.getScene().getWindow();
        stage.close();

    }

    @FXML
    void setOnActionCliente(ActionEvent event) {

    }

    @FXML
    void setOnActionInicio(ActionEvent event) throws IOException {
        FXMLLoader root = new FXMLLoader();
        root.setLocation(getClass().getResource("/view/dashboardInicio.fxml"));
        root.load();
        Parent parent = root.getRoot();
        changeWindow.getChildren().add(parent);
    }

    @FXML
    void setOnActionProducto(ActionEvent event) throws IOException {
        FXMLLoader root = new FXMLLoader();
        root.setLocation(getClass().getResource("/view/FormProducto.fxml"));
        root.load();
        Parent parent = root.getRoot();
        changeWindow.getChildren().add(parent);
    }

    @FXML
    void setOnActionVenta(ActionEvent event) throws IOException {
        FXMLLoader root = new FXMLLoader();
        root.setLocation(getClass().getResource("/view/VentaFXML.fxml"));
        root.load();
        Parent parent = root.getRoot();
        changeWindow.getChildren().add(parent);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // cargarVentanaInicio();
    }

    public void cargarVentanaInicio() throws IOException {
        FXMLLoader root = new FXMLLoader();
        root.setLocation(getClass().getResource("/view/dashboardInicio.fxml"));
        root.load();
        Parent parent = root.getRoot();
        changeWindow.getChildren().add(parent);
        // perfilFXMLController.set_valuePerfil(usuario.getUser_name());
    }

    

}
