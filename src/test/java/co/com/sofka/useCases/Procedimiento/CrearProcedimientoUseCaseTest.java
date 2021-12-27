package co.com.sofka.useCases.Procedimiento;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Generico.Fecha;
import co.com.sofka.domain.Procedimiento.Command.CrearProcedimiento;
import co.com.sofka.domain.Procedimiento.Event.ProcedimientoCreado;
import co.com.sofka.domain.Procedimiento.Value.IdProcedimiento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CrearProcedimientoUseCaseTest {
    @Test
    void crearProcedimientoUseCaseTest(){

        //arrange
        IdProcedimiento idProcedimiento = IdProcedimiento.of("xxxx");
        Fecha fecha = new Fecha(new Date());

        var command = new CrearProcedimiento(idProcedimiento, fecha);
        var useCase = new CrearProcedimientoUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts
        ProcedimientoCreado event = (ProcedimientoCreado)events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals(fecha.value(), event.getFecha().value());
    }
}