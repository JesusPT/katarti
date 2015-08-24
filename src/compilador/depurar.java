package compilador;

import java.io.IOException;


/**
 *
 * @author Jes�s & Paola :3
 */
public class depurar{
 
	public void borrarCT(ficheroFuente fuente, ficheroDestino destino) throws IOException{
        String linea = "";
        String l2 = "";
        while((linea = fuente.l.readLine())!=null){
            l2 = "";
            for (int i = 0; i < linea.length(); i++) {
                //ignorar tabulaciones
                if(linea.charAt(i)== '\t'){
                
                
                //pasar los caracteres que son diferentes al #  
                }else if(linea.charAt(i)!= '#'){
                    l2 = l2 + linea.charAt(i);
                    
                //de lo contrario si encuenta un #, no seguir con el analisis de la liea actual,
                //quebrar la iteracion, ir a la linea siguiente
                }else{
                    break;
                }
            }
            //l2 mandar al nuevo archivo
            destino.impresor.println(l2);
            System.out.println(l2);
        }
        fuente.lector.close();
        destino.impresor.close();
    }

}
