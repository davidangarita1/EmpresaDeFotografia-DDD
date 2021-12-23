package co.com.sofka.domain.Retocador.Value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Formato implements ValueObject<String> {
    private final String value;

    public Formato(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El formato no puede estar vacio");
        }
        if (this.value.length() <= 1){
            throw new IllegalArgumentException("Debe de tener mas de 1 caracter");
        }
        if (this.value.length() >= 10){
            throw new IllegalArgumentException("Debe ser menor a 10 caracteres");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formato that = (Formato) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
