package co.com.sofka.domain.Retocador.Event;

import co.com.sofka.domain.Retocador.Value.Formato;
import co.com.sofka.domain.Retocador.Value.IdFoto;
import co.com.sofka.domain.generic.DomainEvent;

public class FormatoDeFotoActualizado extends DomainEvent {
    private final IdFoto idFoto;
    private final Formato formato;

    public FormatoDeFotoActualizado(IdFoto idFoto, Formato formato) {
        super("sofka.retocador.formatodefotoactualziado");
        this.idFoto = idFoto;
        this.formato = formato;
    }

    public IdFoto getIdFoto() {
        return idFoto;
    }

    public Formato getFormato() {
        return formato;
    }
}
