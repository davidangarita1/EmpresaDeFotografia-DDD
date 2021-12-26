package co.com.sofka.useCases.Retocador;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.Generico.Descripcion;
import co.com.sofka.domain.Generico.Nombre;
import co.com.sofka.domain.Retocador.Command.ActualizarCaracteristicaDeFuncion;
import co.com.sofka.domain.Retocador.Retocador;
import co.com.sofka.domain.Retocador.Value.Caracteristica;
import co.com.sofka.domain.Retocador.Value.IdFuncion;
import co.com.sofka.domain.Retocador.Value.IdRetocador;

public class ActualizarCaracteristicaDeFuncionUseCase extends UseCase<RequestCommand<ActualizarCaracteristicaDeFuncion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarCaracteristicaDeFuncion> requestCommand) {

        var command = requestCommand.getCommand();

        Retocador retocador;

        retocador = Retocador.from(command.getIdRetocador(), retrieveEvents());

        retocador.actualizarCaracteristicaDeFuncion(command.getIdFuncion(), command.getCaracteristica());

        emit().onResponse(new ResponseEvents(retocador.getUncommittedChanges()));
    }
}
