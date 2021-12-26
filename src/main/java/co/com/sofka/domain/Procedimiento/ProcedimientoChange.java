package co.com.sofka.domain.Procedimiento;

import co.com.sofka.domain.Procedimiento.Event.*;
import co.com.sofka.domain.generic.EventChange;
import java.util.HashSet;


public class ProcedimientoChange extends EventChange {
    public ProcedimientoChange(Procedimiento procedimiento) {

        apply((ProcedimientoCreado event) -> {
            procedimiento.fecha = event.getFecha();
            procedimiento.idFotos = new HashSet<>();
            procedimiento.retoques = new HashSet<>();
            procedimiento.montajes = new HashSet<>();
            procedimiento.colorizados = new HashSet<>();
        });

        apply((CambiosDeColorizadoActualizado event) -> {
            var colorizado = procedimiento.getColorizadoPorId(event.getIdColorizado())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentran los cambios del colorizado"));
            colorizado.actualizarCambios(event.getCambios());
        });

        apply((CambiosDeMontajeActualizado event) -> {
            var montaje = procedimiento.getMontajePorId(event.getIdMontaje())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentran los cambios del montaje"));
            montaje.actualizarCambios(event.getCambios());
        });

        apply((CambiosDeRetoqueActualizado event) -> {
            var retoque = procedimiento.getRetoquePorId(event.getIdRetoque())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentran los cambios del retoque"));
            retoque.actualizarCambios(event.getCambios());
        });

        apply((CapasDeRetoqueActualizado event) -> {
            var retoque = procedimiento.getRetoquePorId(event.getIdRetoque())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentran las capas del retoque"));
            retoque.actualizarCapas(event.getCapas());
        });

        apply((ColorizadoAgregado event) -> {
            procedimiento.colorizados.add(new Colorizado(
                    event.getIdColorizado(),
                    event.getCambios(),
                    event.getPerfilDeColor()
            ));
        });

        apply((FechaActualizada event) -> {
            procedimiento.fecha = event.getFecha();
        });

        apply((FiltrosDeRetoqueActualizado event) -> {
           var retoque = procedimiento.getRetoquePorId(event.getIdRetoque())
                   .orElseThrow(() -> new IllegalArgumentException("No se encuentran los filtros del retoque"));
           retoque.actualizarFiltros(event.getFiltros());
        });

        apply((FondoDeMontajeActualizado event) -> {
            var montaje = procedimiento.getMontajePorId(event.getIdMontaje())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra el fondo del montaje"));
            montaje.actualizarFondo(event.getFondo());
        });

        apply((IdFotoAgregada event) -> {
            procedimiento.getIdFotoPorId(event.getIdFoto())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra el id de la foto"));
            procedimiento.agregarIdFoto(event.getIdFoto());
        });

        apply((MontajeAgregado event) -> {
           procedimiento.montajes.add(new Montaje(
                   event.getIdMontaje(),
                   event.getCambios(),
                   event.getFondo()
           ));
        });

        apply((PerfilDeColorDeColorizadoActualizado event) -> {
            var perfil = procedimiento.getColorizadoPorId(event.getIdColorizado())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra el perfil de color del colorizado"));
            perfil.actualizarPerfilDeColor(event.getPerfilDeColor());
        });

        apply((RetoqueAgregado event) -> {
            procedimiento.retoques.add(new Retoque(
                    event.getIdRetoque(),
                    event.getCambios(),
                    event.getCapas(),
                    event.getFiltros()
            ));
        });
    }
}
