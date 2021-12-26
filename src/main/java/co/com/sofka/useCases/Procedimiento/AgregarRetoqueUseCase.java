package co.com.sofka.useCases.Procedimiento;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.Procedimiento.Command.AgregarRetoque;
import co.com.sofka.domain.Procedimiento.Procedimiento;

public class AgregarRetoqueUseCase extends UseCase<RequestCommand<AgregarRetoque>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarRetoque> requestCommand) {
        var command = requestCommand.getCommand();
        var procedimiento = Procedimiento.from(command.getIdProcedimiento(), retrieveEvents());

        if (procedimiento.retoques().size() >= 5){
            throw new BusinessException(command.getIdProcedimiento().value(), "Solo puedes tener 5 retoques");
        }

        procedimiento.agregarRetoque(command.getIdRetoque(), command.getCambios(), command.getCapas(), command.getFiltros());

        emit().onResponse(new ResponseEvents(procedimiento.getUncommittedChanges()));
    }
}
