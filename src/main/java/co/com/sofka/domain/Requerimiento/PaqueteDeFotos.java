package co.com.sofka.domain.Requerimiento;

import co.com.sofka.domain.Generico.Descripcion;
import co.com.sofka.domain.Requerimiento.Value.Cantidad;
import co.com.sofka.domain.Requerimiento.Value.IdPaqueteDeFotos;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class PaqueteDeFotos extends Entity<IdPaqueteDeFotos> {
    private Cantidad cantidad;
    private Descripcion descripcion;

    public PaqueteDeFotos(IdPaqueteDeFotos entityId, Cantidad cantidad, Descripcion descripcion) {
        super(entityId);
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }

    public void actualizarCantidad(Cantidad cantidad) {
        this.cantidad = Objects.requireNonNull(cantidad);
    }

    public void actualizarDescripcion(Descripcion descripcion) {
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    public Cantidad cantidad() {
        return cantidad;
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}
