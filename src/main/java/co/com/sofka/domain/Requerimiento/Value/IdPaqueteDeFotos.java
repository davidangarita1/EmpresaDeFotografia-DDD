package co.com.sofka.domain.Requerimiento.Value;

import co.com.sofka.domain.generic.Identity;

public class IdPaqueteDeFotos extends Identity {
    public IdPaqueteDeFotos(){}

    private IdPaqueteDeFotos(String id) {
        super(id);
    }

    public static IdPaqueteDeFotos of(String id) {
        return new IdPaqueteDeFotos(id);
    }
}
