package co.com.sofka.domain.Retocador.Event;

import co.com.sofka.domain.Generico.Descripcion;
import co.com.sofka.domain.Retocador.Value.IdFuncion;
import co.com.sofka.domain.generic.DomainEvent;

public class DescripcionDeFuncionActualizada extends DomainEvent {
    private final IdFuncion idFuncion;
    private final Descripcion descripcion;

    public DescripcionDeFuncionActualizada(IdFuncion idFuncion, Descripcion descripcion) {
        super("sofka.retocador.descripciondefuncionactualizada");
        this.idFuncion = idFuncion;
        this.descripcion = descripcion;
    }

    public IdFuncion getIdFuncion() {
        return idFuncion;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
