package co.com.sofka.domain.Retocador.Event;

import co.com.sofka.domain.Generico.Descripcion;
import co.com.sofka.domain.Generico.FechaFinal;
import co.com.sofka.domain.Generico.FechaInicial;
import co.com.sofka.domain.Retocador.Value.IdTarea;
import co.com.sofka.domain.generic.DomainEvent;

public class TareaAgregada extends DomainEvent {
    private final IdTarea idTarea;
    private final FechaInicial fechaInicial;
    private final FechaFinal fechaFinal;
    private final Descripcion descripcion;

    public TareaAgregada(IdTarea idTarea, FechaInicial fechaInicial, FechaFinal fechaFinal, Descripcion descripcion) {
        super("sofka.retocador.tareaagregada");
        this.idTarea = idTarea;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.descripcion = descripcion;
    }

    public IdTarea getIdTarea() {
        return idTarea;
    }

    public FechaInicial getFechaInicial() {
        return fechaInicial;
    }

    public FechaFinal getFechaFinal() {
        return fechaFinal;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
