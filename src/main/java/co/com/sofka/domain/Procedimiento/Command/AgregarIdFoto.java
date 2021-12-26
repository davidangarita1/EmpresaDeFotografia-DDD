package co.com.sofka.domain.Procedimiento.Command;

import co.com.sofka.domain.Procedimiento.Value.IdProcedimiento;
import co.com.sofka.domain.Retocador.Value.IdFoto;
import co.com.sofka.domain.generic.Command;

public class AgregarIdFoto extends Command {
    private final IdProcedimiento idProcedimiento;
    private final IdFoto idFoto;

    public AgregarIdFoto(IdProcedimiento idProcedimiento, IdFoto idFoto){
        this.idProcedimiento = idProcedimiento;
        this.idFoto = idFoto;
    }

    public IdProcedimiento getIdProcedimiento() {
        return idProcedimiento;
    }

    public IdFoto getIdFoto() {
        return idFoto;
    }
}
