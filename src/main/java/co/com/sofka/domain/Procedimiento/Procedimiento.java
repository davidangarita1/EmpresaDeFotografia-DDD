package co.com.sofka.domain.Procedimiento;

import co.com.sofka.domain.Generico.Fecha;
import co.com.sofka.domain.Procedimiento.Value.IdProcedimiento;
import co.com.sofka.domain.Retocador.Value.IdFoto;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Set;

public class Procedimiento extends AggregateEvent<IdProcedimiento> {
    protected Fecha fecha;
    protected Set<IdFoto> idFotos;
    protected Set<Retoque> retoques;
    protected Set<Montaje> montajes;
    protected Set<Colorizado> colorizados;

    public Procedimiento(IdProcedimiento entityId, Fecha fecha) {
        super(entityId);
        appendChange(new ProcedimientoCreado(fecha)).apply();
    }

    public Procedimiento(IdProcedimiento entityId) {
        super(entityId);
        subscribe(new ProcedimientoChange(this));
    }

    public static Procedimiento from(IdProcedimiento idProcedimiento, List<DomainEvent> events){
        var procedimiento = new Procedimiento(idProcedimiento);
        events.forEach(procedimiento::applyEvent);
        return procedimiento;
    }

    public void agregarIdFoto(){}
    public void actualizarFecha(){}
    public void agregarRetoque(){}
    public void agregarMontaje(){}
    public void agregarColorizado(){}
    public void actualizarCambiosDeColorizado(){}
    public void actualizarPerfilDeColorDeColorizado(){}
    public void actualizarCambiosDeMontaje(){}
    public void actualizarFondoDeMontaje(){}
    public void actualizarCambiosDeRetoque(){}
    public void actualizarCapasDeRetoque(){}
    public void actualizarFiltrosDeRetoque(){}
}
