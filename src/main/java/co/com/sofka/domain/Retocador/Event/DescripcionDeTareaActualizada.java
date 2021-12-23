package co.com.sofka.domain.Retocador.Event;

import co.com.sofka.domain.Generico.Descripcion;
import co.com.sofka.domain.Retocador.Value.IdTarea;
import co.com.sofka.domain.generic.DomainEvent;

public class DescripcionDeTareaActualizada extends DomainEvent {
    private final IdTarea idTarea;
    private final Descripcion descripcion;

    public DescripcionDeTareaActualizada(IdTarea idTarea, Descripcion descripcion) {
        super("sofka.retocador.descripciondetareaactualizada");
        this.idTarea = idTarea;
        this.descripcion = descripcion;
    }

    public IdTarea getIdTarea() {
        return idTarea;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
