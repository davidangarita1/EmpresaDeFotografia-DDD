package co.com.sofka.domain.Procedimiento.Event;

import co.com.sofka.domain.Generico.PerfilDeColor;
import co.com.sofka.domain.Procedimiento.Value.IdColorizado;
import co.com.sofka.domain.generic.DomainEvent;

public class PerfilDeColorDeColorizadoActualizado extends DomainEvent {
    private final IdColorizado idColorizado;
    private final PerfilDeColor perfilDeColor;

    public PerfilDeColorDeColorizadoActualizado(IdColorizado idColorizado, PerfilDeColor perfilDeColor) {
        super("sofka.procedimiento.perfildecolordecolorizadoactualizado");
        this.idColorizado = idColorizado;
        this.perfilDeColor = perfilDeColor;
    }

    public IdColorizado getIdColorizado() {
        return idColorizado;
    }

    public PerfilDeColor getPerfilDeColor() {
        return perfilDeColor;
    }
}
