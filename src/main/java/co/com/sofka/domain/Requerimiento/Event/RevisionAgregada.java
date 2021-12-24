package co.com.sofka.domain.Requerimiento.Event;

import co.com.sofka.domain.Generico.Descripcion;
import co.com.sofka.domain.Generico.Fecha;
import co.com.sofka.domain.Requerimiento.Value.IdRevision;
import co.com.sofka.domain.generic.DomainEvent;

public class RevisionAgregada extends DomainEvent {
    private final IdRevision idRevision;
    private final Fecha fecha;
    private final Descripcion descripcion;

    public RevisionAgregada(IdRevision idRevision, Fecha fecha, Descripcion descripcion) {
        super("sofka.requerimiento.revisionagregada");
        this.idRevision = idRevision;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public IdRevision getIdRevision() {
        return idRevision;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
