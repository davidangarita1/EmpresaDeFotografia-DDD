package co.com.sofka.domain.Retocador.Command;

import co.com.sofka.domain.Generico.Nombre;
import co.com.sofka.domain.Retocador.Value.IdRetocador;
import co.com.sofka.domain.generic.Command;

public class CrearRetocador extends Command {

    private final IdRetocador entityId;
    private final Nombre nombre;

    public CrearRetocador(IdRetocador entityId, Nombre nombre){

        this.entityId = entityId;
        this.nombre = nombre;
    }

    public IdRetocador getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
