package co.com.sofka.domain.Procedimiento.Event;

import co.com.sofka.domain.Procedimiento.Value.Capas;
import co.com.sofka.domain.Procedimiento.Value.IdRetoque;
import co.com.sofka.domain.generic.DomainEvent;

public class CapasDeRetoqueActualizado extends DomainEvent {
    private final IdRetoque idRetoque;
    private final Capas capas;

    public CapasDeRetoqueActualizado(IdRetoque idRetoque, Capas capas) {
        super("sofka.procedimiento.capasderetoqueactualziado");
        this.idRetoque = idRetoque;
        this.capas = capas;
    }

    public IdRetoque getIdRetoque() {
        return idRetoque;
    }

    public Capas getCapas() {
        return capas;
    }
}
