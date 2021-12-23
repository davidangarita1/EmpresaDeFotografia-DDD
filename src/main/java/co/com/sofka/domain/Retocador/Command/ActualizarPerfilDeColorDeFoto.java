package co.com.sofka.domain.Retocador.Command;

import co.com.sofka.domain.Retocador.Value.IdFoto;
import co.com.sofka.domain.Retocador.Value.IdRetocador;
import co.com.sofka.domain.Retocador.Value.PerfilDeColor;
import co.com.sofka.domain.generic.Command;

public class ActualizarPerfilDeColorDeFoto extends Command {
    private final IdRetocador idRetocador;
    private final IdFoto idFoto;
    private final PerfilDeColor perfilDeColor;

    public ActualizarPerfilDeColorDeFoto(IdRetocador idRetocador, IdFoto idFoto, PerfilDeColor perfilDeColor){
        this.idRetocador = idRetocador;
        this.idFoto = idFoto;
        this.perfilDeColor = perfilDeColor;
    }

    public IdRetocador getIdRetocador() {
        return idRetocador;
    }

    public IdFoto getIdFoto() {
        return idFoto;
    }

    public PerfilDeColor getPerfilDeColor() {
        return perfilDeColor;
    }
}
