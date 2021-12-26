package co.com.sofka.domain.Procedimiento.Command;

import co.com.sofka.domain.Procedimiento.Value.Filtros;
import co.com.sofka.domain.Procedimiento.Value.IdProcedimiento;
import co.com.sofka.domain.Procedimiento.Value.IdRetoque;
import co.com.sofka.domain.generic.Command;

public class ActualizarFiltrosDeRetoque extends Command {
    private final IdProcedimiento idProcedimiento;
    private final IdRetoque idRetoque;
    private final Filtros filtros;

    public ActualizarFiltrosDeRetoque(IdProcedimiento idProcedimiento, IdRetoque idRetoque, Filtros filtros){
        this.idProcedimiento = idProcedimiento;
        this.idRetoque = idRetoque;
        this.filtros = filtros;
    }

    public IdProcedimiento getIdProcedimiento() {
        return idProcedimiento;
    }

    public IdRetoque getIdRetoque() {
        return idRetoque;
    }

    public Filtros getFiltros() {
        return filtros;
    }
}
