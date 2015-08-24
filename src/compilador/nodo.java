package compilador;

/**
 *
 * @author Jesús
 */
public class nodo {
    String nombre;
    String tipo;
    String valor;
    String id;
    nodo sig;

    public nodo(String nom, String tipo, String val, String id) {
        nombre = nom;
        this.tipo = tipo;
        valor = val;
        this.id = id;
        
    }
}
