package co.com.sofka.domain.Requerimiento.Command;

import co.com.sofka.domain.Generico.Nombre;
import co.com.sofka.domain.Requerimiento.Value.IdCliente;
import co.com.sofka.domain.Requerimiento.Value.IdRequerimiento;
import co.com.sofka.domain.generic.Command;

public class AgregarCliente extends Command {
    private final IdRequerimiento idRequerimiento;
    private final IdCliente idCliente;
    private final Nombre nombre;

    public AgregarCliente(IdRequerimiento idRequerimiento, IdCliente idCliente, Nombre nombre){
        this.idRequerimiento = idRequerimiento;
        this.idCliente = idCliente;
        this.nombre = nombre;
    }

    public IdRequerimiento getIdRequerimiento() {
        return idRequerimiento;
    }

    public IdCliente getIdCliente() {
        return idCliente;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
