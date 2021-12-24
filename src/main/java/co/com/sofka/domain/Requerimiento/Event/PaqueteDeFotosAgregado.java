package co.com.sofka.domain.Requerimiento.Event;

import co.com.sofka.domain.Generico.Descripcion;
import co.com.sofka.domain.Requerimiento.Value.Cantidad;
import co.com.sofka.domain.Requerimiento.Value.IdPaqueteDeFotos;
import co.com.sofka.domain.generic.DomainEvent;

public class PaqueteDeFotosAgregado extends DomainEvent {
    private final IdPaqueteDeFotos idPaqueteDeFotos;
    private final Cantidad cantidad;
    private final Descripcion descripcion;

    public PaqueteDeFotosAgregado(IdPaqueteDeFotos idPaqueteDeFotos, Cantidad cantidad, Descripcion descripcion) {
        super("sofka.requerimiento.paquetedefotosagregado");
        this.idPaqueteDeFotos = idPaqueteDeFotos;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
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
