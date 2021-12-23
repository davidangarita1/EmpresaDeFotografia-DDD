package co.com.sofka.domain.Retocador.Event;

import co.com.sofka.domain.Generico.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreActualizado extends DomainEvent {

    private final Nombre nombre;

    public NombreActualizado(Nombre nombre) {
        super("sofka.retocador.nombreactualizado");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
