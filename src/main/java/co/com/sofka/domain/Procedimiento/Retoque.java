package co.com.sofka.domain.Procedimiento;

import co.com.sofka.domain.Procedimiento.Value.Cambios;
import co.com.sofka.domain.Procedimiento.Value.Capas;
import co.com.sofka.domain.Procedimiento.Value.Filtros;
import co.com.sofka.domain.Procedimiento.Value.IdRetoque;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Retoque extends Entity<IdRetoque> {
    private Cambios cambios;
    private Capas capas;
    private Filtros filtros;

    public Retoque(IdRetoque entityId, Cambios cambios, Capas capas, Filtros filtros) {
        super(entityId);
        this.cambios = cambios;
        this.capas = capas;
        this.filtros = filtros;
    }

    public void actualizarCambios(Cambios cambios){
        this.cambios = Objects.requireNonNull(cambios);
    }

    public void actualizarCapas(Capas capas){
        this.capas = Objects.requireNonNull(capas);
    }

    public void actualizarFiltros(Filtros filtros){
        this.filtros = Objects.requireNonNull(filtros);
    }

    public Cambios cambios() {
        return cambios;
    }

    public Capas capas() {
        return capas;
    }

    public Filtros filtros() {
        return filtros;
    }
}
