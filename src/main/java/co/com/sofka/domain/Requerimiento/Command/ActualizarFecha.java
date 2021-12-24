package co.com.sofka.domain.Requerimiento.Command;

import co.com.sofka.domain.Generico.Fecha;
import co.com.sofka.domain.Requerimiento.Value.IdRequerimiento;
import co.com.sofka.domain.generic.Command;

public class ActualizarFecha extends Command {
    private final IdRequerimiento idRequerimiento;
    private final Fecha fecha;

    public ActualizarFecha(IdRequerimiento idRequerimiento, Fecha fecha){
        this.idRequerimiento = idRequerimiento;
        this.fecha = fecha;
    }

    public IdRequerimiento getIdRequerimiento() {
        return idRequerimiento;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
