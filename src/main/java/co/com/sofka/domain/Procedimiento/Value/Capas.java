package co.com.sofka.domain.Procedimiento.Value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Capas implements ValueObject<String> {
    private final String value;

    public Capas(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("Las capas no pueden estar vacias");
        }
        if (this.value.length() <= 3){
            throw new IllegalArgumentException("Debe de tener mas de 3 caracteres");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Capas that = (Capas) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
