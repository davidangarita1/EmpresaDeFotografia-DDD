package co.com.sofka.useCases.Requerimiento;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.Requerimiento.Event.RequerimientoCreado;
import co.com.sofka.domain.Requerimiento.Value.IdRequerimiento;

import java.util.List;

public class EnviarEmailRequerimientoUseCase  extends UseCase<TriggeredEvent<RequerimientoCreado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<RequerimientoCreado> triggeredEvent) {
        var event = triggeredEvent.getDomainEvent();
        var service = getService(EnviarEmailRequerimientoService.class).orElseThrow();

        boolean isValid = service.send(
                IdRequerimiento.of(event.aggregateRootId()),
                "prueba@pixelphotography.com",
                "Se creo un nuevo requerimiento con la fecha " + event.getFecha().value()
        );
        if(!isValid){
            throw new BusinessException(event.aggregateRootId(), "No se pudo enviar el correo");
        }
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
