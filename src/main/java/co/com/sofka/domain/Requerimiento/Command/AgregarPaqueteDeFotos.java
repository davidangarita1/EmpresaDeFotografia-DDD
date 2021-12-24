package co.com.sofka.domain.Requerimiento.Command;

import co.com.sofka.domain.Generico.Descripcion;
import co.com.sofka.domain.Requerimiento.Value.Cantidad;
import co.com.sofka.domain.Requerimiento.Value.IdPaqueteDeFotos;
import co.com.sofka.domain.Requerimiento.Value.IdRequerimiento;
import co.com.sofka.domain.generic.Command;

public class AgregarPaqueteDeFotos extends Command {
    private final IdRequerimiento idRequerimiento;
    private final IdPaqueteDeFotos idPaqueteDeFotos;
    private final Cantidad cantidad;
    private final Descripcion descripcion;

    public AgregarPaqueteDeFotos(IdRequerimiento idRequerimiento, IdPaqueteDeFotos idPaqueteDeFotos, Cantidad cantidad, Descripcion descripcion){
        this.idRequerimiento = idRequerimiento;
        this.idPaqueteDeFotos = idPaqueteDeFotos;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }

    public IdRequerimiento getIdRequerimiento() {
        return idRequerimiento;
    }

    public IdPaqueteDeFotos getIdPaqueteDeFotos() {
        return idPaqueteDeFotos;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
