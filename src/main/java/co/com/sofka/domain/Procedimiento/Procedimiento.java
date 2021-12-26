package co.com.sofka.domain.Procedimiento;

import co.com.sofka.domain.Generico.Fecha;
import co.com.sofka.domain.Generico.PerfilDeColor;
import co.com.sofka.domain.Procedimiento.Event.*;
import co.com.sofka.domain.Procedimiento.Value.*;
import co.com.sofka.domain.Retocador.Value.IdFoto;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Procedimiento extends AggregateEvent<IdProcedimiento> {
    protected Fecha fecha;
    protected Set<IdFoto> idFotos;
    protected Set<Retoque> retoques;
    protected Set<Montaje> montajes;
    protected Set<Colorizado> colorizados;

    public Procedimiento(IdProcedimiento entityId, Fecha fecha) {
        super(entityId);
        appendChange(new ProcedimientoCreado(fecha)).apply();
    }

    public Procedimiento(IdProcedimiento entityId) {
        super(entityId);
        subscribe(new ProcedimientoChange(this));
    }

    public static Procedimiento from(IdProcedimiento idProcedimiento, List<DomainEvent> events){
        var procedimiento = new Procedimiento(idProcedimiento);
        events.forEach(procedimiento::applyEvent);
        return procedimiento;
    }

    public void agregarIdFoto(IdFoto idFoto){
        Objects.requireNonNull(idFoto);
        appendChange(new IdFotoAgregada(idFoto)).apply();
    }

    public void actualizarFecha(Fecha fecha){
        appendChange(new FechaActualizada(fecha)).apply();
    }

    public void agregarRetoque(IdRetoque idRetoque, Cambios cambios, Capas capas, Filtros filtros){
        Objects.requireNonNull(idRetoque);
        Objects.requireNonNull(cambios);
        Objects.requireNonNull(capas);
        Objects.requireNonNull(filtros);
        appendChange(new RetoqueAgregado(idRetoque, cambios, capas, filtros)).apply();
    }

    public void agregarMontaje(IdMontaje idMontaje, Cambios cambios, Fondo fondo){
        Objects.requireNonNull(idMontaje);
        Objects.requireNonNull(cambios);
        Objects.requireNonNull(fondo);
        appendChange(new MontajeAgregado(idMontaje, cambios, fondo)).apply();
    }

    public void agregarColorizado(IdColorizado idColorizado, Cambios cambios, PerfilDeColor perfilDeColor){
        Objects.requireNonNull(idColorizado);
        Objects.requireNonNull(cambios);
        Objects.requireNonNull(perfilDeColor);
        appendChange(new ColorizadoAgregado(idColorizado, cambios, perfilDeColor)).apply();
    }

    public void actualizarCambiosDeColorizado(IdColorizado idColorizado, Cambios cambios){
        appendChange(new CambiosDeColorizadoActualizado(idColorizado, cambios)).apply();
    }

    public void actualizarPerfilDeColorDeColorizado(IdColorizado idColorizado, PerfilDeColor perfilDeColor){
        appendChange(new PerfilDeColorDeColorizadoActualizado(idColorizado, perfilDeColor)).apply();
    }

    public void actualizarCambiosDeMontaje(IdMontaje idMontaje, Cambios cambios){
        appendChange(new CambiosDeMontajeActualizado(idMontaje, cambios)).apply();
    }

    public void actualizarFondoDeMontaje(IdMontaje idMontaje, Fondo fondo){
        appendChange(new FondoDeMontajeActualizado(idMontaje, fondo)).apply();
    }

    public void actualizarCambiosDeRetoque(IdRetoque idRetoque, Cambios cambios){
        appendChange(new CambiosDeRetoqueActualizado(idRetoque, cambios)).apply();
    }

    public void actualizarCapasDeRetoque(IdRetoque idRetoque, Capas capas){
        appendChange(new CapasDeRetoqueActualizado(idRetoque, capas)).apply();
    }

    public void actualizarFiltrosDeRetoque(IdRetoque idRetoque, Filtros filtros){
        appendChange(new FiltrosDeRetoqueActualizado(idRetoque, filtros)).apply();
    }

    protected Optional<IdFoto> getIdFotoPorId(IdFoto idFoto){
        return idFotos
                .stream()
                .filter(id -> id.equals(idFoto)).findFirst();
    }

    protected Optional<Retoque> getRetoquePorId(IdRetoque idRetoque){
        return retoques
                .stream()
                .filter(retoque -> retoque.identity().equals(idRetoque)).findFirst();
    }

    protected Optional<Montaje> getMontajePorId(IdMontaje idMontaje){
        return montajes
                .stream()
                .filter(montaje -> montaje.identity().equals(idMontaje)).findFirst();
    }

    protected Optional<Colorizado> getColorizadoPorId(IdColorizado idColorizado){
        return colorizados
                .stream()
                .filter(colorizado -> colorizado.identity().equals(idColorizado)).findFirst();
    }

    public Fecha fecha() {
        return fecha;
    }

    public Set<IdFoto> idFotos() {
        return idFotos;
    }

    public Set<Retoque> retoques() {
        return retoques;
    }

    public Set<Montaje> montajes() {
        return montajes;
    }

    public Set<Colorizado> colorizados() {
        return colorizados;
    }
}
