package co.com.sofka.domain.Requerimiento.Event;

import co.com.sofka.domain.Generico.Nombre;
import co.com.sofka.domain.Requerimiento.Value.IdCliente;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreDeClienteActualizado extends DomainEvent {
    private final IdCliente idCliente;
    private final Nombre nombre;

    public NombreDeClienteActualizado(IdCliente idCliente, Nombre nombre) {
        super("sofka.requerimiento.nombredeclienteactualizado");
        this.idCliente = idCliente;
        this.nombre = nombre;
    }

    public IdCliente getIdCliente() {
        return idCliente;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
