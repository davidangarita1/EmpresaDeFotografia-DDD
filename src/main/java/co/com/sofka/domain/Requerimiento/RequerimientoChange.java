package co.com.sofka.domain.Requerimiento;

import co.com.sofka.domain.Requerimiento.Event.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;
import java.util.Set;

public class RequerimientoChange extends EventChange {
    public RequerimientoChange(Requerimiento requerimiento) {

        apply((RequerimientoCreado event) -> {
            requerimiento.fecha = event.getFecha();
            requerimiento.paquetesDeFotos = new HashSet<>();
            requerimiento.revisiones = new HashSet<>();
            requerimiento.clientes = new HashSet<>();
        });

        apply((CantidadDePaquetesDeFotosActualizada event) -> {
            var paquete = requerimiento.getPaqueteDeFotosPorId(event.getIdPaqueteDeFotos())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra la cantidad del paquete de fotos"));
            paquete.actualizarCantidad(event.getCantidad());
        });

        apply((ClienteAgregado event) -> {
            requerimiento.clientes.add(new Cliente(
                    event.getIdCliente(),
                    event.getNombre()
            ));
        });

        apply((PaqueteDeFotosAgregado event) -> {
            requerimiento.paquetesDeFotos.add(new PaqueteDeFotos(
                    event.getIdPaqueteDeFotos(),
                    event.getCantidad(),
                    event.getDescripcion()
            ));
        });

        apply((RevisionAgregada event) -> {
            requerimiento.revisiones.add(new Revision(
                    event.getIdRevision(),
                    event.getFecha(),
                    event.getDescripcion()
            ));
        });

        apply((DescripcionDePaquetesDeFotosActualizada event) -> {
            var paquete = requerimiento.getPaqueteDeFotosPorId(event.getIdPaqueteDeFotos())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra la descripcion del paquete de fotos"));
            paquete.actualizarDescripcion(event.getDescripcion());
        });

        apply((DescripcionDeRevisionActualizada event) ->{
            var revision = requerimiento.getRevisionPorId(event.getIdRevision())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra la descripcion de la revision"));
            revision.actualizarDescripcion(event.getDescripcion());
        });

        apply((FechaActualizada event) -> {
            requerimiento.fecha = event.getFecha();
        });

        apply((FechaDeRevisionActualizada event) -> {
            var revision = requerimiento.getRevisionPorId(event.getIdRevision())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra la fecha de la revision"));
            revision.actualizarFecha(event.getFecha());
        });

        apply((NombreDeClienteActualizado event) -> {
            var cliente = requerimiento.getClientePorId(event.getIdCliente())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra el nombre del cliente"));
            cliente.actualizarNombre(event.getNombre());
        });
    }
}
