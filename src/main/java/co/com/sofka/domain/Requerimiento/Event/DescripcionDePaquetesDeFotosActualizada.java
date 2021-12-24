package co.com.sofka.domain.Requerimiento.Event;

import co.com.sofka.domain.Generico.Descripcion;
import co.com.sofka.domain.Requerimiento.Value.IdPaqueteDeFotos;
import co.com.sofka.domain.generic.DomainEvent;

public class DescripcionDePaquetesDeFotosActualizada extends DomainEvent {
    private final IdPaqueteDeFotos idPaqueteDeFotos;
    private final Descripcion descripcion;

    public DescripcionDePaquetesDeFotosActualizada(IdPaqueteDeFotos idPaqueteDeFotos, Descripcion descripcion) {
        super("sofka.requerimiento.descripciondepaquetesdefotosactualizada");
        this.idPaqueteDeFotos = idPaqueteDeFotos;
        this.descripcion = descripcion;
    }

    public IdPaqueteDeFotos getIdPaqueteDeFotos() {
        return idPaqueteDeFotos;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
