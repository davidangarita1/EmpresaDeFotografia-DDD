package co.com.sofka.useCases.Requerimiento;

import co.com.sofka.domain.Requerimiento.Value.IdRequerimiento;

public interface EnviarEmailRequerimientoService {
    boolean send(IdRequerimiento idRequerimiento, String email, String body);
}
