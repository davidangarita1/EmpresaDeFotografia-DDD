package co.com.sofka.domain.Generico;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PerfilDeColor implements ValueObject<String> {
    private final String value;

    public PerfilDeColor(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El Perfil de color no puede estar vacio");
        }
        if (this.value.length() <= 1){
            throw new IllegalArgumentException("Debe de tener mas de 1 caracter");
        }
        if (this.value.length() >= 30){
            throw new IllegalArgumentException("Debe ser menor a 30 caracteres");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PerfilDeColor that = (PerfilDeColor) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
