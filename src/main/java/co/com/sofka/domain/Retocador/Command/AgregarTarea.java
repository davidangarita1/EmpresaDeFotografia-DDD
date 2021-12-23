package co.com.sofka.domain.Retocador.Command;

import co.com.sofka.domain.Generico.Descripcion;
import co.com.sofka.domain.Generico.FechaFinal;
import co.com.sofka.domain.Generico.FechaInicial;
import co.com.sofka.domain.Retocador.Value.IdRetocador;
import co.com.sofka.domain.Retocador.Value.IdTarea;
import co.com.sofka.domain.generic.Command;

public class AgregarTarea extends Command {
    private final IdRetocador idRetocador;
    private final IdTarea idTarea;
    private final FechaInicial fechaInicial;
    private final FechaFinal fechaFinal;
    private final Descripcion descripcion;

    public AgregarTarea(IdRetocador idRetocador, IdTarea idTarea, FechaInicial fechaInicial, FechaFinal fechaFinal, Descripcion descripcion){
        this.idRetocador = idRetocador;
        this.idTarea = idTarea;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.descripcion = descripcion;
    }

    public IdRetocador getIdRetocador() {
        return idRetocador;
    }

    public IdTarea getIdTarea() {
        return idTarea;
    }

    public FechaInicial getFechaInicial() {
        return fechaInicial;
    }

    public FechaFinal getFechaFinal() {
        return fechaFinal;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
