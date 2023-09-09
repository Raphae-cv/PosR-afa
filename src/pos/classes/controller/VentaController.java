/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import data.ClienteDAO;
import data.ProductoDAO;
import data.VentaDAO;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Cliente;
import model.Producto;
import model.ProductoVenta;
import model.Venta;
/**
 *
 * @author Usuario
 */
public class VentaController {
    private Venta venta;
    private VentaDAO ventaDAO;
    Producto producto;
    ProductoDAO productoDAO;
    Cliente cliente;
    ClienteDAO clienteDAO;

    private Alert alerta;
    @FXML
    private TextField textVentaCodigo;
    @FXML
    private TextField textClienteCodigo;
    @FXML
    private TextField textClienteNombre;
    @FXML
    private TextField textProductoCodigo;
    @FXML
    private TextField textProductoNombre;
    @FXML
    private TextField textCantidad;
    @FXML
    private TextField textTotal;
    @FXML
    private DatePicker textVentaFecha;
    @FXML
    private TableView<ProductoVenta> tableProductos;
    @FXML
    private TableColumn<ProductoVenta, Number> columnProductoCodigo;
    @FXML
    private TableColumn<ProductoVenta, String> columnProductoNombre;
    @FXML
    private TableColumn<ProductoVenta, Number> columnProductoPrecio;
    @FXML
    private TableColumn<ProductoVenta, Number> columnCantidad;
    @FXML
    private TableColumn<ProductoVenta, Number> columnSubtotal;
    @FXML
    private Button buttonAgregarProducto;
    @FXML
    private Button buttonGuardar;
    @FXML
    private Button buttonNuevo;
    

    @FXML
    public void setOnActionButtonAgregarProducto(ActionEvent event) {
        try {
            int cantidad;
            cantidad = Integer.parseInt(textCantidad.getText());
            venta.agregarProducto(producto, cantidad);
            textProductoCodigo.setText("");
            textProductoNombre.setText("");
            producto = null;
            textCantidad.setText("1");
            textProductoCodigo.requestFocus();
            textTotal.setText(venta.totalizar() + "");

        } catch (Exception e) {
            alerta.setAlertType(Alert.AlertType.ERROR);
            alerta.setContentText(e.getMessage());
            alerta.show();
        }
    }

    @FXML
    public void setOnActionButtonGuardar(ActionEvent event) {

    }

    @FXML
    public void setOnActionButtonNuevo(ActionEvent event) {
        try {
            venta = new Venta(cliente);
            textVentaCodigo.setText(venta.getCodigo() + "");
            textVentaFecha.setValue(venta.getFecha());
            tableProductos.setItems(venta.getListaProductos());
            alerta.setAlertType(Alert.AlertType.INFORMATION);
            alerta.setContentText("Venta Creada");
            alerta.show();
        } catch (Exception e) {
            alerta.setAlertType(Alert.AlertType.ERROR);
            alerta.setContentText(e.getMessage());
            alerta.show();
        }

    }

    @FXML
    public void setOnActionTextClienteCodigo(ActionEvent event) {
        try {
            cliente = clienteDAO.buscar(textClienteCodigo.getText());
            Objects.requireNonNull(cliente, "Cliente no existe");
            textClienteNombre.setText(cliente.toString());
        } catch (Exception e) {
            alerta.setAlertType(Alert.AlertType.ERROR);
            alerta.setContentText(e.getMessage());
            alerta.show();
        }
    }

       @FXML
    public void setOnActionTextProductoCodigo(ActionEvent event) {
        try {
            int codigo;
            codigo = Integer.parseInt(textProductoCodigo.getText());
            producto = productoDAO.buscar(codigo);
            Objects.requireNonNull(producto, "Producto no existe");
            textProductoNombre.setText(producto.getNombre());

        } catch (Exception e) {
            alerta.setAlertType(Alert.AlertType.ERROR);
            alerta.setContentText(e.getMessage());
            alerta.show();
        }
    }

    public void initialize(URL url, ResourceBundle rb) {
        clienteDAO = new ClienteDAO();
        productoDAO = new ProductoDAO();
        ventaDAO = new VentaDAO();
        alerta = new Alert(Alert.AlertType.NONE);

        clienteDAO.agregar(new Cliente("18", "Elias", "Ramirez"));
        productoDAO.agregar(new Producto("Computador", 1_500_000));
        productoDAO.agregar(new Producto("Mesa", 15_000));
        productoDAO.agregar(new Producto("One Piece", 49_000));
        productoDAO.agregar(new Producto("Ajedrez", 55_000));
        productoDAO.agregar(new Producto("Pizza", 28_000));

        columnProductoCodigo.setCellValueFactory(cellData
                -> cellData.getValue().getProducto().codigoProperty());

        columnProductoNombre.setCellValueFactory(cellData
                -> cellData.getValue().getProducto().nombreProperty());

        columnProductoPrecio.setCellValueFactory(cellData
                -> cellData.getValue().getProducto().precioProperty());

        columnCantidad.setCellValueFactory(cellData
                -> cellData.getValue().cantidadProperty());

        columnSubtotal.setCellValueFactory(cellData -> {
            return new SimpleDoubleProperty(cellData.getValue().subtotalizar());
        });
    }

}
