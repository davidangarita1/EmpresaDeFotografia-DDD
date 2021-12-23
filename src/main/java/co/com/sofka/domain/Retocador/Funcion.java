package co.com.sofka.domain.Retocador;

import co.com.sofka.domain.Generico.Descripcion;
import co.com.sofka.domain.Retocador.Value.Caracteristica;
import co.com.sofka.domain.Retocador.Value.IdFuncion;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Funcion extends Entity<IdFuncion> {

    private Caracteristica caracteristica;
    private Descripcion descripcion;

    public Funcion(IdFuncion entityId, Caracteristica caracteristica, Descripcion descripcion) {
        super(entityId);
        this.caracteristica = caracteristica;
        this.descripcion = descripcion;
    }

    public void actualizarCaracteristica(Caracteristica caracteristica) {
        this.caracteristica = Objects.requireNonNull(caracteristica);
    }

    public void actualizarDescripcion(Descripcion descripcion) {
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    public Caracteristica caracteristica() {
        return caracteristica;
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}
