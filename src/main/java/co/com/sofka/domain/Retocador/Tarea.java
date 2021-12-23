package co.com.sofka.domain.Retocador;

import co.com.sofka.domain.Generico.Descripcion;
import co.com.sofka.domain.Generico.FechaFinal;
import co.com.sofka.domain.Generico.FechaInicial;
import co.com.sofka.domain.Retocador.Value.IdTarea;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Tarea extends Entity<IdTarea> {
    private FechaInicial fechaInicial;
    private FechaFinal fechaFinal;
    private Descripcion descripcion;

    public Tarea(IdTarea entityId, FechaInicial fechaInicio, FechaFinal fechaFinal, Descripcion descripcion) {
        super(entityId);
        this.fechaInicial = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.descripcion = descripcion;
    }

    public void actualizarFechaInicial(FechaInicial fechaInicial){
        this.fechaInicial = Objects.requireNonNull(fechaInicial);
    }

    public void actualizarFechaFinal(FechaFinal fechaFinal) {
        this.fechaFinal = Objects.requireNonNull(fechaFinal);
    }

    public void actualizarDescripcion(Descripcion descripcion){
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    public FechaInicial fechaInicio() {
        return fechaInicial;
    }

    public FechaFinal fechaFinal() {
        return fechaFinal;
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}
