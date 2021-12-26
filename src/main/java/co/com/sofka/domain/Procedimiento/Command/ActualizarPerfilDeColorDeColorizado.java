package co.com.sofka.domain.Procedimiento.Command;

import co.com.sofka.domain.Generico.PerfilDeColor;
import co.com.sofka.domain.Procedimiento.Value.IdColorizado;
import co.com.sofka.domain.Procedimiento.Value.IdProcedimiento;
import co.com.sofka.domain.generic.Command;

public class ActualizarPerfilDeColorDeColorizado extends Command {
    private final IdProcedimiento idProcedimiento;
    private final IdColorizado idColorizado;
    private final PerfilDeColor perfilDeColor;

    public ActualizarPerfilDeColorDeColorizado(IdProcedimiento idProcedimiento, IdColorizado idColorizado, PerfilDeColor perfilDeColor){
        this.idProcedimiento = idProcedimiento;
        this.idColorizado = idColorizado;
        this.perfilDeColor = perfilDeColor;
    }

    public IdProcedimiento getIdProcedimiento() {
        return idProcedimiento;
    }

    public IdColorizado getIdColorizado() {
        return idColorizado;
    }

    public PerfilDeColor getPerfilDeColor() {
        return perfilDeColor;
    }
}
