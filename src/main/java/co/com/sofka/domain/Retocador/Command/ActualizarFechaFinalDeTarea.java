package co.com.sofka.domain.Retocador.Command;

import co.com.sofka.domain.Generico.FechaFinal;
import co.com.sofka.domain.Retocador.Value.IdRetocador;
import co.com.sofka.domain.Retocador.Value.IdTarea;
import co.com.sofka.domain.generic.Command;

public class ActualizarFechaFinalDeTarea extends Command {
    private final IdRetocador idRetocador;
    private final IdTarea idTarea;
    private final FechaFinal fechaFinal;

    public ActualizarFechaFinalDeTarea(IdRetocador idRetocador, IdTarea idTarea, FechaFinal fechaFinal){
        this.idRetocador = idRetocador;
        this.idTarea = idTarea;
        this.fechaFinal = fechaFinal;
    }

    public IdRetocador getIdRetocador() {
        return idRetocador;
    }

    public IdTarea getIdTarea() {
        return idTarea;
    }

    public FechaFinal getFechaFinal() {
        return fechaFinal;
    }
}
