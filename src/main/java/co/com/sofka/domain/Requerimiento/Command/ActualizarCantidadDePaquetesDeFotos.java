package co.com.sofka.domain.Requerimiento.Command;

import co.com.sofka.domain.Requerimiento.Value.Cantidad;
import co.com.sofka.domain.Requerimiento.Value.IdPaqueteDeFotos;
import co.com.sofka.domain.Requerimiento.Value.IdRequerimiento;
import co.com.sofka.domain.generic.Command;

public class ActualizarCantidadDePaquetesDeFotos extends Command {
    private final IdRequerimiento idRequerimiento;
    private final IdPaqueteDeFotos idPaqueteDeFotos;
    private final Cantidad cantidad;

    public ActualizarCantidadDePaquetesDeFotos(IdRequerimiento idRequerimiento, IdPaqueteDeFotos idPaqueteDeFotos, Cantidad cantidad){
        this.idRequerimiento = idRequerimiento;
        this.idPaqueteDeFotos = idPaqueteDeFotos;
        this.cantidad = cantidad;
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
}
