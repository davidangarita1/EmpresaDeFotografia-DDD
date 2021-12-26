package co.com.sofka.domain.Procedimiento.Command;

import co.com.sofka.domain.Generico.PerfilDeColor;
import co.com.sofka.domain.Procedimiento.Value.Cambios;
import co.com.sofka.domain.Procedimiento.Value.IdColorizado;
import co.com.sofka.domain.Procedimiento.Value.IdProcedimiento;
import co.com.sofka.domain.generic.Command;

public class AgregarColorizado extends Command {
    private final IdProcedimiento idProcedimiento;
    private final IdColorizado idColorizado;
    private final Cambios cambios;
    private final PerfilDeColor perfilDeColor;

    public AgregarColorizado(IdProcedimiento idProcedimiento, IdColorizado idColorizado, Cambios cambios, PerfilDeColor perfilDeColor){
        this.idProcedimiento = idProcedimiento;
        this.idColorizado = idColorizado;
        this.cambios = cambios;
        this.perfilDeColor = perfilDeColor;
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

    public PerfilDeColor getPerfilDeColor() {
        return perfilDeColor;
    }
}
