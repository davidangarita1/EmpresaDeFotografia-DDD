package co.com.sofka.useCases.Procedimiento;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Generico.Fecha;
import co.com.sofka.domain.Procedimiento.Command.AgregarRetoque;
import co.com.sofka.domain.Procedimiento.Event.ProcedimientoCreado;
import co.com.sofka.domain.Procedimiento.Event.RetoqueAgregado;
import co.com.sofka.domain.Procedimiento.Value.*;
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
class AgregarRetoqueUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @Test
    void agregarRetoque(){

        //arrange
        IdProcedimiento idProcedimiento = IdProcedimiento.of("xxxxx");
        IdRetoque idRetoque = IdRetoque.of("fffff");
        Cambios cambios = new Cambios("Cambio 1, Cambio 2");
        Capas capas = new Capas("Capa 1, Capa 2");
        Filtros filtros = new Filtros("Desvanecido, Desenfoque Gausiano");

        var command = new AgregarRetoque(idProcedimiento, idRetoque, cambios, capas, filtros);
        var useCase = new AgregarRetoqueUseCase();

        when(repository.getEventsBy("xxxxx")).thenReturn(events());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idProcedimiento.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts
        var event = (RetoqueAgregado) events.getDomainEvents().get(0);

        Assertions.assertEquals("Cambio 1, Cambio 2", event.getCambios().value());
        Assertions.assertEquals("Capa 1, Capa 2", event.getCapas().value());
        Assertions.assertEquals("Desvanecido, Desenfoque Gausiano", event.getFiltros().value());
        Mockito.verify(repository).getEventsBy("xxxxx");
    }

    @Test
    void agregarRetoque_errorPorCantidades(){

        //arrange
        IdProcedimiento idProcedimiento = IdProcedimiento.of("xxxxx");
        IdRetoque idRetoque = IdRetoque.of("fffff");
        Cambios cambios = new Cambios("Cambio 1, Cambio 2");
        Capas capas = new Capas("Capa 1, Capa 2");
        Filtros filtros = new Filtros("Desvanecido, Desenfoque Gausiano");

        var command = new AgregarRetoque(idProcedimiento, idRetoque, cambios, capas, filtros);
        var useCase = new AgregarRetoqueUseCase();

        when(repository.getEventsBy("xxxxx")).thenReturn(fullRetoquesEvents());
        useCase.addRepository(repository);

        //act
        Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor(idProcedimiento.value())
                    .syncExecutor(useCase, new RequestCommand<>(command))
                    .orElseThrow();
        });
    }

    private List<DomainEvent> events() {
        return  List.of(new ProcedimientoCreado(
                new Fecha(new Date())
        ));
    }

    private List<DomainEvent> fullRetoquesEvents() {
        return  List.of(new ProcedimientoCreado(
                        new Fecha(new Date())
                ),
                new RetoqueAgregado(
                        IdRetoque.of("1"),
                        new Cambios("Cambio 1, Cambio 2"),
                        new Capas("Capa 1, Capa 2"),
                        new Filtros("Desvanecido, Desenfoque Gausiano")
                ),
                new RetoqueAgregado(
                        IdRetoque.of("2"),
                        new Cambios("Cambio 1, Cambio 2, Cambio 3"),
                        new Capas("Capa 1"),
                        new Filtros("Desvanecido")
                ),
                new RetoqueAgregado(
                        IdRetoque.of("3"),
                        new Cambios("Cambio 1"),
                        new Capas("Capa 1, Capa 2"),
                        new Filtros("Desvanecido, Desenfoque Gausiano")
                ),
                new RetoqueAgregado(
                        IdRetoque.of("4"),
                        new Cambios("Cambio 1, Cambio 2, Cambio 3"),
                        new Capas("Capa 1, Capa 2"),
                        new Filtros("Desvanecido")
                ),
                new RetoqueAgregado(
                        IdRetoque.of("5"),
                        new Cambios("Cambio 1"),
                        new Capas("Capa 1"),
                        new Filtros("Desvanecido, Desenfoque Gausiano")
                ),
                new RetoqueAgregado(
                        IdRetoque.of("6"),
                        new Cambios("Cambio 1, Cambio 2"),
                        new Capas("Capa 1, Capa 2"),
                        new Filtros("Desvanecido, Desenfoque Gausiano")
                )
        );
    }
}