package co.com.sofka.domain.Procedimiento.Event;

import co.com.sofka.domain.Procedimiento.Value.Cambios;
import co.com.sofka.domain.Procedimiento.Value.Capas;
import co.com.sofka.domain.Procedimiento.Value.Filtros;
import co.com.sofka.domain.Procedimiento.Value.IdRetoque;
import co.com.sofka.domain.generic.DomainEvent;

public class RetoqueAgregado extends DomainEvent {
    private final IdRetoque idRetoque;
    private final Cambios cambios;
    private final Capas capas;
    private final Filtros filtros;

    public RetoqueAgregado(IdRetoque idRetoque, Cambios cambios, Capas capas, Filtros filtros) {
        super("sofka.procedimiento.retoqueagregado");
        this.idRetoque = idRetoque;
        this.cambios = cambios;
        this.capas = capas;
        this.filtros = filtros;
    }

    public IdRetoque getIdRetoque() {
        return idRetoque;
    }

    public Cambios getCambios() {
        return cambios;
    }

    public Capas getCapas() {
        return capas;
    }

    public Filtros getFiltros() {
        return filtros;
    }
}
