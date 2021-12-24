package co.com.sofka.domain.Requerimiento.Event;

import co.com.sofka.domain.Requerimiento.Value.Cantidad;
import co.com.sofka.domain.Requerimiento.Value.IdPaqueteDeFotos;
import co.com.sofka.domain.generic.DomainEvent;

public class CantidadDePaquetesDeFotosActualizada extends DomainEvent {
    private final IdPaqueteDeFotos idPaqueteDeFotos;
    private final Cantidad cantidad;

    public CantidadDePaquetesDeFotosActualizada(IdPaqueteDeFotos idPaqueteDeFotos, Cantidad cantidad) {
        super("sofka.requerimiento.cantidaddepaquetesdefotosactualizada");
        this.idPaqueteDeFotos = idPaqueteDeFotos;
        this.cantidad = cantidad;
    }

    public IdPaqueteDeFotos getIdPaqueteDeFotos() {
        return idPaqueteDeFotos;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }
}
