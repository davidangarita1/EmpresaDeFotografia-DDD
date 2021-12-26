package co.com.sofka.useCases.Requerimiento;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.Requerimiento.Command.AgregarRevision;
import co.com.sofka.domain.Requerimiento.Requerimiento;

public class AgregarRevisionUseCase extends UseCase<RequestCommand<AgregarRevision>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarRevision> requestCommand) {
        var command = requestCommand.getCommand();
        var requerimiento = Requerimiento.from(command.getIdRequerimiento(), retrieveEvents());

        if (requerimiento.revisiones().size() >= 3){
            throw new BusinessException(command.getIdRequerimiento().value(), "Solo puedes tener 3 revisiones");
        }

        requerimiento.agregarRevision(command.getIdRevision(), command.getFecha(), command.getDescripcion());

        emit().onResponse(new ResponseEvents(requerimiento.getUncommittedChanges()));
    }
}
