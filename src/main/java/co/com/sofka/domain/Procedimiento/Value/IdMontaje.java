package co.com.sofka.domain.Procedimiento.Value;

import co.com.sofka.domain.generic.Identity;

public class IdMontaje extends Identity {
    public IdMontaje() {}

    private IdMontaje(String id) {
        super(id);
    }

    public static IdMontaje of(String id) {
        return new IdMontaje(id);
    }
}
