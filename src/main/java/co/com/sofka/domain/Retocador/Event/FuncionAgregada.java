package co.com.sofka.domain.Retocador.Event;

import co.com.sofka.domain.Generico.Descripcion;
import co.com.sofka.domain.Retocador.Value.Caracteristica;
import co.com.sofka.domain.Retocador.Value.IdFuncion;
import co.com.sofka.domain.generic.DomainEvent;

public class FuncionAgregada extends DomainEvent {
    private final IdFuncion idFuncion;
    private final Caracteristica caracteristica;
    private final Descripcion descripcion;

    public FuncionAgregada(IdFuncion idFuncion, Caracteristica caracteristica, Descripcion descripcion) {
        super("sofka.retocador.funcionagregada");
        this.idFuncion = idFuncion;
        this.caracteristica = caracteristica;
        this.descripcion = descripcion;
    }

    public IdFuncion getIdFuncion() {
        return idFuncion;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
