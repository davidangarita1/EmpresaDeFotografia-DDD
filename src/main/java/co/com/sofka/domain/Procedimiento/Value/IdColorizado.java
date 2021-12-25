package co.com.sofka.domain.Procedimiento.Value;

import co.com.sofka.domain.generic.Identity;

public class IdColorizado extends Identity {
    public IdColorizado() {}

    private IdColorizado(String id) {
        super(id);
    }

    public static IdColorizado of(String id) {
        return new IdColorizado(id);
    }
}
