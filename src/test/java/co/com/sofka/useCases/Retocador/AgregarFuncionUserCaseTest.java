package co.com.sofka.useCases.Retocador;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Generico.Descripcion;
import co.com.sofka.domain.Generico.Nombre;
import co.com.sofka.domain.Retocador.Command.AgregarFuncion;
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
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarFuncionUserCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarFuncionUserCaseTest(){

        //arrange
        IdRetocador idRetocador = IdRetocador.of("xxxx");
        IdFuncion idFuncion = IdFuncion.of("fffff");
        Caracteristica caracteristica = new Caracteristica("Caracteristica de prueba");
        Descripcion descripcion = new Descripcion("Descripción de prueba");

        var command = new AgregarFuncion(idRetocador, idFuncion, caracteristica, descripcion);
        var useCase = new AgregarFuncionUseCase();

        when(repository.getEventsBy("xxxx")).thenReturn(events());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idRetocador.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts
        var event = (FuncionAgregada) events.getDomainEvents().get(0);

        Assertions.assertEquals("Caracteristica de prueba", event.getCaracteristica().value());
        Assertions.assertEquals("Descripción de prueba", event.getDescripcion().value());
        Mockito.verify(repository).getEventsBy("xxxx");
    }

    private List<DomainEvent> events() {
        return  List.of(new RetocadorCreado(
                new Nombre("David")
        ));
    }
}