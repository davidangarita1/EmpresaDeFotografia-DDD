package co.com.sofka.domain.Procedimiento.Value;

import co.com.sofka.domain.generic.Identity;

public class IdRetoque extends Identity {
    public IdRetoque() {}

    private IdRetoque(String id) {
        super(id);
    }

    public static IdRetoque of(String id) {
        return new IdRetoque(id);
    }
}
