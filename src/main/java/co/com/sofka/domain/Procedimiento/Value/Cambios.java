package co.com.sofka.domain.Procedimiento.Value;

import co.com.sofka.domain.generic.ValueObject;
import java.util.Objects;

public class Cambios implements ValueObject<String> {
    private final String value;

    public Cambios(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("Los cambios no pueden estar vacios");
        }
        if (this.value.length() <= 3){
            throw new IllegalArgumentException("Debe de tener mas de 3 caracteres");
        }
        if (this.value.length() >= 180){
            throw new IllegalArgumentException("Debe ser menor a 180 caracteres");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cambios that = (Cambios) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
