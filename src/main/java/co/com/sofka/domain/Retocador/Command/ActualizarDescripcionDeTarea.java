package co.com.sofka.domain.Retocador.Command;

import co.com.sofka.domain.Generico.Descripcion;
import co.com.sofka.domain.Retocador.Value.IdRetocador;
import co.com.sofka.domain.Retocador.Value.IdTarea;
import co.com.sofka.domain.generic.Command;

public class ActualizarDescripcionDeTarea extends Command {
    private final IdRetocador idRetocador;
    private final IdTarea idTarea;
    private final Descripcion descripcion;

    public ActualizarDescripcionDeTarea(IdRetocador idRetocador, IdTarea idTarea, Descripcion descripcion){
        this.idRetocador = idRetocador;
        this.idTarea = idTarea;
        this.descripcion = descripcion;
    }

    public IdRetocador getIdRetocador() {
        return idRetocador;
    }

    public IdTarea getIdTarea() {
        return idTarea;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
