/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Venta;
/**
 *
 * @author Usuario
 */
public class VentaDAO {
    private static ObservableList<Venta> ventas = FXCollections.observableArrayList();

    public VentaDAO() {
    }
    public static ObservableList<Venta> getVentas() {
        return ventas;
    }
    public static void setVentas(ObservableList<Venta> aVentas) {
        ventas = aVentas;
    }
    public void agregar(Venta venta) {
        Objects.requireNonNull(venta, "Venta no puede ser nula");
        ventas.add(venta);

    }
    public void eliminar(Venta venta) {
        Objects.requireNonNull(venta, "Venta no puede ser vacia");
        ventas.remove(venta);
    }
    public void actualizar(Venta venta) {
        Objects.requireNonNull(venta, "Venta no puede ser nula");
        int indice;
        indice = ventas.indexOf(venta);
        if (indice == -1) {
            throw new IllegalArgumentException("Venta No existe");

        }
        ventas.set(indice, venta);
    }
    public Venta buscar(int codigo) {
        for (Venta venta : ventas) {
            if (venta.getCodigo() == codigo) {
                return venta;
            }
        }
        return null;
    }
}
