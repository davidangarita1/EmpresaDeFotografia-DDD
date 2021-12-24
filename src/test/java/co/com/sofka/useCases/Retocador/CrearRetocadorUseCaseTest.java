package co.com.sofka.useCases.Retocador;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Generico.Nombre;
import co.com.sofka.domain.Retocador.Command.CrearRetocador;
import co.com.sofka.domain.Retocador.Event.RetocadorCreado;
import co.com.sofka.domain.Retocador.Value.IdRetocador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrearRetocadorUseCaseTest {
    @Test
    void crearRetocadorUseCaseTest(){
        //arrange
        IdRetocador idRetocador = IdRetocador.of("xxxx");
        Nombre nombre = new Nombre("David");

        var command = new CrearRetocador(idRetocador, nombre);
        var useCase = new CrearRetocadorUseCase();

        //act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts

        RetocadorCreado event = (RetocadorCreado)events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("David", event.getNombre().value());
    }
}