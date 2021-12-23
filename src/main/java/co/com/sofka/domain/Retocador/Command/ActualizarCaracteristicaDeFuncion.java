package co.com.sofka.domain.Retocador.Command;

import co.com.sofka.domain.Retocador.Value.Caracteristica;
import co.com.sofka.domain.Retocador.Value.IdFuncion;
import co.com.sofka.domain.Retocador.Value.IdRetocador;

public class ActualizarCaracteristicaDeFuncion {
    private final IdRetocador idRetocador;
    private final IdFuncion idFuncion;
    private final Caracteristica caracteristica;

    public ActualizarCaracteristicaDeFuncion(IdRetocador idRetocador, IdFuncion idFuncion, Caracteristica caracteristica){
        this.idRetocador = idRetocador;
        this.idFuncion = idFuncion;
        this.caracteristica = caracteristica;
    }

    public IdRetocador getIdRetocador() {
        return idRetocador;
    }

    public IdFuncion getIdFuncion() {
        return idFuncion;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }
}
