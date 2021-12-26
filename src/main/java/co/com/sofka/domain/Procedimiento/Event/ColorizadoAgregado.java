package co.com.sofka.domain.Procedimiento.Event;

import co.com.sofka.domain.Generico.PerfilDeColor;
import co.com.sofka.domain.Procedimiento.Value.Cambios;
import co.com.sofka.domain.Procedimiento.Value.IdColorizado;
import co.com.sofka.domain.generic.DomainEvent;

public class ColorizadoAgregado extends DomainEvent {
    private final IdColorizado idColorizado;
    private final Cambios cambios;
    private final PerfilDeColor perfilDeColor;

    public ColorizadoAgregado(IdColorizado idColorizado, Cambios cambios, PerfilDeColor perfilDeColor) {
        super("sofka.procedimiento.colorizadoagregado");
        this.idColorizado = idColorizado;
        this.cambios = cambios;
        this.perfilDeColor = perfilDeColor;
    }

    public IdColorizado getIdColorizado() {
        return idColorizado;
    }

    public Cambios getCambios() {
        return cambios;
    }

    public PerfilDeColor getPerfilDeColor() {
        return perfilDeColor;
    }
}
