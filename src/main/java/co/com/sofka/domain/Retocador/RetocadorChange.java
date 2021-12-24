package co.com.sofka.domain.Retocador;

import co.com.sofka.domain.Retocador.Event.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class RetocadorChange extends EventChange {
    public RetocadorChange(Retocador retocador) {

        apply((RetocadorCreado event) -> {
            retocador.nombre = event.getNombre();
            retocador.fotos = new HashSet<>();
            retocador.funciones = new HashSet<>();
            retocador.tareas = new HashSet<>();
        });

        apply((CaracteristicaDeFuncionActualizada event) -> {
            var funcion = retocador.getFuncionPorId(event.getIdFuncion())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra la caracteristica de la función"));
            funcion.actualizarCaracteristica(event.getCaracteristica());
        });

        apply((DescripcionDeFuncionActualizada event) ->{
            var funcion = retocador.getFuncionPorId(event.getIdFuncion())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra la descripción de la función"));
            funcion.actualizarDescripcion(event.getDescripcion());
        });

        apply((DescripcionDeTareaActualizada event) -> {
            var tarea = retocador.getTareaPorId(event.getIdTarea())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra la descripción de la tarea"));
            tarea.actualizarDescripcion(event.getDescripcion());
        });

        apply((FechaFinalDeTareaActualizada event) -> {
            var tarea = retocador.getTareaPorId(event.getIdTarea())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra la fecha final de la tarea"));
            tarea.actualizarFechaFinal(event.getFechaFinal());
        });

        apply((FechaInicialDeTareaActualiada event) -> {
            var tarea = retocador.getTareaPorId(event.getIdTarea())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra la fecha inicial de la tarea"));
            tarea.actualizarFechaInicial(event.getFechaInicial());
        });

        apply((FormatoDeFotoActualizado event) -> {
            var foto = retocador.getFotoPorId(event.getIdFoto())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra el formato de la foto"));
            foto.actualizarFormato(event.getFormato());
        });

        apply((FotoAgregada event) -> {
            retocador.fotos.add(new Foto(
                    event.getIdFoto(),
                    event.getFormato(),
                    event.getPerfilDeColor()
            ));
        });

        apply((FuncionAgregada event) -> {
            var numFunciones = retocador.funciones().size();
            if (numFunciones == 10) {
                throw  new IllegalArgumentException("No puedes agregar mas funciones, solo puedes tener hasta 10 de ellas");
            }
            retocador.funciones.add(new Funcion(
                    event.getIdFuncion(),
                    event.getCaracteristica(),
                    event.getDescripcion()
            ));
        });

        apply((TareaAgregada event) -> {
            retocador.tareas.add(new Tarea(
                    event.getIdTarea(),
                    event.getFechaInicial(),
                    event.getFechaFinal(),
                    event.getDescripcion()
            ));
        });

        apply((NombreActualizado event) -> {
            retocador.nombre = event.getNombre();
        });

        apply((PerfilDeColorDeFotoActualizado event) -> {
            var foto = retocador.getFotoPorId(event.getIdFoto())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra el perfil de color de la foto"));
            foto.actualizarPerfilDeColor(event.getPerfilDeColor());
        });


    }
}
