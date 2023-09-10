/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import data.ProductoDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Producto;

/**
 *
 * @author Usuario
 */
public class ProductoController {
    private Producto producto;
    private ProductoDAO productoDAO = new ProductoDAO();
    private Alert alerta = new Alert(AlertType.NONE);

    @FXML
    private Label labelProductoCodigo;
    @FXML
    private Label labelProductoNombre;
    @FXML
    private Label labelProductoPrecio;
    @FXML
    private TextField textProductoCodigo;
    @FXML
    private TextField textProductoNombre;
    @FXML
    private TextField textProductoPrecio;
    @FXML
    private Button buttonGuardar;
    @FXML
    private Button buttonBuscar;
    @FXML
    private Button buttonNuevo;
    @FXML
    private Button buttonActualizar;

    @FXML
    private void setOnActionButtonGuardar(ActionEvent event) {
        try {
            double precio;
            precio = Double.parseDouble(textProductoPrecio.getText());
            producto = new Producto(textProductoNombre.getText(), precio);
            textProductoCodigo.setText(producto.getCodigo() + "");
            productoDAO.agregar(producto);
            alerta.setAlertType(AlertType.INFORMATION);
            alerta.setContentText("Producto creado");
            alerta.show();
        } catch (Exception e) {
            alerta.setAlertType(AlertType.ERROR);
            alerta.setContentText(e.getMessage());
            alerta.show();
        }
    }

    @FXML
    private void setOnActionButtonBuscar(ActionEvent event) {
        try {
            int codigo;
            codigo = Integer.parseInt(textProductoCodigo.getText());
            producto = productoDAO.buscar(codigo);
            if (producto == null) {
                throw new Exception("Producto no existe");
            }
            mostrar(producto);
        } catch (Exception e) {
            alerta.setAlertType(AlertType.ERROR);
            alerta.setContentText(e.getMessage());
            alerta.show();
        }
    }

    @FXML
    private void setOnActionButtonNuevo(ActionEvent event) {
        try {
            limpiar();
        } catch (Exception e) {

        }
    }

    @FXML
    private void setOnActionButtonEliminar(ActionEvent event) {
        try {
            int codigo;
            codigo = Integer.parseInt(textProductoCodigo.getText());
            producto = productoDAO.buscar(codigo);
            productoDAO.eliminar(producto);
            limpiar();
            alerta.setAlertType(AlertType.INFORMATION);
            alerta.setContentText("Producto eliminado");
            alerta.show();
        } catch (Exception e) {
            alerta.setAlertType(AlertType.ERROR);
            alerta.setContentText(e.getMessage());
            alerta.show();
        }
    }

    @FXML
    private void setOnActionButtonActualizar(ActionEvent event) {
        try {
            int codigo;
            double precio;
            precio = Double.parseDouble(textProductoPrecio.getText());
            codigo = Integer.parseInt(textProductoCodigo.getText());
            producto = productoDAO.buscar(codigo);
            producto.setNombre(textProductoNombre.getText());
            producto.setPrecio(precio);
            productoDAO.actualizar(producto);
            alerta.setAlertType(AlertType.INFORMATION);
            alerta.setContentText("Producto actualizado");
            alerta.show();
        } catch (Exception e) {
            alerta.setAlertType(AlertType.ERROR);
            alerta.setContentText(e.getMessage());
            alerta.show();
        }
    }

    private void mostrar(Producto producto) {
        textProductoCodigo.setText(producto.getCodigo() + "");
        textProductoNombre.setText(producto.getNombre());
        textProductoPrecio.setText(producto.getPrecio() + "");
    }

    private void limpiar() {
        textProductoCodigo.clear();
        textProductoNombre.clear();
        textProductoPrecio.clear();
    }

}
