package compilador;

/**
 *
 * @author Paola y Jesús
 */
public class nodoNum {
    
    String valor;
    String id;
    nodoNum sig;

    public nodoNum(String val, String id) {
        
        valor = val;
        this.id = id;
        
    }
}
