package co.com.sofka.domain.Procedimiento.Event;

import co.com.sofka.domain.Generico.Fecha;
import co.com.sofka.domain.generic.DomainEvent;

public class ProcedimientoCreado extends DomainEvent {
    private final Fecha fecha;

    public ProcedimientoCreado(Fecha fecha) {
        super("sofka.procedimiento.procedimientocreado");
        this.fecha = fecha;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
