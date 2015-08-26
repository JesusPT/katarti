package compilador;

import java.io.IOException;


/**
 *
 * @author Jes�s & Paola :3
 */
public class depurar{
 
    
        //Borrar Comentarios(#) y Tabulaciones
	public void borrarCT(ficheroFuente fuente, ficheroDestino destino) throws IOException{
        String linea = "";
        String l2 = "";
        //ciclo para el analisis de liena por linea del codigo fuente
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
            //Guardar l2 al nuevo archivo
            destino.impresor.println(l2);
            System.out.println(l2);
        }
        //cerrar archivos
        fuente.lector.close();
        destino.impresor.close();
    }

}
