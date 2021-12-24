package co.com.sofka.domain.Requerimiento.Command;

import co.com.sofka.domain.Generico.Fecha;
import co.com.sofka.domain.Requerimiento.Value.IdRequerimiento;
import co.com.sofka.domain.Requerimiento.Value.IdRevision;
import co.com.sofka.domain.generic.Command;

public class ActualizarFechaDeRevision extends Command {
    private final IdRequerimiento idRequerimiento;
    private final IdRevision idRevision;
    private final Fecha fecha;

    public ActualizarFechaDeRevision(IdRequerimiento idRequerimiento, IdRevision idRevision, Fecha fecha){
        this.idRequerimiento = idRequerimiento;
        this.idRevision = idRevision;
        this.fecha = fecha;
    }

    public IdRequerimiento getIdRequerimiento() {
        return idRequerimiento;
    }

    public IdRevision getIdRevision() {
        return idRevision;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
