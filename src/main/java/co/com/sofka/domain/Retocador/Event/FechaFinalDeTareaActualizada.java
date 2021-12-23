package co.com.sofka.domain.Retocador.Event;

import co.com.sofka.domain.Generico.FechaFinal;
import co.com.sofka.domain.Retocador.Value.IdTarea;
import co.com.sofka.domain.generic.DomainEvent;

public class FechaFinalDeTareaActualizada extends DomainEvent {
    private final IdTarea idTarea;
    private final FechaFinal fechaFinal;

    public FechaFinalDeTareaActualizada(IdTarea idTarea, FechaFinal fechaFinal) {
        super("sofka.retocador.fechafinaldetareaactualizada");
        this.idTarea = idTarea;
        this.fechaFinal = fechaFinal;
    }

    public IdTarea getIdTarea() {
        return idTarea;
    }

    public FechaFinal getFechaFinal() {
        return fechaFinal;
    }
}
