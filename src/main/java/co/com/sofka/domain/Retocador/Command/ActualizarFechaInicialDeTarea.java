package co.com.sofka.domain.Retocador.Command;

import co.com.sofka.domain.Generico.FechaInicial;
import co.com.sofka.domain.Retocador.Value.IdRetocador;
import co.com.sofka.domain.Retocador.Value.IdTarea;
import co.com.sofka.domain.generic.Command;

public class ActualizarFechaInicialDeTarea extends Command {
    private final IdRetocador idRetocador;
    private final IdTarea idTarea;
    private final FechaInicial fechaInicial;

    public ActualizarFechaInicialDeTarea(IdRetocador idRetocador, IdTarea idTarea, FechaInicial fechaInicial){
        this.idRetocador = idRetocador;
        this.idTarea = idTarea;
        this.fechaInicial = fechaInicial;
    }

    public IdRetocador getIdRetocador() {
        return idRetocador;
    }

    public IdTarea getIdTarea() {
        return idTarea;
    }

    public FechaInicial getFechaInicial() {
        return fechaInicial;
    }
}
