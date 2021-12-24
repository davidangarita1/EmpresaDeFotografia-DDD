package co.com.sofka.domain.Requerimiento.Command;

import co.com.sofka.domain.Generico.Descripcion;
import co.com.sofka.domain.Generico.Fecha;
import co.com.sofka.domain.Requerimiento.Value.IdRequerimiento;
import co.com.sofka.domain.Requerimiento.Value.IdRevision;
import co.com.sofka.domain.generic.Command;

public class AgregarRevision extends Command {
    private final IdRequerimiento idRequerimiento;
    private final IdRevision idRevision;
    private final Fecha fecha;
    private final Descripcion descripcion;

    public AgregarRevision(IdRequerimiento idRequerimiento, IdRevision idRevision, Fecha fecha, Descripcion descripcion){
        this.idRequerimiento = idRequerimiento;
        this.idRevision = idRevision;
        this.fecha = fecha;
        this.descripcion = descripcion;
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

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
