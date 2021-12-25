package co.com.sofka.domain.Procedimiento;

import co.com.sofka.domain.Procedimiento.Value.Cambios;
import co.com.sofka.domain.Procedimiento.Value.Fondo;
import co.com.sofka.domain.Procedimiento.Value.IdMontaje;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Montaje extends Entity<IdMontaje> {
    private Cambios cambios;
    private Fondo fondo;

    public Montaje(IdMontaje entityId, Cambios cambios, Fondo fondo) {
        super(entityId);
        this.cambios = cambios;
        this.fondo = fondo;
    }

    public void actualizarCambios(Cambios cambios){
        this.cambios = Objects.requireNonNull(cambios);
    }

    public void actualizarFondo(Fondo fondo){
        this.fondo =  Objects.requireNonNull(fondo);
    }

    public Cambios cambios() {
        return cambios;
    }

    public Fondo fondo() {
        return fondo;
    }
}
