package co.com.sofka.domain.Procedimiento.Command;

import co.com.sofka.domain.Generico.Fecha;
import co.com.sofka.domain.Procedimiento.Value.IdProcedimiento;
import co.com.sofka.domain.generic.Command;

public class ActualizarFecha extends Command {
    private final IdProcedimiento idProcedimiento;
    private final Fecha fecha;

    public ActualizarFecha(IdProcedimiento idProcedimiento, Fecha fecha){
        this.idProcedimiento = idProcedimiento;
        this.fecha = fecha;
    }

    public IdProcedimiento getIdProcedimiento() {
        return idProcedimiento;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
