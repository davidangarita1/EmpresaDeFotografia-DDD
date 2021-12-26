package co.com.sofka.useCases.Procedimiento;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Generico.Fecha;
import co.com.sofka.domain.Generico.PerfilDeColor;
import co.com.sofka.domain.Procedimiento.Command.AgregarColorizado;
import co.com.sofka.domain.Procedimiento.Event.ColorizadoAgregado;
import co.com.sofka.domain.Procedimiento.Event.ProcedimientoCreado;
import co.com.sofka.domain.Procedimiento.Value.Cambios;
import co.com.sofka.domain.Procedimiento.Value.IdColorizado;
import co.com.sofka.domain.Procedimiento.Value.IdProcedimiento;
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
class AgregarColorizadoUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarColorizado(){

        //arrange
        IdProcedimiento idProcedimiento = IdProcedimiento.of("xxxxx");
        IdColorizado idColorizado = IdColorizado.of("fffff");
        Cambios cambios = new Cambios("Cambio 1, Cambio 2");
        PerfilDeColor perfilDeColor = new PerfilDeColor("CMYK");

        var command = new AgregarColorizado(idProcedimiento, idColorizado, cambios, perfilDeColor);
        var useCase = new AgregarColorizadoUseCase();

        when(repository.getEventsBy("xxxxx")).thenReturn(events());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idProcedimiento.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts
        var event = (ColorizadoAgregado) events.getDomainEvents().get(0);

        Assertions.assertEquals("Cambio 1, Cambio 2", event.getCambios().value());
        Assertions.assertEquals("CMYK", event.getPerfilDeColor().value());
        Mockito.verify(repository).getEventsBy("xxxxx");
    }

    @Test
    void agregarColorizado_errorPorCantidades(){

        //arrange
        IdProcedimiento idProcedimiento = IdProcedimiento.of("xxxxx");
        IdColorizado idColorizado = IdColorizado.of("fffff");
        Cambios cambios = new Cambios("Cambio 1, Cambio 2");
        PerfilDeColor perfilDeColor = new PerfilDeColor("CMYK");

        var command = new AgregarColorizado(idProcedimiento, idColorizado, cambios, perfilDeColor);
        var useCase = new AgregarColorizadoUseCase();

        when(repository.getEventsBy("xxxxx")).thenReturn(fullColorizadosEvents());
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

    private List<DomainEvent> fullColorizadosEvents() {
        return  List.of(new ProcedimientoCreado(
                new Fecha(new Date())
        ),
                new ColorizadoAgregado(
                        IdColorizado.of("1"),
                        new Cambios("Cambio de color de ojos"),
                        new PerfilDeColor("RBG")
                ),
                new ColorizadoAgregado(
                        IdColorizado.of("2"),
                        new Cambios("Cambio de color de prenda"),
                        new PerfilDeColor("RBG")
                ),
                new ColorizadoAgregado(
                        IdColorizado.of("3"),
                        new Cambios("Cambio de color de Fondo"),
                        new PerfilDeColor("RBG")
                ),
                new ColorizadoAgregado(
                        IdColorizado.of("4"),
                        new Cambios("Cambio de color de Mueble"),
                        new PerfilDeColor("RBG")
                ),
                new ColorizadoAgregado(
                        IdColorizado.of("5"),
                        new Cambios("Cambio de color de Uñas"),
                        new PerfilDeColor("RBG")
                ),
                new ColorizadoAgregado(
                        IdColorizado.of("6"),
                        new Cambios("Cambio de color de Zapatos"),
                        new PerfilDeColor("RBG")
                )
        );
    }
}