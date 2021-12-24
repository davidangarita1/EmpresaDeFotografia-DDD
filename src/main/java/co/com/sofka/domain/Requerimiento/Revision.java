package co.com.sofka.domain.Requerimiento;

import co.com.sofka.domain.Generico.Descripcion;
import co.com.sofka.domain.Generico.Fecha;
import co.com.sofka.domain.Requerimiento.Value.IdRevision;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Revision extends Entity<IdRevision> {
    private Fecha fecha;
    private Descripcion descripcion;

    public Revision(IdRevision entityId, Fecha fecha, Descripcion descripcion) {
        super(entityId);
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public void actualizarFecha(Fecha fecha){
        this.fecha = Objects.requireNonNull(fecha);
    }

    public void actualizarDescripcion(Descripcion descripcion){
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    public Fecha fecha() {
        return fecha;
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}
