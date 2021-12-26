package co.com.sofka.domain.Procedimiento.Event;

import co.com.sofka.domain.Procedimiento.Value.Fondo;
import co.com.sofka.domain.Procedimiento.Value.IdMontaje;
import co.com.sofka.domain.generic.DomainEvent;

public class FondoDeMontajeActualizado extends DomainEvent {
    private final IdMontaje idMontaje;
    private final Fondo fondo;

    public FondoDeMontajeActualizado(IdMontaje idMontaje, Fondo fondo) {
        super("sofka.procedimiento.fondodemontajeactualizado");
        this.idMontaje = idMontaje;
        this.fondo = fondo;
    }

    public IdMontaje getIdMontaje() {
        return idMontaje;
    }

    public Fondo getFondo() {
        return fondo;
    }
}
