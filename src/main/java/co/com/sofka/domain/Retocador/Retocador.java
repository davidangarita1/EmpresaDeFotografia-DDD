package co.com.sofka.domain.Retocador;

import co.com.sofka.domain.Generico.Descripcion;
import co.com.sofka.domain.Generico.FechaFinal;
import co.com.sofka.domain.Generico.FechaInicial;
import co.com.sofka.domain.Generico.Nombre;
import co.com.sofka.domain.Retocador.Event.*;
import co.com.sofka.domain.Retocador.Value.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Retocador extends AggregateEvent<IdRetocador> {
    protected Nombre nombre;
    protected Set<Foto> fotos;
    protected Set<Funcion> funciones;
    protected Set<Tarea> tareas;

    public Retocador(IdRetocador entityId, Nombre nombre) {
        super(entityId);
        appendChange(new RetocadorCreado(nombre)).apply();
    }

    private Retocador(IdRetocador idRetocador){
        super(idRetocador);
        subscribe(new RetocadorChange(this));
    }

    public static Retocador from(IdRetocador idRetocador, List<DomainEvent> events){
        var retocador = new Retocador(idRetocador);
        events.forEach(retocador::applyEvent);
        return retocador;
    }

    public void agregarFoto(IdFoto idFoto, Formato formato, PerfilDeColor perfilDeColor){
        Objects.requireNonNull(idFoto);
        Objects.requireNonNull(formato);
        Objects.requireNonNull(perfilDeColor);
        appendChange(new FotoAgregada(idFoto, formato, perfilDeColor)).apply();
    }

    public void agregarFuncion(IdFuncion idFuncion, Caracteristica caracteristica, Descripcion descripcion){
        Objects.requireNonNull(idFuncion);
        Objects.requireNonNull(caracteristica);
        Objects.requireNonNull(descripcion);
        appendChange(new FuncionAgregada(idFuncion, caracteristica, descripcion)).apply();
    }

    public void agregarTarea(IdTarea idTarea, FechaInicial fechaInicial, FechaFinal fechaFinal, Descripcion descripcion){
        Objects.requireNonNull(idTarea);
        Objects.requireNonNull(fechaInicial);
        Objects.requireNonNull(fechaFinal);
        Objects.requireNonNull(descripcion);
        appendChange(new TareaAgregada(idTarea, fechaInicial,fechaFinal, descripcion)).apply();
    }

    public void actualizarNombre(Nombre nombre){
        appendChange(new NombreActualizado(nombre)).apply();
    }

    public void actualizarFormatoDeFoto(IdFoto idFoto, Formato formato){
        appendChange(new FormatoDeFotoActualizado(idFoto, formato)).apply();
    }

    public void actualizarPerfilDeColorDeFoto(IdFoto idFoto, PerfilDeColor perfilDeColor){
        appendChange(new PerfilDeColorDeFotoActualizado(idFoto, perfilDeColor)).apply();
    }

    public void actualizarCaracteristicaDeFuncion(IdFuncion idFuncion, Caracteristica caracteristica){
        appendChange(new CaracteristicaDeFuncionActualizada(idFuncion, caracteristica)).apply();
    }

    public void actualizarDescripcionDeFuncion(IdFuncion idFuncion, Descripcion descripcion){
        appendChange(new DescripcionDeFuncionActualizada(idFuncion, descripcion)).apply();
    }

    public void actualizarFechaInicialDeTarea(IdTarea idTarea, FechaInicial fechaInicial){
        appendChange(new FechaInicialDeTareaActualiada(idTarea, fechaInicial)).apply();
    }

    public void actualizarFechaFinalDeTarea(IdTarea idTarea, FechaFinal fechaFinal){
        appendChange(new FechaFinalDeTareaActualizada(idTarea, fechaFinal)).apply();
    }

    public void actualizarDescripcionDeTarea(IdTarea idTarea, Descripcion descripcion){
        appendChange(new DescripcionDeTareaActualizada(idTarea, descripcion)).apply();
    }

    protected Optional<Foto> getFotoPorId(IdFoto idFoto){
        return fotos
                .stream()
                .filter(foto -> foto.identity().equals(idFoto)).findFirst();
    }

    protected Optional<Funcion> getFuncionPorId(IdFuncion idFuncion){
        return funciones
                .stream()
                .filter(funcion -> funcion.identity().equals(idFuncion)).findFirst();
    }

    protected Optional<Tarea> getTareaPorId(IdTarea idTarea){
        return tareas
                .stream()
                .filter(tarea -> tarea.identity().equals(idTarea)).findFirst();
    }

    public Nombre nombre() {
        return nombre;
    }

    public Set<Foto> fotos() {
        return fotos;
    }

    public Set<Funcion> funciones() {
        return funciones;
    }

    public Set<Tarea> tareas() {
        return tareas;
    }
}
