package co.com.sofka.domain.Procedimiento.Event;

import co.com.sofka.domain.Procedimiento.Value.Cambios;
import co.com.sofka.domain.Procedimiento.Value.Fondo;
import co.com.sofka.domain.Procedimiento.Value.IdMontaje;
import co.com.sofka.domain.generic.DomainEvent;

public class MontajeAgregado extends DomainEvent {
    private final IdMontaje idMontaje;
    private final Cambios cambios;
    private final Fondo fondo;

    public MontajeAgregado(IdMontaje idMontaje, Cambios cambios, Fondo fondo) {
        super("sofka.procedimiento.montajeagregado");
        this.idMontaje = idMontaje;
        this.cambios = cambios;
        this.fondo = fondo;
    }

    public IdMontaje getIdMontaje() {
        return idMontaje;
    }

    public Cambios getCambios() {
        return cambios;
    }

    public Fondo getFondo() {
        return fondo;
    }
}
