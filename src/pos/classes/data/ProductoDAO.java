package data;

import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Producto;

/**
 * @author RAFAEL CARRILLO
 * @version 1.0
 */
public class ProductoDAO {

    private static ObservableList<Producto> productos = FXCollections.observableArrayList();

    public ProductoDAO() {
    }

    public static ObservableList<Producto> getProductos() {
        return productos;
    }

    public static void setProductos(ObservableList<Producto> aProductos) {
        productos = aProductos;
    }

    // agregar
    public void agregar(Producto producto) {
        Objects.requireNonNull(producto, "producto no puede ser nulo");
        productos.add(producto);
    }

    // eliminar 
    public void eliminar(Producto producto) {
        Objects.requireNonNull(producto, "producto no puede ser nulo");
        int indice;
        indice = productos.indexOf(producto);
        productos.remove(indice);
    }

    // actualizar 
    public void actualizar(Producto producto) {
        Objects.requireNonNull(producto, "producto no puede ser nulo");
        int indice;
        indice = productos.indexOf(producto);
        productos.set(indice, producto);
    }

    // buscar
    public Producto buscar(int codigo) {

        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo) {
                return producto;
            }
        }
        return null;

    }
}
