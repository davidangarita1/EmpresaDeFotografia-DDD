package co.com.sofka.domain.Procedimiento.Command;

import co.com.sofka.domain.Procedimiento.Value.*;
import co.com.sofka.domain.generic.Command;

public class AgregarRetoque extends Command {
    private final IdProcedimiento idProcedimiento;
    private final IdRetoque idRetoque;
    private final Cambios cambios;
    private final Capas capas;
    private final Filtros filtros;

    public AgregarRetoque(IdProcedimiento idProcedimiento, IdRetoque idRetoque, Cambios cambios, Capas capas, Filtros filtros){
        this.idProcedimiento = idProcedimiento;
        this.idRetoque = idRetoque;
        this.cambios = cambios;
        this.capas = capas;
        this.filtros = filtros;
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

    public Capas getCapas() {
        return capas;
    }

    public Filtros getFiltros() {
        return filtros;
    }
}
