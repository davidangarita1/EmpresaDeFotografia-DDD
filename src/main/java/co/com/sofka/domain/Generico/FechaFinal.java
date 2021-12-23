package co.com.sofka.domain.Generico;

import co.com.sofka.domain.generic.ValueObject;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

public class FechaFinal implements ValueObject<Date> {
    private final Date value;

    public FechaFinal(Date value) {
        this.value = Objects.requireNonNull(value, "La fecha no puede ser null");
        if(value.before(new Date(Instant.now().toEpochMilli()))){
            throw new IllegalArgumentException("No puede colocar una fecha del pasado");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FechaFinal fecha = (FechaFinal) o;
        return Objects.equals(value, fecha.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public Date value() {
        return value;
    }
}
