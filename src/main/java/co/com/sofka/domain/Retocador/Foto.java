package co.com.sofka.domain.Retocador;

import co.com.sofka.domain.Retocador.Value.Formato;
import co.com.sofka.domain.Retocador.Value.IdFoto;
import co.com.sofka.domain.Generico.PerfilDeColor;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Foto extends Entity<IdFoto> {

    private Formato formato;
    private PerfilDeColor perfilDeColor;

    public Foto(IdFoto entityId, Formato formato, PerfilDeColor perfilDeColor) {
        super(entityId);
        this.formato = formato;
        this.perfilDeColor = perfilDeColor;
    }

    public void actualizarFormato(Formato formato) {
        this.formato = Objects.requireNonNull(formato);
    }

    public void actualizarPerfilDeColor(PerfilDeColor perfilDeColor) {
        this.perfilDeColor = Objects.requireNonNull(perfilDeColor);
    }

    public Formato formato() {
        return formato;
    }

    public PerfilDeColor perfilDeColor() {
        return perfilDeColor;
    }
}
