package co.com.sofka.useCases.Requerimiento;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Generico.Fecha;
import co.com.sofka.domain.Generico.Nombre;
import co.com.sofka.domain.Requerimiento.Command.CrearRequerimiento;
import co.com.sofka.domain.Requerimiento.Event.RequerimientoCreado;
import co.com.sofka.domain.Requerimiento.Value.IdRequerimiento;
import co.com.sofka.domain.Retocador.Command.CrearRetocador;
import co.com.sofka.domain.Retocador.Event.RetocadorCreado;
import co.com.sofka.domain.Retocador.Value.IdRetocador;
import co.com.sofka.useCases.Retocador.CrearRetocadorUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CrearRequerimientoUseCaseTest {
    @Test
    void crearRequerimientoUseCaseTest(){

        //arrange
        IdRequerimiento idRequerimiento = IdRequerimiento.of("xxxx");
        Fecha fecha = new Fecha(new Date());

        var command = new CrearRequerimiento(idRequerimiento, fecha);
        var useCase = new CrearRequerimientoUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts
        RequerimientoCreado event = (RequerimientoCreado)events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals(fecha.value(), event.getFecha().value());
    }
}