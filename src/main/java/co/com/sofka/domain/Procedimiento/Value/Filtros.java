package co.com.sofka.domain.Procedimiento.Value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Filtros implements ValueObject<String> {
    private final String value;

    public Filtros(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("Los filtros no pueden estar vacios");
        }
        if (this.value.length() <= 3){
            throw new IllegalArgumentException("Deben de tener mas de 3 caracteres");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filtros that = (Filtros) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
