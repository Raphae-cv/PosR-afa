package controller;

import java.net.URL;
import java.util.ResourceBundle;

import data.ProductoDAO;
import data.UnidadMedida;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Producto;

/**
 *
 * @author Usuario
 */
public class ProductoController implements Initializable {
    private Producto producto;
    private UnidadMedida unidadMedida;
    private ProductoDAO productoDAO;
    private Alert alerta = new Alert(AlertType.NONE);

    ObservableList<Producto> productos;

    @FXML
    private Button Nuevo;

    @FXML
    private Button buttonActualizar;

    @FXML
    private Button buttonBuscar;

    @FXML
    private Button buttonEliminar;

    @FXML
    private Button buttonGuardar;

    @FXML
    private TableColumn<Producto, Number> columnaProductoCantidad;

    @FXML
    private TableColumn<Producto, Number> columnaProductoCodigo;

    @FXML
    private TableColumn<Producto, String> columnaProductoNombre;

    @FXML
    private TableColumn<Producto, Number> columnaProductoPrecio;

    @FXML
    private TableColumn<Producto, Number> columnaProductoPrecioUnidad;

    @FXML
    private TableView<Producto> tableProducto;

    @FXML
    private TextField textProductoCantidad;

    @FXML
    private TextField textProductoCodigo;

    @FXML
    private TextField textProductoNombre;

    @FXML
    private TextField textProductoPrecio;

    @FXML
    private TextField textNombreUndMedida;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        productoDAO = new ProductoDAO();
        productos = FXCollections.observableArrayList();

        tableProducto.setItems(productos);
        // Crear la columna y establecer su texto cabecera
        columnaProductoCodigo.setCellValueFactory(new PropertyValueFactory<Producto, Number>("codigo"));
        columnaProductoNombre.setCellValueFactory(new PropertyValueFactory<Producto, String>("nombre"));
        columnaProductoPrecio.setCellValueFactory(new PropertyValueFactory<Producto, Number>("precio"));
        columnaProductoCantidad.setCellValueFactory(new PropertyValueFactory<Producto, Number>("cantidad"));
        columnaProductoPrecioUnidad.setCellValueFactory(new PropertyValueFactory<Producto, Number>("cantidadUnidad"));

    }

    @FXML
    private void setOnActionButtonGuardar(ActionEvent event) {
        try {
            double precio = 0;
            int cantidad = 0;

            precio = Double.parseDouble(textProductoPrecio.getText());
            cantidad = Integer.parseInt(textProductoCantidad.getText());
            unidadMedida = new UnidadMedida(textNombreUndMedida.getText());
            producto = new Producto(textProductoNombre.getText(), precio, cantidad, unidadMedida);
            textProductoCodigo.setText(producto.getCodigo() + "");
            productos.add(
                    new Producto(producto.getCodigo(), textProductoNombre.getText(), precio, cantidad, unidadMedida));

            // Agregar el producto a la lista
            productoDAO.agregar(producto);

            // Agregar los productos a la tabla
            tableProducto.setItems(productos);

            // Mostrar mensaje de éxito con una alerta de información
            alerta.setAlertType(AlertType.INFORMATION);
            alerta.setContentText("Producto creado");
            alerta.show();
        } catch (Exception e) {
            // Mostrar mensaje de error con una alerta de error
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
            // Mostrar mensaje de error con una alerta de error
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

            // Mostrar mensaje de éxito con una alerta de información
            alerta.setAlertType(AlertType.INFORMATION);
            alerta.setContentText("Producto eliminado");
            alerta.show();
        } catch (Exception e) {
            // Mostrar mensaje de error con una alerta de error
            alerta.setAlertType(AlertType.ERROR);
            alerta.setContentText(e.getMessage());
            alerta.show();
        }
    }

    @FXML
    private void setOnActionButtonActualizar(ActionEvent event) {
        try {
            int codigo;
            int cantidad;
            double precio;
            double precioUnidad;
            precio = Double.parseDouble(textProductoPrecio.getText());
            codigo = Integer.parseInt(textProductoCodigo.getText());
            cantidad = Integer.parseInt(textProductoCantidad.getText());
            producto = productoDAO.buscar(codigo);
            producto.setNombre(textProductoNombre.getText());
            producto.setPrecio(precio);
            producto.setCantidad(cantidad);

            precioUnidad = Math.round((precio / cantidad) * 100.0) / 100.0;

            // "$" + calcularPum() + "/" + unidadMedida.getNombre()
            producto.setCantidadUnidad("$" + precioUnidad + "/" + textNombreUndMedida.getText());
            productoDAO.actualizar(producto);

            // Mostrar mensaje de éxito con una alerta de información
            alerta.setAlertType(AlertType.INFORMATION);
            alerta.setContentText("Producto actualizado");
            alerta.show();
        } catch (Exception e) {
            // Mostrar mensaje de error con una alerta de error
            alerta.setAlertType(AlertType.ERROR);
            alerta.setContentText(e.getMessage());
            alerta.show();
        }
    }

    private void mostrar(Producto producto) {
        textProductoCodigo.setText(producto.getCodigo() + "");
        textProductoNombre.setText(producto.getNombre());
        textProductoPrecio.setText(producto.getPrecio() + "");
        textProductoCantidad.setText(producto.getCantidad() + "");
        textNombreUndMedida.setText(producto.unidadMedida.getNombre());
    }

    private void limpiar() {
        textProductoCodigo.clear();
        textProductoNombre.clear();
        textProductoPrecio.clear();
        textProductoCantidad.clear();
        textNombreUndMedida.clear();
    }

}
