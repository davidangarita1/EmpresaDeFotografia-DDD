package co.com.sofka.useCases.Requerimiento;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Generico.Descripcion;
import co.com.sofka.domain.Generico.Fecha;
import co.com.sofka.domain.Requerimiento.Command.AgregarRevision;
import co.com.sofka.domain.Requerimiento.Event.RequerimientoCreado;
import co.com.sofka.domain.Requerimiento.Event.RevisionAgregada;
import co.com.sofka.domain.Requerimiento.Value.IdRequerimiento;
import co.com.sofka.domain.Requerimiento.Value.IdRevision;
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
class AgregarRevisionUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarRevision(){

        //arrange
        IdRequerimiento idRequerimiento = IdRequerimiento.of("xxxxx");
        IdRevision idRevision = IdRevision.of("fffff");
        Fecha fecha = new Fecha(new Date());
        Descripcion descripcion = new Descripcion("Descripción de prueba");

        var command = new AgregarRevision(idRequerimiento, idRevision, fecha, descripcion);
        var useCase = new AgregarRevisionUseCase();

        when(repository.getEventsBy("xxxxx")).thenReturn(events());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idRequerimiento.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts
        var event = (RevisionAgregada) events.getDomainEvents().get(0);

        Assertions.assertEquals(fecha.value(), event.getFecha().value());
        Assertions.assertEquals("Descripción de prueba", event.getDescripcion().value());
        Mockito.verify(repository).getEventsBy("xxxxx");
    }

    @Test
    void agregarRevision_errorPorCantidades(){

        //arrange
        IdRequerimiento idRequerimiento = IdRequerimiento.of("xxxxx");
        IdRevision idRevision = IdRevision.of("fffff");
        Fecha fecha = new Fecha(new Date());
        Descripcion descripcion = new Descripcion("Descripción de prueba");

        var command = new AgregarRevision(idRequerimiento, idRevision, fecha, descripcion);
        var useCase = new AgregarRevisionUseCase();

        when(repository.getEventsBy("xxxxx")).thenReturn(fullRevisionesEvents());
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

    private List<DomainEvent> fullRevisionesEvents() {
        return  List.of(new RequerimientoCreado(
                        new Fecha(new Date())
                ),
                new RevisionAgregada(
                        IdRevision.of("1"),
                        new Fecha(new Date()),
                        new Descripcion("Descripción de prueba 1")
                ),
                new RevisionAgregada(
                        IdRevision.of("2"),
                        new Fecha(new Date()),
                        new Descripcion("Descripción de prueba 2")
                ),
                new RevisionAgregada(
                        IdRevision.of("3"),
                        new Fecha(new Date()),
                        new Descripcion("Descripción de prueba 3")
                ),
                new RevisionAgregada(
                        IdRevision.of("4"),
                        new Fecha(new Date()),
                        new Descripcion("Descripción de prueba 4")
                )
        );
    }
}