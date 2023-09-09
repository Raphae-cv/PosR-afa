/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Cliente;
/**
 *
 * @author Usuario
 */
public class ClienteDAO {
    private static ObservableList<Cliente> clientes
            = FXCollections.observableArrayList();
    
    public ClienteDAO(){
        
    }
    
    public static ObservableList<Cliente> getclientes() {
        return clientes;
    }

    public static void setclientes(ObservableList<Cliente> aclientes) {
        clientes = aclientes;
    }
    
    public void agregar (Cliente cliente){
        Objects.requireNonNull(cliente, "cliente no puede ser nulo");
        clientes.add(cliente);
    }
    
    public void eliminar (Cliente cliente){
        Objects.requireNonNull(cliente, "cliente no puede ser nulo");
        clientes.remove(cliente);
    }
    
    public void actualizar(Cliente cliente){
        Objects.requireNonNull(cliente, "cliente no puede ser nulo");
        int indice;
        indice = clientes.indexOf(cliente);
        if (indice == -1){
            throw new IllegalArgumentException("cliente no existe");
        }
        clientes.set(indice, cliente);
    }
    
    public Cliente buscar(String identificacion){
        for(Cliente cliente : clientes){
            if (cliente.getIdentificacion().equalsIgnoreCase(identificacion)){
                return cliente;
            }
        }
        return null;
    }
}
