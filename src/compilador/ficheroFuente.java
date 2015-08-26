/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compilador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Jesús & Paola :3
 */
public final class ficheroFuente {
    String a = "";    
    File fichero;
    FileReader lector;
    BufferedReader l;
    

    
    //Constructor de la clase
    ficheroFuente() throws IOException{
        ruta();
        lectura();
    }
    
    //Excepción de lectura
    public void lectura(){
        try{
            //instanciamos con el obejto fichero
            lector = new FileReader(fichero);
            //Instanciamos el buffer con el lector de archivos
            l = new BufferedReader(lector);
        }catch(FileNotFoundException e){
            System.out.println("No se a encontrado el archivo");
        }
        
    }
    
    public void ruta(){
        //System.out.println("inserte ruta del archivo");
        //Leer ruta del archivo
        a = leer();
        //Instanciar objeto del archivo con la ruta leida
        fichero = new File(a);
    }

    public String leer(){
        /*BufferedReader l2 = new BufferedReader(new InputStreamReader(System.in));
        String cad = "";
        try{
        cad = l2.readLine();
        }catch(IOException e){
            
        }
                */
        return "/home/jesus/Documentos/katarti/src/compilador/prueba.gri";
    }
}
