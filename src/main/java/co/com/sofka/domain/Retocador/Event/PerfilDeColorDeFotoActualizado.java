package co.com.sofka.domain.Retocador.Event;

import co.com.sofka.domain.Retocador.Value.IdFoto;
import co.com.sofka.domain.Retocador.Value.PerfilDeColor;
import co.com.sofka.domain.generic.DomainEvent;

public class PerfilDeColorDeFotoActualizado extends DomainEvent {
    private final IdFoto idFoto;
    private final PerfilDeColor perfilDeColor;

    public PerfilDeColorDeFotoActualizado(IdFoto idFoto, PerfilDeColor perfilDeColor) {
        super("sofka.retocador.perfildecolordefotoactualizado");
        this.idFoto = idFoto;
        this.perfilDeColor = perfilDeColor;
    }

    public IdFoto getIdFoto() {
        return idFoto;
    }

    public PerfilDeColor getPerfilDeColor() {
        return perfilDeColor;
    }
}
