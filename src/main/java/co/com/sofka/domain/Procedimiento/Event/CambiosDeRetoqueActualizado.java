package co.com.sofka.domain.Procedimiento.Event;

import co.com.sofka.domain.Procedimiento.Value.Cambios;
import co.com.sofka.domain.Procedimiento.Value.IdRetoque;
import co.com.sofka.domain.generic.DomainEvent;

public class CambiosDeRetoqueActualizado extends DomainEvent {
    private final IdRetoque idRetoque;
    private final Cambios cambios;

    public CambiosDeRetoqueActualizado(IdRetoque idRetoque, Cambios cambios) {
        super("sofka.procedimiento.cambiosderetoqueactualizado");
        this.idRetoque = idRetoque;
        this.cambios = cambios;
    }

    public IdRetoque getIdRetoque() {
        return idRetoque;
    }

    public Cambios getCambios() {
        return cambios;
    }
}
