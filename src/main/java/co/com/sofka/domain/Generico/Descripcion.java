package co.com.sofka.domain.Generico;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descripcion implements ValueObject<String> {
    private final String value;

    public Descripcion(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("La descripción no puede estar vacia");
        }
        if (this.value.length() <= 5){
            throw new IllegalArgumentException("Debe de tener mas de 5 caracteres");
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
        Descripcion that = (Descripcion) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
