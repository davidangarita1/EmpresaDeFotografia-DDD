package co.com.sofka.domain.Requerimiento.Event;

import co.com.sofka.domain.Generico.Fecha;
import co.com.sofka.domain.Requerimiento.Value.IdRevision;
import co.com.sofka.domain.generic.DomainEvent;

public class FechaDeRevisionActualizada extends DomainEvent {
    private final IdRevision idRevision;
    private final Fecha fecha;

    public FechaDeRevisionActualizada(IdRevision idRevision, Fecha fecha) {
        super("sofka.requerimiento.fechaderevisionactualizada");
        this.idRevision = idRevision;
        this.fecha = fecha;
    }

    public IdRevision getIdRevision() {
        return idRevision;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
