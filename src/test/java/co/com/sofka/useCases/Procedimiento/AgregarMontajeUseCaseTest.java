package co.com.sofka.useCases.Procedimiento;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Generico.Fecha;
import co.com.sofka.domain.Procedimiento.Command.AgregarMontaje;
import co.com.sofka.domain.Procedimiento.Event.MontajeAgregado;
import co.com.sofka.domain.Procedimiento.Event.ProcedimientoCreado;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarMontajeUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @Test
    void agregarMontaje(){

        //arrange
        IdProcedimiento idProcedimiento = IdProcedimiento.of("xxx");
        IdMontaje idMontaje = IdMontaje.of("fff");
        Cambios cambios = new Cambios("Cambio 1, Cambio 2");
        Fondo fondo = new Fondo("/images/background.jpg");

        var command = new AgregarMontaje(idProcedimiento, idMontaje, cambios, fondo);
        var useCase = new AgregarMontajeUseCase();

        when(repository.getEventsBy("xxx")).thenReturn(events());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idProcedimiento.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts
        var event = (MontajeAgregado) events.getDomainEvents().get(0);

        Assertions.assertEquals("Cambio 1, Cambio 2", event.getCambios().value());
        Assertions.assertEquals("/images/background.jpg", event.getFondo().value());
        Mockito.verify(repository).getEventsBy("xxx");
    }

    @Test
    void agregarMontaje_errorPorCantidades(){

        //arrange
        IdProcedimiento idProcedimiento = IdProcedimiento.of("xxx");
        IdMontaje idMontaje = IdMontaje.of("fff");
        Cambios cambios = new Cambios("Cambio 1, Cambio 2");
        Fondo fondo = new Fondo("/images/background.jpg");

        var command = new AgregarMontaje(idProcedimiento, idMontaje, cambios, fondo);
        var useCase = new AgregarMontajeUseCase();

        when(repository.getEventsBy("xxx")).thenReturn(fullMontajesEvents());
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

    private List<DomainEvent> fullMontajesEvents() {
        return  List.of(new ProcedimientoCreado(
                        new Fecha(new Date())
                ),
                new MontajeAgregado(
                        IdMontaje.of("1"),
                        new Cambios("Cambio 1"),
                        new Fondo("/images/imagen1.png")
                ),
                new MontajeAgregado(
                        IdMontaje.of("2"),
                        new Cambios("Cambio 1, Cambio 2"),
                        new Fondo("/images/imagen2.png")
                ),
                new MontajeAgregado(
                        IdMontaje.of("3"),
                        new Cambios("Cambio 1"),
                        new Fondo("/images/imagen3.png")
                ),
                new MontajeAgregado(
                        IdMontaje.of("4"),
                        new Cambios("Cambio 1, Cambio 2"),
                        new Fondo("/images/imagen4.png")
                )
        );
    }
}