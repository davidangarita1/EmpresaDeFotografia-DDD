package co.com.sofka.domain.Procedimiento.Value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Fondo implements ValueObject<String> {
    private final String value;

    public Fondo(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("La ruta del fondo no puede estar vacio");
        }
        if (this.value.length() <= 1){
            throw new IllegalArgumentException("La ruta debe de tener mas de 1 caracter");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fondo that = (Fondo) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
