package co.com.sofka.domain.Procedimiento.Command;

import co.com.sofka.domain.Procedimiento.Value.Cambios;
import co.com.sofka.domain.Procedimiento.Value.IdProcedimiento;
import co.com.sofka.domain.Procedimiento.Value.IdRetoque;
import co.com.sofka.domain.generic.Command;

public class ActualizarCambiosDeRetoque extends Command {
    private final IdProcedimiento idProcedimiento;
    private final IdRetoque idRetoque;
    private final Cambios cambios;

    public ActualizarCambiosDeRetoque(IdProcedimiento idProcedimiento, IdRetoque idRetoque, Cambios cambios){
        this.idProcedimiento = idProcedimiento;
        this.idRetoque = idRetoque;
        this.cambios = cambios;
    }

    public IdProcedimiento getIdProcedimiento() {
        return idProcedimiento;
    }

    public IdRetoque getIdRetoque() {
        return idRetoque;
    }

    public Cambios getCambios() {
        return cambios;
    }
}
