package compilador;

/**
 *
 * @author Jesús
 * Arbol de identificadores
 */
public class identificadores {
    nodo inicio;
    nodo fin;
    
    
    
    public void nuevo(nodo nuevo){
        if(inicio == null){
            inicio = nuevo;
            fin = nuevo;
        }else{
                fin.sig = nuevo;
                fin = nuevo;
        }
    }
    //Buscar identificador
    public boolean buscarId(String nom){
        
        nodo actual = inicio;
        
        if(inicio==null){
            return false;
        }
        
        do {
            if (actual.nombre.equals(nom)) {
                return true;
            }
            
            actual = actual.sig;
            
        } while (actual != null);
        
        return false;
        
        
    }
    //imprimir todos los identificadores
    public void impIdent(){
        if(inicio == null){
            System.out.println("no hay identificadores");
        }else{
            nodo actual = inicio;
        
            do {
                System.out.println(actual.nombre + " " + actual.valor + " " + actual.tipo+ " " + actual.id);
            
                actual = actual.sig;
            
            }while(actual != null);
        }
    }
    
    //obetener el valor del identificador, por el nombre
    public String valorId(String nom){
        nodo actual = inicio;
        
        do {
            if (actual.nombre.equals(nom)) {
                return actual.valor;
            }
            
            actual = actual.sig;
            
        } while (actual != null);
        
        return null;
    }
    //asignar valor a un identificador, por nombre
    public void asigVal(String valor, String nom){
        nodo actual = inicio;
        
        do {
            if (actual.nombre.equals(nom)) {
                actual.valor = valor;
            }
            
            actual = actual.sig;
            
        } while (actual != null);
    }
    
    
    //Obtener del tipo del identificador, por el nombre
    public String obtTipo(String nom){
        nodo actual = inicio;
        
        do {
            if (actual.nombre.equals(nom)) {
                return actual.tipo;
            }
            
            actual = actual.sig;
            
        } while (actual != null);
        
        return null;
    }
}
