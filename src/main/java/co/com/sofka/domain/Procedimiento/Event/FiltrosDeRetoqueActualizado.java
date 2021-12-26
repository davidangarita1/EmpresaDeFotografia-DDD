package co.com.sofka.domain.Procedimiento.Event;

import co.com.sofka.domain.Procedimiento.Value.Filtros;
import co.com.sofka.domain.Procedimiento.Value.IdRetoque;
import co.com.sofka.domain.generic.DomainEvent;

public class FiltrosDeRetoqueActualizado extends DomainEvent {
    private final IdRetoque idRetoque;
    private final Filtros filtros;

    public FiltrosDeRetoqueActualizado(IdRetoque idRetoque, Filtros filtros) {
        super("sofka.procedimiento.filtrosderetoqueactualizado");
        this.idRetoque = idRetoque;
        this.filtros = filtros;
    }

    public IdRetoque getIdRetoque() {
        return idRetoque;
    }

    public Filtros getFiltros() {
        return filtros;
    }
}
