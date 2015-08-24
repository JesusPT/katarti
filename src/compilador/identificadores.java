package compilador;

/**
 *
 * @author Jesús
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
    
    public void asigVal(String valor, String nom){
        nodo actual = inicio;
        
        do {
            if (actual.nombre.equals(nom)) {
                actual.valor = valor;
            }
            
            actual = actual.sig;
            
        } while (actual != null);
    }
    
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
