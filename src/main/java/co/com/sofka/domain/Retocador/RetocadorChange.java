package co.com.sofka.domain.Retocador;

import co.com.sofka.domain.Retocador.Event.CaracteristicaDeFuncionActualizada;
import co.com.sofka.domain.Retocador.Event.RetocadorCreado;
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

        });
    }
}
