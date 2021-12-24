package co.com.sofka.useCases.Retocador;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Generico.Descripcion;
import co.com.sofka.domain.Retocador.Command.AgregarFuncion;
import co.com.sofka.domain.Retocador.Event.FuncionAgregada;
import co.com.sofka.domain.Retocador.Value.Caracteristica;
import co.com.sofka.domain.Retocador.Value.IdFuncion;
import co.com.sofka.domain.Retocador.Value.IdRetocador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AgregarFuncionUserCaseTest {
    @Test
    void agregarFuncionUserCaseTest(){

        //arrange
        IdRetocador idRetocador = IdRetocador.of("xxxx");
        IdFuncion idFuncion = new IdFuncion();
        Caracteristica caracteristica = new Caracteristica("Algo");
        Descripcion descripcion = new Descripcion("Descripción de prueba");

        var command = new AgregarFuncion(idRetocador, idFuncion, caracteristica, descripcion);
        var useCase = new AgregarFuncionUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts
        var event = (FuncionAgregada) events.getDomainEvents().get(1);
        Assertions.assertEquals("Algo", event.getCaracteristica().value());
        Assertions.assertEquals("Descripción de prueba", event.getDescripcion().value());
    }
}