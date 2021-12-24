package co.com.sofka.useCases.Retocador;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Generico.Descripcion;
import co.com.sofka.domain.Retocador.Command.ActualizarCaracteristicaDeFuncion;
import co.com.sofka.domain.Retocador.Command.AgregarFuncion;
import co.com.sofka.domain.Retocador.Event.CaracteristicaDeFuncionActualizada;
import co.com.sofka.domain.Retocador.Value.Caracteristica;
import co.com.sofka.domain.Retocador.Value.IdFuncion;
import co.com.sofka.domain.Retocador.Value.IdRetocador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActualizarCaracteristicaDeFuncionUseCaseTest {
    @Test
    void actualizarCaracteristicaDeFuncionUseCaseTest(){
        //arrange
        IdRetocador idRetocador = IdRetocador.of("xxxX");
        IdFuncion idFuncion = new IdFuncion();
        Caracteristica caracteristica = new Caracteristica("Caracteristica de Ejemplo");
        Descripcion descripcion = new Descripcion("Descripción de Ejemplo");

        var funcion = new AgregarFuncion(idRetocador,idFuncion, caracteristica, descripcion);

        var command = new ActualizarCaracteristicaDeFuncion(
                idRetocador,
                idFuncion,
                new Caracteristica("Caracteristica Actualizada")
        );
        var useCase = new ActualizarCaracteristicaDeFuncionUseCase();

        //act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts

        var event = (CaracteristicaDeFuncionActualizada) events.getDomainEvents().get(2);
        Assertions.assertEquals("Caracteristica Actualizada", event.getCaracteristica().value());
    }
}