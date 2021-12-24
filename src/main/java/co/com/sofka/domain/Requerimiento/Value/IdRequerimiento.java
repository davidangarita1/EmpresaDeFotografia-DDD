package co.com.sofka.domain.Requerimiento.Value;

import co.com.sofka.domain.generic.Identity;

public class IdRequerimiento extends Identity {
    public IdRequerimiento(){}

    private IdRequerimiento(String id) {
        super(id);
    }

    public static IdRequerimiento of(String id) {
        return new IdRequerimiento(id);
    }
}
