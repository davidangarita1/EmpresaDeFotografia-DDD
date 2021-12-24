package co.com.sofka.domain.Requerimiento.Command;

import co.com.sofka.domain.Generico.Descripcion;
import co.com.sofka.domain.Requerimiento.Value.IdRequerimiento;
import co.com.sofka.domain.Requerimiento.Value.IdRevision;
import co.com.sofka.domain.generic.Command;

public class ActualizarDescripcionDeRevision extends Command {
    private final IdRequerimiento idRequerimiento;
    private final IdRevision idRevision;
    private final Descripcion descripcion;

    public ActualizarDescripcionDeRevision(IdRequerimiento idRequerimiento, IdRevision idRevision, Descripcion descripcion){
        this.idRequerimiento = idRequerimiento;
        this.idRevision = idRevision;
        this.descripcion = descripcion;
    }

    public IdRequerimiento getIdRequerimiento() {
        return idRequerimiento;
    }

    public IdRevision getIdRevision() {
        return idRevision;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
