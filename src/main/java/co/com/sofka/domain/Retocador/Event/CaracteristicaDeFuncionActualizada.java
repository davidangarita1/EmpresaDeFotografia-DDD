package co.com.sofka.domain.Retocador.Event;

import co.com.sofka.domain.Retocador.Value.Caracteristica;
import co.com.sofka.domain.Retocador.Value.IdFuncion;
import co.com.sofka.domain.generic.DomainEvent;

public class CaracteristicaDeFuncionActualizada extends DomainEvent {
    private final IdFuncion idFuncion;
    private final Caracteristica caracteristica;

    public CaracteristicaDeFuncionActualizada(IdFuncion idFuncion, Caracteristica caracteristica) {
        super("sofka.retocador.caracteristicadefuncionactualizada");
        this.idFuncion = idFuncion;
        this.caracteristica = caracteristica;
    }

    public IdFuncion getIdFuncion() {
        return idFuncion;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }
}
