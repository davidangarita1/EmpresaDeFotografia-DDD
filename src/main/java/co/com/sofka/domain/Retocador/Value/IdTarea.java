package co.com.sofka.domain.Retocador.Value;

import co.com.sofka.domain.generic.Identity;

public class IdTarea extends Identity {

    public IdTarea(){}

    private IdTarea(String id) {
        super(id);
    }

    public static IdTarea of(String id) {
        return new IdTarea(id);
    }
}
