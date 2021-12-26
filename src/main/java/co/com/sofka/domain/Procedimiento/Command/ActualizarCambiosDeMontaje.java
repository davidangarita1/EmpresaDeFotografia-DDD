package co.com.sofka.domain.Procedimiento.Command;

import co.com.sofka.domain.Procedimiento.Value.Cambios;
import co.com.sofka.domain.Procedimiento.Value.IdMontaje;
import co.com.sofka.domain.Procedimiento.Value.IdProcedimiento;
import co.com.sofka.domain.generic.Command;

public class ActualizarCambiosDeMontaje extends Command {
    private final IdProcedimiento idProcedimiento;
    private final IdMontaje idMontaje;
    private final Cambios cambios;

    public ActualizarCambiosDeMontaje(IdProcedimiento idProcedimiento, IdMontaje idMontaje, Cambios cambios){
        this.idProcedimiento = idProcedimiento;
        this.idMontaje = idMontaje;
        this.cambios = cambios;
    }

    public IdProcedimiento getIdProcedimiento() {
        return idProcedimiento;
    }

    public IdMontaje getIdMontaje() {
        return idMontaje;
    }

    public Cambios getCambios() {
        return cambios;
    }
}
