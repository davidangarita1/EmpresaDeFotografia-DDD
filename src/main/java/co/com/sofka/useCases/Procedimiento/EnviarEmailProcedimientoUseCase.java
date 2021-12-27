package co.com.sofka.useCases.Procedimiento;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.Procedimiento.Event.ProcedimientoCreado;
import co.com.sofka.domain.Procedimiento.Value.IdProcedimiento;

import java.util.List;

public class EnviarEmailProcedimientoUseCase extends UseCase<TriggeredEvent<ProcedimientoCreado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<ProcedimientoCreado> triggeredEvent) {
        var event = triggeredEvent.getDomainEvent();
        var service = getService(EnviarEmailProcedimientoService.class).orElseThrow();

        boolean isValid = service.send(
                IdProcedimiento.of(event.aggregateRootId()),
                "prueba@pixelphotography.com",
                "Se creo un nuevo procedimiento con la fecha " + event.getFecha().value()
        );
        if(!isValid){
            throw new BusinessException(event.aggregateRootId(), "No se pudo enviar el correo");
        }
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
