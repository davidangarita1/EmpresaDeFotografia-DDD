package co.com.sofka.useCases.Procedimiento;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.Procedimiento.Command.AgregarMontaje;
import co.com.sofka.domain.Procedimiento.Procedimiento;

public class AgregarMontajeUseCase extends UseCase<RequestCommand<AgregarMontaje>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarMontaje> requestCommand) {
        var command = requestCommand.getCommand();
        var procedimiento = Procedimiento.from(command.getIdProcedimiento(), retrieveEvents());

        if (procedimiento.montajes().size() > 3){
            throw new BusinessException(command.getIdProcedimiento().value(), "Solo puedes tener 3 monajes");
        }

        procedimiento.agregarMontaje(command.getIdMontaje(), command.getCambios(), command.getFondo());

        emit().onResponse(new ResponseEvents(procedimiento.getUncommittedChanges()));
    }
}
