/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Usuario
 */
public class Cliente {
   private StringProperty identificacion = new SimpleStringProperty();
    private StringProperty nombres = new SimpleStringProperty();
    private StringProperty apellidos = new SimpleStringProperty();
    private int puntos;

    
    public Cliente(){
        this("SIN DEFINIR", "SIN DEFINIR", "SIN DEFINIR");
         puntos = 0;
    }
    
    public Cliente(String identificacion, String nombres, String apellidos){
        setIdentificacion(identificacion);
        setNombre(nombres);
        setApellidos(apellidos);
    }
    
    public String getIdentificacion() {
        return identificacion.get();
    }

    public void setIdentificacion(String identificacion) {
        if (identificacion == null) {
            throw new IllegalArgumentException("Identificacion no puedes ser"
                    + "nula ");
        }
        if (identificacion.isEmpty()) {
            throw new IllegalArgumentException("Identificacion no puedes ser"
                    + "vacia ");
        }
        this.identificacion.set(identificacion);
    }

    public StringProperty identificacionProperty() {
        return identificacion;
    }

    public String getNombres() {
        return nombres.get();
    }

    public void setNombre(String nombres) {
        if (nombres == null) {
            throw new IllegalArgumentException("Nombre no puedes ser"
                    + "nulo");
        }if (nombres.isEmpty()) {
            throw new IllegalArgumentException("Nombre no puedes ser"
                    + "vacio");
        }this.nombres.set(nombres);
    }

    public StringProperty nombresProperty() {
        return nombres;
    }
    
    public String getApellidos() {
        return apellidos.get();
    }

    public void setApellidos(String apellidos) {
        if (apellidos == null) {
            throw new IllegalArgumentException("Apellido no puedes ser"
                    + "nulo");
        }if (apellidos.isEmpty()) {
            throw new IllegalArgumentException("Apellido no puedes ser"
                    + "vacio");
        }this.apellidos.set(apellidos);
    }

    public StringProperty apellidosProperty() {
        return apellidos;
    }
    
    @Override
    public String toString(){
        return getNombres() + "-" + getApellidos();
    }
    public void calcularPuntos(int montoCompra) {
        if (montoCompra >= 100) {
            puntos += (montoCompra / 100) * 10;
        }        
    }
    public int getPuntos() {
        return puntos;
    }
     public static void main(String[] args) {
        Cliente cliente = new Cliente();

        // Simulando diferentes compras y calculando puntos
        int[] compras = {100, 200, 300, 50, 150};
        for (int compra : compras) {
            cliente.calcularPuntos(compra);
        }
        throw new IllegalArgumentException("Total de puntos acumulados: " 
                + cliente.getPuntos());
    }
}

