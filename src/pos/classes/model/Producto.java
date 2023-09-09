/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
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
     private static int consecutivo;
    
    private IntegerProperty codigo = new SimpleIntegerProperty();
    private StringProperty nombre = new SimpleStringProperty();
    private DoubleProperty precio = new SimpleDoubleProperty();

    public Producto(){
        this(0,"SIN DEFINIR",0);
    }
    
    public Producto(int codigo, String nombre, double precio){
        setCodigo(codigo);
        setNombre(nombre);
        setPrecio(precio);
    }
    
    public Producto(String nombre, double precio){
        this(consecutivo++, nombre, precio);
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
    
    public IntegerProperty codigoProperty(){
        return codigo;
    }
    
    public StringProperty nombreProperty(){
        return nombre;
    }
    
    public DoubleProperty precioProperty(){
        return precio;
    }
}
