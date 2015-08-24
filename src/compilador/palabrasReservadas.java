package compilador;

/**
 *
 * @author Jesús
 */
public class palabrasReservadas {
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
    boolean existe;
    
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
