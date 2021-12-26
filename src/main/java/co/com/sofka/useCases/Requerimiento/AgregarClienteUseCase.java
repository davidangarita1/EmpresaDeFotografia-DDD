package co.com.sofka.useCases.Requerimiento;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.Requerimiento.Command.AgregarCliente;
import co.com.sofka.domain.Requerimiento.Requerimiento;

public class AgregarClienteUseCase extends UseCase<RequestCommand<AgregarCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarCliente> requestCommand) {
        var command = requestCommand.getCommand();
        var requerimiento = Requerimiento.from(command.getIdRequerimiento(), retrieveEvents());

        if (requerimiento.clientes().size() > 1){
            throw new BusinessException(command.getIdRequerimiento().value(), "Solo puedes tener 1 cliente por requerimiento");
        }

        requerimiento.agregarCliente(command.getIdCliente(), command.getNombre());

        emit().onResponse(new ResponseEvents(requerimiento.getUncommittedChanges()));
    }
}
