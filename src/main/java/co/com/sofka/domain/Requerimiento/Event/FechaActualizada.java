package co.com.sofka.domain.Requerimiento.Event;

import co.com.sofka.domain.Generico.Fecha;
import co.com.sofka.domain.generic.DomainEvent;

public class FechaActualizada extends DomainEvent {
    private final Fecha fecha;

    public FechaActualizada(Fecha fecha) {
        super("sofka.requerimiento.fechaactualizada");
        this.fecha = fecha;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
