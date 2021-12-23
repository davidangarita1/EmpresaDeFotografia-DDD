package co.com.sofka.domain.Retocador.Command;

import co.com.sofka.domain.Generico.Nombre;
import co.com.sofka.domain.Retocador.Value.IdRetocador;
import co.com.sofka.domain.generic.Command;

public class ActualizarNombre extends Command {
    private final IdRetocador idRetocador;
    private final Nombre nombre;

    public ActualizarNombre(IdRetocador idRetocador, Nombre nombre){
        this.idRetocador = idRetocador;
        this.nombre = nombre;
    }

    public IdRetocador getIdRetocador() {
        return idRetocador;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
