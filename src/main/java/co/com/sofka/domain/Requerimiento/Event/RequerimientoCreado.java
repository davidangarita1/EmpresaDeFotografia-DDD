package co.com.sofka.domain.Requerimiento.Event;

import co.com.sofka.domain.Generico.Fecha;
import co.com.sofka.domain.generic.DomainEvent;

public class RequerimientoCreado extends DomainEvent {
    private final Fecha fecha;

    public RequerimientoCreado(Fecha fecha) {
        super("sofka.requerimiento.requerimientocreado");
        this.fecha = fecha;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
