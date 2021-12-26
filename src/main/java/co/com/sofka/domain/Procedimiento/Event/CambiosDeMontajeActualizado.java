package co.com.sofka.domain.Procedimiento.Event;

import co.com.sofka.domain.Procedimiento.Value.Cambios;
import co.com.sofka.domain.Procedimiento.Value.IdMontaje;
import co.com.sofka.domain.generic.DomainEvent;

public class CambiosDeMontajeActualizado extends DomainEvent {
    private final IdMontaje idMontaje;
    private final Cambios cambios;

    public CambiosDeMontajeActualizado(IdMontaje idMontaje, Cambios cambios) {
        super("sofka.procedimiento.cambiosdemontajeactualizadp");
        this.idMontaje = idMontaje;
        this.cambios = cambios;
    }

    public IdMontaje getIdMontaje() {
        return idMontaje;
    }

    public Cambios getCambios() {
        return cambios;
    }
}
