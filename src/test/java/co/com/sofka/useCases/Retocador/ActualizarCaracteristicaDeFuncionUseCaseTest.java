package co.com.sofka.useCases.Retocador;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Generico.Descripcion;
import co.com.sofka.domain.Generico.Fecha;
import co.com.sofka.domain.Generico.Nombre;
import co.com.sofka.domain.Requerimiento.Event.RequerimientoCreado;
import co.com.sofka.domain.Retocador.Command.ActualizarCaracteristicaDeFuncion;
import co.com.sofka.domain.Retocador.Command.AgregarFuncion;
import co.com.sofka.domain.Retocador.Event.CaracteristicaDeFuncionActualizada;
import co.com.sofka.domain.Retocador.Event.FuncionAgregada;
import co.com.sofka.domain.Retocador.Event.RetocadorCreado;
import co.com.sofka.domain.Retocador.Value.Caracteristica;
import co.com.sofka.domain.Retocador.Value.IdFuncion;
import co.com.sofka.domain.Retocador.Value.IdRetocador;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarCaracteristicaDeFuncionUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarCaracteristicaDeFuncionUseCaseTest(){

        //arrange
        IdRetocador idRetocador = IdRetocador.of("xxxx");
        IdFuncion idFuncion = IdFuncion.of("1");

        var command = new ActualizarCaracteristicaDeFuncion(
                idRetocador,
                idFuncion,
                new Caracteristica("Caracteristica Actualizada")
        );
        var useCase = new ActualizarCaracteristicaDeFuncionUseCase();

        //act
        when(repository.getEventsBy("xxxx")).thenReturn(events());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idRetocador.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts
        var event = (CaracteristicaDeFuncionActualizada) events.getDomainEvents().get(0);
        Assertions.assertEquals("Caracteristica Actualizada", event.getCaracteristica().value());
    }

    private List<DomainEvent> events() {
        return  List.of(new RetocadorCreado(
                new Nombre("David")
        ),
                new FuncionAgregada(
                        IdFuncion.of("1"),
                        new Caracteristica("Caracteristica de prueba"),
                        new Descripcion("Descripción de prueba")
                )
        );
    }
}