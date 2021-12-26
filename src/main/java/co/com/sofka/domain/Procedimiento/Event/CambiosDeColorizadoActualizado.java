package co.com.sofka.domain.Procedimiento.Event;

import co.com.sofka.domain.Procedimiento.Value.Cambios;
import co.com.sofka.domain.Procedimiento.Value.IdColorizado;
import co.com.sofka.domain.generic.DomainEvent;

public class CambiosDeColorizadoActualizado extends DomainEvent {
    private final IdColorizado idColorizado;
    private final Cambios cambios;

    public CambiosDeColorizadoActualizado(IdColorizado idColorizado, Cambios cambios) {
        super("sofka.procedimiento.cambiosdecolorizadoactualizado");
        this.idColorizado = idColorizado;
        this.cambios = cambios;
    }

    public IdColorizado getIdColorizado() {
        return idColorizado;
    }

    public Cambios getCambios() {
        return cambios;
    }
}
