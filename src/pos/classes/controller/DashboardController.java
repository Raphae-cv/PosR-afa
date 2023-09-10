package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class DashboardController implements Initializable {

    @FXML
    private Button btnSalir;

    @FXML
    private Label txtTotalProductos;

    @FXML
    private Label txtTotalVendido;

    @FXML
    private Label txtTotalVentas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    void setOnActionSalir(ActionEvent event) {

    }

}