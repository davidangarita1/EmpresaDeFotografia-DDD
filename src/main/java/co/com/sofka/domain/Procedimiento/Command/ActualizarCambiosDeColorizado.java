package co.com.sofka.domain.Procedimiento.Command;

import co.com.sofka.domain.Procedimiento.Value.Cambios;
import co.com.sofka.domain.Procedimiento.Value.IdColorizado;
import co.com.sofka.domain.Procedimiento.Value.IdProcedimiento;
import co.com.sofka.domain.generic.Command;

public class ActualizarCambiosDeColorizado extends Command {
    private final IdProcedimiento idProcedimiento;
    private final IdColorizado idColorizado;
    private final Cambios cambios;

    public ActualizarCambiosDeColorizado(IdProcedimiento idProcedimiento, IdColorizado idColorizado, Cambios cambios){
        this.idProcedimiento = idProcedimiento;
        this.idColorizado = idColorizado;
        this.cambios = cambios;
    }

    public IdProcedimiento getIdProcedimiento() {
        return idProcedimiento;
    }

    public IdColorizado getIdColorizado() {
        return idColorizado;
    }

    public Cambios getCambios() {
        return cambios;
    }
}
