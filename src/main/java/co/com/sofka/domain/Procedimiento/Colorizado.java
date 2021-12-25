package co.com.sofka.domain.Procedimiento;

import co.com.sofka.domain.Generico.PerfilDeColor;
import co.com.sofka.domain.Procedimiento.Value.Cambios;
import co.com.sofka.domain.Procedimiento.Value.IdColorizado;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Colorizado extends Entity<IdColorizado> {
    private Cambios cambios;
    private PerfilDeColor perfilDeColor;

    public Colorizado(IdColorizado entityId, Cambios cambios, PerfilDeColor perfilDeColor){
        super(entityId);
        this.cambios = cambios;
        this.perfilDeColor = perfilDeColor;
    }

    public void actualizarCambios(Cambios cambios){
        this.cambios = Objects.requireNonNull(cambios);
    }

    public void actualizarPerfilDeColor(PerfilDeColor perfilDeColor){
        this.perfilDeColor = Objects.requireNonNull(perfilDeColor);
    }

    public Cambios cambios() {
        return cambios;
    }

    public PerfilDeColor perfilDeColor() {
        return perfilDeColor;
    }
}
