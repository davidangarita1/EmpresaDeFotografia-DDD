package co.com.sofka.domain.Retocador.Command;

import co.com.sofka.domain.Retocador.Value.Formato;
import co.com.sofka.domain.Retocador.Value.IdFoto;
import co.com.sofka.domain.Retocador.Value.IdRetocador;
import co.com.sofka.domain.generic.Command;

public class ActualizarFormatoDeFoto extends Command {
    private final IdRetocador idRetocador;
    private final IdFoto idFoto;
    private final Formato formato;

    public ActualizarFormatoDeFoto(IdRetocador idRetocador, IdFoto idFoto, Formato formato){
        this.idRetocador = idRetocador;
        this.idFoto = idFoto;
        this.formato = formato;
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
}
