package co.com.sofka.useCases.Procedimiento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.Procedimiento.Command.CrearProcedimiento;
import co.com.sofka.domain.Procedimiento.Procedimiento;

public class CrearProcedimientoUseCase extends UseCase<RequestCommand<CrearProcedimiento>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearProcedimiento> crearProcedimientoRequestCommand) {
        var command = crearProcedimientoRequestCommand.getCommand();

        Procedimiento procedimiento;

        procedimiento = new Procedimiento(
                command.getIdProcedimiento(),
                command.getFecha()
        );

        emit().onResponse(new ResponseEvents(procedimiento.getUncommittedChanges()));
    }
}
