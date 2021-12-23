package co.com.sofka.domain.Retocador.Value;

import co.com.sofka.domain.generic.Identity;

public class IdFoto extends Identity {

    public IdFoto() {
    }

    private IdFoto(String id) {
        super(id);
    }

    public static IdFoto of(String id) {
        return new IdFoto(id);
    }
}
