

package compilador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Jesús & Paola :3
 */
public final class ficheroDestino {
    String b = "";
    File ficherob;
    FileWriter escritor;
    PrintWriter impresor;
    FileReader lector;
    BufferedReader l;

    
    //Constructor de la clase
    ficheroDestino() throws IOException{
        rutab();
        escritura();
        lectura();
    }
       
    
    public void rutab(){
        //Leer ruta del archivo
        b = "/home/jesus/Documentos/katarti/src/compilador/prueba1.gri";
        //Instanciar objeto del archivo con la ruta leida
        ficherob = new File(b);
    }
    
    public void lectura(){
        try{
            //instanciamos con el obejto fichero
            lector = new FileReader(ficherob);
            //Instanciamos el buffer con el lector de archivos
            l = new BufferedReader(lector);
        }catch(FileNotFoundException e){
            System.out.println("No se a encontrado el archivo");
        }
        
    }
    
    public void escritura() throws IOException{
        try{
            //instanciamos con el obejto fichero
            escritor = new FileWriter(ficherob);
            //Instanciamos el buffer con el lector de archivos
            impresor = new PrintWriter(escritor);
        }catch(FileNotFoundException e){
            System.out.println("No se a encontrado el archivo");
        }
    }
}

