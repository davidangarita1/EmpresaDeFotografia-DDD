package co.com.sofka.domain.Retocador.Command;

import co.com.sofka.domain.Generico.Descripcion;
import co.com.sofka.domain.Retocador.Value.IdFuncion;
import co.com.sofka.domain.Retocador.Value.IdRetocador;
import co.com.sofka.domain.generic.Command;

public class ActualizarDescripcionDeFuncion extends Command {
    private final IdRetocador idRetocador;
    private final IdFuncion idFuncion;
    private final Descripcion descripcion;

    public ActualizarDescripcionDeFuncion(IdRetocador idRetocador, IdFuncion idFuncion, Descripcion descripcion){
        this.idRetocador = idRetocador;
        this.idFuncion = idFuncion;
        this.descripcion = descripcion;
    }

    public IdRetocador getIdRetocador() {
        return idRetocador;
    }

    public IdFuncion getIdFuncion() {
        return idFuncion;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
