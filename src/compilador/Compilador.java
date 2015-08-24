package compilador;

import java.io.IOException;

/**
 *
 * @author Jesús
 */
public class Compilador {
    
    
            
    public static void main(String[] args) throws IOException {
        depurar dep = new depurar();
        ficheroFuente fuente = new ficheroFuente();
        ficheroDestino destino = new ficheroDestino();
        lexico l = new lexico();
        
        dep.borrarCT(fuente, destino);
        
        System.out.println("\n\n\n\n");
        
        l.compara(destino);
        System.out.println("\n\n\n\n");
        l.exp.ident.impIdent();
        
        
        
        
        
        
        /*String token = "";      
        
        
        //obtener del archivo destino una linea
        token = destino.l.readLine();
        
        
        //declarar Objeto StringTokenizer
        StringTokenizer t = new StringTokenizer(token);
        
        //
        System.out.println(t.nextToken());*/
        
    }
    
}