package compilador;

/**
 *
 * @author Jesús
 * Arbol de identificadores
 */
public class tablaNumeros {
    nodoNum inicio;
    nodoNum fin;
    
    
    
    public void nuevo(nodoNum nuevo){
        if(inicio == null){
            inicio = nuevo;
            fin = nuevo;
        }else{
                fin.sig = nuevo;
                fin = nuevo;
        }
    }
    
//imprimir todos los identificadores
    public void impNums(){
        if(inicio == null){
            System.out.println("no hay números");
        }else{
            nodoNum actual = inicio;
        
            do {
                System.out.println(actual.valor + " " + actual.id);
            
                actual = actual.sig;
            
            }while(actual != null);
        }
    }
    
    //obtener valor por id
    public String valId(String id){
        nodoNum actual = inicio;
        
        do {
            if (actual.id.equals(id)) {
                return actual.valor;
            }
            
            actual = actual.sig;
            
        } while (actual != null);
        
        return null;
    }
}
