/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
/**
 *
 * @author Usuario
 */
public class ProductoVenta {
     private ObjectProperty<Producto> producto = new SimpleObjectProperty();
    private IntegerProperty cantidad = new SimpleIntegerProperty();

    public ProductoVenta() {

    }

    public ProductoVenta(Producto producto, int cantidad) {
        setCantidad(cantidad);
        setProducto(producto);

    }

    public Producto getProducto() {
        return producto.get();
    }

    public void setProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("Producto no puede ser nulo");
        }
        this.producto.set(producto);
    }

    public int getCantidad() {
        return cantidad.get();
    }

    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("Cantidad no puede ser "
                    + "negativa");
        }
        this.cantidad.set(cantidad);
    }

    public ObjectProperty<Producto> productoProperty() {
        return producto;
    }

    public IntegerProperty cantidadProperty() {
        return cantidad;
    }

    public double subtotalizar() {
        return getProducto().getPrecio() * getCantidad();
    }
}
