package co.com.sofka.domain.Requerimiento.Value;

import co.com.sofka.domain.generic.Identity;

public class IdCliente extends Identity {

    public IdCliente(){}

    private IdCliente(String id) {
        super(id);
    }

    public static IdCliente of(String id) {
        return new IdCliente(id);
    }
}
