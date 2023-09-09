/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Producto;
/**
 *
 * @author Usuario
 */
public class ProductoDAO {
    private static ObservableList<Producto> productos 
            = FXCollections.observableArrayList();

    public ProductoDAO(){
        
    }
    
    public static ObservableList<Producto> getProductos() {
        return productos;
    }

    public static void setProductos(ObservableList<Producto> aProductos) {
        productos = aProductos;
    }
    
    public void agregar (Producto producto){
        Objects.requireNonNull(producto, "Producto no puede ser nulo");
        productos.add(producto);
    }
    
    public void eliminar (Producto producto){
        Objects.requireNonNull(producto, "Producto no puede ser nulo");
        productos.remove(producto);
    }
    
    public void actualizar(Producto producto){
        Objects.requireNonNull(producto, "Producto no puede ser nulo");
        int indice;
        indice = productos.indexOf(producto);
        if (indice == -1){
            throw new IllegalArgumentException("Producto no existe");
        }
        productos.set(indice, producto);
    }
    
    public Producto buscar(int codigo){
        for(Producto producto : productos){
            if (producto.getCodigo()== codigo){
                return producto;
            }
        }
        return null;
    }
    
}
