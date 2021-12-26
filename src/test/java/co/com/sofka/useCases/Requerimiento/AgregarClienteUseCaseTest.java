package co.com.sofka.useCases.Requerimiento;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Generico.Fecha;
import co.com.sofka.domain.Generico.Nombre;
import co.com.sofka.domain.Requerimiento.Command.AgregarCliente;
import co.com.sofka.domain.Requerimiento.Event.ClienteAgregado;
import co.com.sofka.domain.Requerimiento.Event.RequerimientoCreado;
import co.com.sofka.domain.Requerimiento.Value.IdCliente;
import co.com.sofka.domain.Requerimiento.Value.IdRequerimiento;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarClienteUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @Test
    void agregarCliente(){

        //arrange
        IdRequerimiento idRequerimiento = IdRequerimiento.of("xxxxx");
        IdCliente idCliente = IdCliente.of("fffff");
        Nombre nombre = new Nombre("David");

        var command = new AgregarCliente(idRequerimiento, idCliente, nombre);
        var useCase = new AgregarClienteUseCase();

        when(repository.getEventsBy("xxxxx")).thenReturn(events());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idRequerimiento.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts
        var event = (ClienteAgregado) events.getDomainEvents().get(0);

        Assertions.assertEquals("David", event.getNombre().value());
        Mockito.verify(repository).getEventsBy("xxxxx");
    }

    @Test
    void agregarCliente_errorPorCantidades(){

        //arrange
        IdRequerimiento idRequerimiento = IdRequerimiento.of("xxxxx");
        IdCliente idCliente = IdCliente.of("fffff");
        Nombre nombre = new Nombre("David");

        var command = new AgregarCliente(idRequerimiento, idCliente, nombre);
        var useCase = new AgregarClienteUseCase();

        when(repository.getEventsBy("xxxxx")).thenReturn(fullClientesEvents());
        useCase.addRepository(repository);

        //act
        Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor(idRequerimiento.value())
                    .syncExecutor(useCase, new RequestCommand<>(command))
                    .orElseThrow();
        });
    }

    private List<DomainEvent> events() {
        return  List.of(new RequerimientoCreado(
                new Fecha(new Date())
        ));
    }

    private List<DomainEvent> fullClientesEvents() {
        return  List.of(new RequerimientoCreado(
                        new Fecha(new Date())
                ),
                new ClienteAgregado(
                        IdCliente.of("1"),
                        new Nombre("David")
                ),
                new ClienteAgregado(
                        IdCliente.of("2"),
                        new Nombre("Lukas")
                )
        );
    }
}