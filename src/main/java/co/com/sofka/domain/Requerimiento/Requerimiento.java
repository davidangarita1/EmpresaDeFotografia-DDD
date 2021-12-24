package co.com.sofka.domain.Requerimiento;

import co.com.sofka.domain.Generico.Descripcion;
import co.com.sofka.domain.Generico.Fecha;
import co.com.sofka.domain.Generico.Nombre;
import co.com.sofka.domain.Requerimiento.Event.*;
import co.com.sofka.domain.Requerimiento.Value.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;


public class Requerimiento extends AggregateEvent<IdRequerimiento> {
    protected Fecha fecha;
    protected Set<PaqueteDeFotos> paquetesDeFotos;
    protected Set<Revision> revisiones;
    protected Set<Cliente> clientes;

    public Requerimiento(IdRequerimiento idRequerimiento, Fecha fecha) {
        super(idRequerimiento);
        appendChange(new RequerimientoCreado(fecha)).apply();
    }

    public Requerimiento(IdRequerimiento entityId) {
        super(entityId);
        subscribe(new RequerimientoChange(this));
    }

    public static Requerimiento from(IdRequerimiento idRequerimiento, List<DomainEvent> events){
        var requerimiento = new Requerimiento(idRequerimiento);
        events.forEach(requerimiento::applyEvent);
        return requerimiento;
    }

    public void agregarCliente(IdCliente idCliente, Nombre nombre){
        Objects.requireNonNull(idCliente);
        Objects.requireNonNull(nombre);
        appendChange(new ClienteAgregado(idCliente, nombre)).apply();
    }

    public void agregarRevision(IdRevision idRevision, Fecha fecha, Descripcion descripcion){
        Objects.requireNonNull(idRevision);
        Objects.requireNonNull(fecha);
        Objects.requireNonNull(descripcion);
        appendChange(new RevisionAgregada(idRevision, fecha, descripcion)).apply();
    }

    public void agregarPaqueteDeFotos(IdPaqueteDeFotos idPaqueteDeFotos, Cantidad cantidad, Descripcion descripcion){
        Objects.requireNonNull(idPaqueteDeFotos);
        Objects.requireNonNull(cantidad);
        Objects.requireNonNull(descripcion);
        appendChange(new PaqueteDeFotosAgregado(idPaqueteDeFotos, cantidad, descripcion)).apply();
    }

    public void actualizarCantidadDePaquetesDeFotos(IdPaqueteDeFotos idPaqueteDeFotos, Cantidad cantidad){
        appendChange(new CantidadDePaquetesDeFotosActualizada(idPaqueteDeFotos, cantidad)).apply();
    }

    public void actualizarDescripcionDePaquetesDeFotos(IdPaqueteDeFotos idPaqueteDeFotos, Descripcion descripcion){
        appendChange(new DescripcionDePaquetesDeFotosActualizada(idPaqueteDeFotos, descripcion)).apply();
    }

    public void actualizarFechaDeRevision(IdRevision idRevision, Fecha fecha){
        appendChange(new FechaDeRevisionActualizada(idRevision, fecha)).apply();
    }

    public void actualizarDescripcionDeRevision(IdRevision idRevision, Descripcion descripcion){
        appendChange(new DescripcionDeRevisionActualizada(idRevision, descripcion)).apply();
    }

    public void actualizarNombreDeCliente(IdCliente idCliente, Nombre nombre){
        appendChange(new NombreDeClienteActualizado(idCliente, nombre)).apply();
    }

    public void actualizarFecha(Fecha fecha){
        appendChange(new FechaActualizada(fecha)).apply();
    }

    protected Optional<PaqueteDeFotos> getPaqueteDeFotosPorId(IdPaqueteDeFotos idPaqueteDeFotos){
        return paquetesDeFotos
                .stream()
                .filter(paqueteDeFotos -> paqueteDeFotos.identity().equals(idPaqueteDeFotos)).findFirst();
    }

    protected Optional<Revision> getRevisionPorId(IdRevision idRevision){
        return revisiones
                .stream()
                .filter(revision -> revision.identity().equals(idRevision)).findFirst();
    }

    protected Optional<Cliente> getClientePorId(IdCliente idCliente){
        return clientes
                .stream()
                .filter(cliente -> cliente.identity().equals(idCliente)).findFirst();
    }

    public Fecha fecha() {
        return fecha;
    }

    public Set<PaqueteDeFotos> paquetesDeFotos() {
        return paquetesDeFotos;
    }

    public Set<Revision> revisiones() {
        return revisiones;
    }

    public Set<Cliente> clientes() {
        return clientes;
    }
}
