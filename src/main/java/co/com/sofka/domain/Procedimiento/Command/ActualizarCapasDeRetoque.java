package co.com.sofka.domain.Procedimiento.Command;

import co.com.sofka.domain.Procedimiento.Value.Capas;
import co.com.sofka.domain.Procedimiento.Value.IdProcedimiento;
import co.com.sofka.domain.Procedimiento.Value.IdRetoque;
import co.com.sofka.domain.generic.Command;

public class ActualizarCapasDeRetoque extends Command {
    private final IdProcedimiento idProcedimiento;
    private final IdRetoque idRetoque;
    private final Capas capas;

    public ActualizarCapasDeRetoque(IdProcedimiento idProcedimiento, IdRetoque idRetoque, Capas capas){
        this.idProcedimiento = idProcedimiento;
        this.idRetoque = idRetoque;
        this.capas = capas;
    }

    public IdProcedimiento getIdProcedimiento() {
        return idProcedimiento;
    }

    public IdRetoque getIdRetoque() {
        return idRetoque;
    }

    public Capas getCapas() {
        return capas;
    }
}
