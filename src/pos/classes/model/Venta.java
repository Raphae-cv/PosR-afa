/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.Objects;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Usuario
 */
public class Venta {

    private static int consecutivo;

    private IntegerProperty codigo = new SimpleIntegerProperty();
    private ObjectProperty<Cliente> cliente = new SimpleObjectProperty();
    private ObjectProperty<LocalDate> fecha = new SimpleObjectProperty();
    private ObservableList<ProductoVenta> listaProductos
            = FXCollections.observableArrayList();
   

    private Venta(int par) {

    }

    public Venta(Cliente cliente) {
        this(consecutivo++, cliente, LocalDate.now());
    }

    private Venta(int codigo, Cliente cliente, LocalDate fecha) {
        setCodigo(codigo);
        setCliente(cliente);
        setFecha(fecha);

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

    public IntegerProperty codigoProperty() {
        return codigo;
    }

    public Cliente getCliente() {
        return cliente.get();
    }

    public void setCliente(Cliente cliente) {
        Objects.requireNonNull(cliente, "Cliente no puede ser nulo");
        this.cliente.set(cliente);
    }

    public ObjectProperty<Cliente> clienteProperty() {
        return cliente;
    }

    public LocalDate getFecha() {
        return fecha.get();
    }

    public void setFecha(LocalDate fecha) {
        Objects.requireNonNull(fecha, "Fecha no puede ser nula");
        this.fecha.set(fecha);
    }

    public ObjectProperty<LocalDate> fechaProperty() {
        return fecha;
    }

    public double totalizar() {
        double total;
        total = 0;
        for (ProductoVenta listProducto : listaProductos) {
            total += listProducto.subtotalizar();
        }
        return total;
    }

    public ObservableList<ProductoVenta> getListaProductos() {
        return listaProductos;
    }

    public void agregarProducto(ProductoVenta productoventa) {
        Objects.requireNonNull(productoventa, "Producto venta no puede ser"
                + " nulo");
        listaProductos.add(productoventa);
    }

    public void agregarProducto(Producto producto, int cantidad) {
        ProductoVenta productoVenta;
        productoVenta = new ProductoVenta(producto, cantidad);
        agregarProducto(productoVenta);
    }

    public void agregarProducto(ProductoVenta[] productoVenta) {
        for (ProductoVenta productoVenta1 : productoVenta) {
            agregarProducto(productoVenta1);
        }
    }

    public void agregarProducto(Producto producto) {
        agregarProducto(producto, 1);
    }
}
