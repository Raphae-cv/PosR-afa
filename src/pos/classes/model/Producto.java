package model;

import data.UnidadMedida;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Usuario
 */
public class Producto {
    private static int consecutivo = 0;
    public UnidadMedida unidadMedida;

    private IntegerProperty codigo = new SimpleIntegerProperty();
    private StringProperty nombre = new SimpleStringProperty();
    private DoubleProperty precio = new SimpleDoubleProperty();
    private IntegerProperty cantidad = new SimpleIntegerProperty();
    private StringProperty cantidadUnidad = new SimpleStringProperty();

    public Producto() {
        this(0, "SIN DEFINIR", 0, 0, new UnidadMedida());
    }

    public Producto(int codigo, String nombre, double precio, int cantidad,
            UnidadMedida unidadMedida) {
        setCodigo(codigo);
        setNombre(nombre);
        setPrecio(precio);
        setCantidad(cantidad);
        setCantidadUnidad("$" + calcularPum() + "/" + unidadMedida.getNombre());
        this.unidadMedida = unidadMedida;
    }

    public Producto(String nombre, double precio, int cantidad, UnidadMedida unidadMedida) {
        this(consecutivo++, nombre, precio, cantidad, unidadMedida);
    }

    public int getCantidad() {
        return cantidad.get();
    }

    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("Cantidad no puede se negativo");
        }
        this.cantidad.set(cantidad);
    }

    public int getCodigo() {
        return codigo.get();
    }

    public void setCodigo(int codigo) {
        if (codigo < 0) {
            throw new IllegalArgumentException("Codigo no puede ser negativo");
        }
        this.codigo.set(codigo);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        if (nombre == null) {
            throw new IllegalArgumentException("Nombre no puede ser nulo");
        }
        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("Nombre no puede estar vacío");
        }
        this.nombre.set(nombre);
    }

    public double getPrecio() {
        return precio.get();
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("Precio no puede ser menor que "
                    + "0");
        }
        this.precio.set(precio);
    }

    public String getCantidadUnidad() {
        return cantidadUnidad.get();
    }

    public void setCantidadUnidad(String cantidadUnidad) {
        if (cantidadUnidad == null) {
            throw new IllegalArgumentException("Nombre no puede ser nulo");
        }
        if (cantidadUnidad.isEmpty()) {
            throw new IllegalArgumentException("Nombre no puede estar vacío");
        }
        this.cantidadUnidad.set(cantidadUnidad);
    }

    public IntegerProperty codigoProperty() {
        return codigo;
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public DoubleProperty precioProperty() {
        return precio;
    }

    public IntegerProperty cantidadProperty() {
        return cantidad;
    }

    public StringProperty cantidadUnidadProperty() {
        return cantidadUnidad;
    }

    public double calcularPum() {
        double pum = precio.get() / cantidad.get();
        return Math.round(pum * 100.0) / 100.0;
    }

}
