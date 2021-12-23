package co.com.sofka.domain.Retocador.Event;

import co.com.sofka.domain.Generico.FechaInicial;
import co.com.sofka.domain.Retocador.Value.IdTarea;
import co.com.sofka.domain.generic.DomainEvent;

public class FechaInicialDeTareaActualiada extends DomainEvent {
    private final IdTarea idTarea;
    private final FechaInicial fechaInicial;

    public FechaInicialDeTareaActualiada(IdTarea idTarea, FechaInicial fechaInicial) {
        super("sofka.retocador.fechainicialdetareaactualizada");
        this.idTarea = idTarea;
        this.fechaInicial = fechaInicial;
    }

    public IdTarea getIdTarea() {
        return idTarea;
    }

    public FechaInicial getFechaInicial() {
        return fechaInicial;
    }
}
