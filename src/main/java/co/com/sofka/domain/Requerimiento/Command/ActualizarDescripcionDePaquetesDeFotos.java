package co.com.sofka.domain.Requerimiento.Command;

import co.com.sofka.domain.Generico.Descripcion;
import co.com.sofka.domain.Requerimiento.Value.IdPaqueteDeFotos;
import co.com.sofka.domain.Requerimiento.Value.IdRequerimiento;
import co.com.sofka.domain.generic.Command;

public class ActualizarDescripcionDePaquetesDeFotos extends Command {
    private final IdRequerimiento idRequerimiento;
    private final IdPaqueteDeFotos idPaqueteDeFotos;
    private final Descripcion descripcion;

    public ActualizarDescripcionDePaquetesDeFotos(IdRequerimiento idRequerimiento, IdPaqueteDeFotos idPaqueteDeFotos, Descripcion descripcion){
        this.idRequerimiento = idRequerimiento;
        this.idPaqueteDeFotos = idPaqueteDeFotos;
        this.descripcion = descripcion;
    }

    public IdRequerimiento getIdRequerimiento() {
        return idRequerimiento;
    }

    public IdPaqueteDeFotos getIdPaqueteDeFotos() {
        return idPaqueteDeFotos;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
