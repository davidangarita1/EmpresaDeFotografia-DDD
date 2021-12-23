package co.com.sofka.domain.Retocador.Value;
import co.com.sofka.domain.generic.Identity;

public class IdRetocador extends Identity{

    public IdRetocador(){}

    private IdRetocador(String id){
        super(id);
    }

    public static IdRetocador of(String id){
        return new IdRetocador(id);
    }
}
