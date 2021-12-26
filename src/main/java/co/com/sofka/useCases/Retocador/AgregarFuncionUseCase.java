package co.com.sofka.useCases.Retocador;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.Generico.Nombre;
import co.com.sofka.domain.Retocador.Command.AgregarFuncion;
import co.com.sofka.domain.Retocador.Retocador;
import co.com.sofka.domain.Retocador.Value.IdRetocador;

public class AgregarFuncionUseCase extends UseCase<RequestCommand<AgregarFuncion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarFuncion> requestCommand) {
        var command = requestCommand.getCommand();
        var retocador = Retocador.from(command.getIdRetocador(), retrieveEvents());

        retocador.agregarFuncion(
                command.getIdFuncion(),
                command.getCaracteristica(),
                command.getDescripcion()
        );

        emit().onResponse(new ResponseEvents(retocador.getUncommittedChanges()));
    }
}
