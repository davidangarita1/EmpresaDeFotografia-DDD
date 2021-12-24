package co.com.sofka.domain.Requerimiento.Event;

import co.com.sofka.domain.Generico.Descripcion;
import co.com.sofka.domain.Requerimiento.Value.IdRevision;
import co.com.sofka.domain.generic.DomainEvent;

public class DescripcionDeRevisionActualizada extends DomainEvent {
    private final IdRevision idRevision;
    private final Descripcion descripcion;

    public DescripcionDeRevisionActualizada(IdRevision idRevision, Descripcion descripcion) {
        super("sofka.requerimiento.descripcionderevisionactualizada");
        this.idRevision = idRevision;
        this.descripcion = descripcion;
    }

    public IdRevision getIdRevision() {
        return idRevision;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
