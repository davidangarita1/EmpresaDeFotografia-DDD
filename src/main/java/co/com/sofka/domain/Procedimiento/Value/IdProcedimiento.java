package co.com.sofka.domain.Procedimiento.Value;

import co.com.sofka.domain.generic.Identity;

public class IdProcedimiento extends Identity {
    public IdProcedimiento() {}

    private IdProcedimiento(String id) {
        super(id);
    }

    public static IdProcedimiento of(String id) {
        return new IdProcedimiento(id);
    }
}
