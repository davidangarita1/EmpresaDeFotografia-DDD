package co.com.sofka.useCases.Procedimiento;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.Generico.Fecha;
import co.com.sofka.domain.Procedimiento.Event.ProcedimientoCreado;
import co.com.sofka.domain.Procedimiento.Value.IdProcedimiento;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EnviarEmailProcedimientoUseCaseTest {
    @Mock
    EnviarEmailProcedimientoService procedimientoService;

    @Test
    void enviarCorreoProcedimiento(){

        //arrange
        IdProcedimiento idProcedimiento = IdProcedimiento.of("xxxx");
        Fecha fecha = new Fecha(new Date());

        var event = new ProcedimientoCreado(fecha);
        event.setAggregateRootId(idProcedimiento.value());
        var useCase = new EnviarEmailProcedimientoUseCase();

        when(procedimientoService.send(
                refEq(idProcedimiento),
                eq("prueba@pixelphotography.com"),
                eq("Se creo un nuevo procedimiento con la fecha "+fecha.value())
        )).thenReturn(true);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(procedimientoService);
        useCase.addServiceBuilder(builder);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow();

        verify(procedimientoService).send(
                idProcedimiento,
                "prueba@pixelphotography.com",
                "Se creo un nuevo procedimiento con la fecha "+fecha.value()
                );
    }
}