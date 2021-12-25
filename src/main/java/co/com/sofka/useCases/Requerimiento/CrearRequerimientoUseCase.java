package co.com.sofka.useCases.Requerimiento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.Requerimiento.Command.CrearRequerimiento;
import co.com.sofka.domain.Requerimiento.Requerimiento;

public class CrearRequerimientoUseCase extends UseCase<RequestCommand<CrearRequerimiento>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearRequerimiento> crearRequerimientoRequestCommand) {
        var command = crearRequerimientoRequestCommand.getCommand();

        Requerimiento requerimiento;

        requerimiento = new Requerimiento(
                command.getIdRequerimiento(),
                command.getFecha()
        );

        emit().onResponse(new ResponseEvents(requerimiento.getUncommittedChanges()));
    }
}
