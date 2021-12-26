package co.com.sofka.domain.Procedimiento.Command;

import co.com.sofka.domain.Procedimiento.Value.Fondo;
import co.com.sofka.domain.Procedimiento.Value.IdMontaje;
import co.com.sofka.domain.Procedimiento.Value.IdProcedimiento;
import co.com.sofka.domain.generic.Command;

public class ActualizarFondoDeMontaje extends Command {
    private final IdProcedimiento idProcedimiento;
    private final IdMontaje idMontaje;
    private final Fondo fondo;

    public ActualizarFondoDeMontaje(IdProcedimiento idProcedimiento, IdMontaje idMontaje, Fondo fondo){
        this.idProcedimiento = idProcedimiento;
        this.idMontaje = idMontaje;
        this.fondo = fondo;
    }

    public IdProcedimiento getIdProcedimiento() {
        return idProcedimiento;
    }

    public IdMontaje getIdMontaje() {
        return idMontaje;
    }

    public Fondo getFondo() {
        return fondo;
    }
}
