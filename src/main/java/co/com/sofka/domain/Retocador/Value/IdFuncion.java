package co.com.sofka.domain.Retocador.Value;

import co.com.sofka.domain.generic.Identity;

public class IdFuncion extends Identity {

    public IdFuncion(){}

    private IdFuncion(String id) {
        super(id);
    }

    public static IdFuncion of(String id) {
        return new IdFuncion(id);
    }
}
