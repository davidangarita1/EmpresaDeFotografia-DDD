package co.com.sofka.domain.Requerimiento;

import co.com.sofka.domain.Generico.Nombre;
import co.com.sofka.domain.Requerimiento.Value.IdCliente;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Cliente extends Entity<IdCliente> {
    private Nombre nombre;

    public Cliente(IdCliente entityId, Nombre nombre) {
        super(entityId);
        this.nombre = nombre;
    }

    public void actualizarNombre(Nombre nombre){
        this.nombre = Objects.requireNonNull(nombre);
    }

    public Nombre nombre() {
        return nombre;
    }
}
