package co.com.sofka.useCases.Procedimiento;

import co.com.sofka.domain.Procedimiento.Value.IdProcedimiento;

public interface EnviarEmailProcedimientoService {
    boolean send(IdProcedimiento idProcedimiento, String email, String body);
}
