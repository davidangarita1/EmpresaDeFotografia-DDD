package co.com.sofka.domain.Procedimiento.Event;

import co.com.sofka.domain.Retocador.Value.IdFoto;
import co.com.sofka.domain.generic.DomainEvent;

public class IdFotoAgregada extends DomainEvent {
    private final IdFoto idFoto;

    public IdFotoAgregada(IdFoto idFoto) {
        super("sofka.procedimiento.idfotoagregada");
        this.idFoto = idFoto;
    }

    public IdFoto getIdFoto() {
        return idFoto;
    }
}
