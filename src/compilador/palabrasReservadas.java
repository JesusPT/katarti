package compilador;

/**
 *
 * @author Jesús
 */
public class palabrasReservadas {
    //arreglo de palabras reservadas
    String pr[][] =      {{"arit",""},
                          {"epi",""},
                          {"lexi",""},
                          {"diplo",""},
                          {"odigi",""},
                          {"nai",""},
                          {"allios",""},
                          {"na",""},
                          {"eno",""},
                          {"pol",""},
                          {"at",""},
                          {"ar,",""},
                          {"se",""},
                          {"exo",""}
        };
    //bandera de existencia
    boolean existe;
    //buscar el token en el arreglo de palabras reservadas
    public boolean buscarPalabra(String a){
        
        for (int i = 0; i < pr.length; i++) {
            if(pr[i][0].equals(a)){
                existe = true;
                break;
            }
            else
                existe = false;
        }
        
        return existe;
    }
    
}
