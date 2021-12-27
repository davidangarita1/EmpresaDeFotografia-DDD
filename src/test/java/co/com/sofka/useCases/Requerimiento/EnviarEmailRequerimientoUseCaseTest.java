package co.com.sofka.useCases.Requerimiento;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.Generico.Fecha;
import co.com.sofka.domain.Requerimiento.Event.RequerimientoCreado;
import co.com.sofka.domain.Requerimiento.Value.IdRequerimiento;
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
class EnviarEmailRequerimientoUseCaseTest {
    @Mock
    EnviarEmailRequerimientoService requerimientoService;

    @Test
    void enviarCorreoRequerimiento(){

        //arrange
        IdRequerimiento idRequerimiento = IdRequerimiento.of("xxxx");
        Fecha fecha = new Fecha(new Date());

        var event = new RequerimientoCreado(fecha);
        event.setAggregateRootId(idRequerimiento.value());
        var useCase = new EnviarEmailRequerimientoUseCase();

        when(requerimientoService.send(
                refEq(idRequerimiento),
                eq("prueba@pixelphotography.com"),
                eq("Se creo un nuevo requerimiento con la fecha " + fecha.value())
        )).thenReturn(true);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(requerimientoService);
        useCase.addServiceBuilder(builder);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow();

        verify(requerimientoService).send(
                idRequerimiento,
                "prueba@pixelphotography.com",
                "Se creo un nuevo requerimiento con la fecha " + fecha.value()
        );
    }
}