package co.com.sofka.domain.Procedimiento.Command;

import co.com.sofka.domain.Procedimiento.Value.Cambios;
import co.com.sofka.domain.Procedimiento.Value.Fondo;
import co.com.sofka.domain.Procedimiento.Value.IdMontaje;
import co.com.sofka.domain.Procedimiento.Value.IdProcedimiento;
import co.com.sofka.domain.generic.Command;

public class AgregarMontaje extends Command {
    private final IdProcedimiento idProcedimiento;
    private final IdMontaje idMontaje;
    private final Cambios cambios;
    private final Fondo fondo;

    public AgregarMontaje(IdProcedimiento idProcedimiento, IdMontaje idMontaje, Cambios cambios, Fondo fondo){
        this.idProcedimiento = idProcedimiento;
        this.idMontaje = idMontaje;
        this.cambios = cambios;
        this.fondo = fondo;
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

    public Fondo getFondo() {
        return fondo;
    }
}
