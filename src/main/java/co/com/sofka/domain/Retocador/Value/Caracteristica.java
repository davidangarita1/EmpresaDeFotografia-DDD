package co.com.sofka.domain.Retocador.Value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Caracteristica implements ValueObject<String> {
    private final String value;

    public Caracteristica(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("La caracteristica no puede estar vacia");
        }
        if (this.value.length() <= 5){
            throw new IllegalArgumentException("Debe de tener mas de 5 caracteres");
        }
        if (this.value.length() >= 50){
            throw new IllegalArgumentException("Debe ser menor a 50 caracteres");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caracteristica that = (Caracteristica) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
