package co.com.sofka.useCases.Procedimiento;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.Procedimiento.Command.AgregarColorizado;
import co.com.sofka.domain.Procedimiento.Procedimiento;

public class AgregarColorizadoUseCase extends UseCase<RequestCommand<AgregarColorizado>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarColorizado> requestCommand) {
        var command = requestCommand.getCommand();
        var procedimiento = Procedimiento.from(command.getIdProcedimiento(), retrieveEvents());

        if (procedimiento.colorizados().size() >= 5){
            throw new BusinessException(command.getIdProcedimiento().value(), "Solo puedes tener 5 colorizados");
        }

        procedimiento.agregarColorizado(command.getIdColorizado(), command.getCambios(), command.getPerfilDeColor());

        emit().onResponse(new ResponseEvents(procedimiento.getUncommittedChanges()));
    }
}
