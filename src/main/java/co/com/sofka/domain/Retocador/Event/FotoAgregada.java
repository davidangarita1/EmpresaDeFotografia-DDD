package co.com.sofka.domain.Retocador.Event;

import co.com.sofka.domain.Retocador.Value.Formato;
import co.com.sofka.domain.Retocador.Value.IdFoto;
import co.com.sofka.domain.Generico.PerfilDeColor;
import co.com.sofka.domain.generic.DomainEvent;

public class FotoAgregada extends DomainEvent {

    private final IdFoto idFoto;
    private final Formato formato;
    private final PerfilDeColor perfilDeColor;

    public FotoAgregada(IdFoto idFoto, Formato formato, PerfilDeColor perfilDeColor) {
        super("sofka.retocador.fotoagregada");
        this.idFoto = idFoto;
        this.formato = formato;
        this.perfilDeColor = perfilDeColor;
    }

    public IdFoto getIdFoto() {
        return idFoto;
    }

    public Formato getFormato() {
        return formato;
    }

    public PerfilDeColor getPerfilDeColor() {
        return perfilDeColor;
    }
}
