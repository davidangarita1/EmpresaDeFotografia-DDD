package co.com.sofka.useCases.Retocador;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.Retocador.Command.CrearRetocador;
import co.com.sofka.domain.Retocador.Retocador;

public class CrearRetocadorUseCase extends UseCase<RequestCommand<CrearRetocador>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearRetocador> crearRetocadorRequestCommand) {
        var command = crearRetocadorRequestCommand.getCommand();

        Retocador retocador;

        retocador = new Retocador(
                command.getEntityId(),
                command.getNombre()
        );

        emit().onResponse(new ResponseEvents(retocador.getUncommittedChanges()));
    }
}
