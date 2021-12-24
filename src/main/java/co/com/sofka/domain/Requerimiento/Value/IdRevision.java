package co.com.sofka.domain.Requerimiento.Value;

import co.com.sofka.domain.generic.Identity;

public class IdRevision extends Identity {
    public IdRevision(){}

    private IdRevision(String id) {
        super(id);
    }

    public static IdRevision of(String id) {
        return new IdRevision(id);
    }
}
