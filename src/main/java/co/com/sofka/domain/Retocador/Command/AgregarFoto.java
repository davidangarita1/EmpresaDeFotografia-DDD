package co.com.sofka.domain.Retocador.Command;

import co.com.sofka.domain.Retocador.Value.Formato;
import co.com.sofka.domain.Retocador.Value.IdFoto;
import co.com.sofka.domain.Retocador.Value.IdRetocador;
import co.com.sofka.domain.Retocador.Value.PerfilDeColor;
import co.com.sofka.domain.generic.Command;

public class AgregarFoto extends Command {
    private final IdRetocador idRetocador;
    private final IdFoto idFoto;
    private final Formato formato;
    private final PerfilDeColor perfilDeColor;

    public AgregarFoto(IdRetocador idRetocador, IdFoto idFoto, Formato formato, PerfilDeColor perfilDeColor){
        this.idRetocador = idRetocador;
        this.idFoto = idFoto;
        this.formato = formato;
        this.perfilDeColor = perfilDeColor;
    }

    public IdRetocador getIdRetocador() {
        return idRetocador;
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
