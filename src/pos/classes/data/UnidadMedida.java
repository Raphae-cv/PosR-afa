package data;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UnidadMedida {

    private static int consecutivo = 0;
    private IntegerProperty codigo = new SimpleIntegerProperty();
    private StringProperty nombre = new SimpleStringProperty();

    public UnidadMedida(int codigo, String nombre) {
        setCodigo(codigo);
        setNombre(nombre);
    }

    public UnidadMedida() {
        this(0, "SIN DEFINIR");
    }

    public UnidadMedida(String nombre) {
        this(consecutivo++, nombre);
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

    public IntegerProperty codigoProperty() {
        return codigo;
    }

    public StringProperty nombProperty() {
        return nombre;
    }

}
