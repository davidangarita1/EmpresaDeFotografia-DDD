package co.com.sofka.domain.Retocador.Event;

import co.com.sofka.domain.Generico.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class RetocadorCreado extends DomainEvent {
    private final Nombre nombre;

    public RetocadorCreado(Nombre nombre) {
        super("sofka.retocador.retocadorcreado");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
