/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compilador;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Pahola
 */
public class pruebilla {
    char caracter[];//Convierte la cadena en arreglo de char
    int edo = 1;//Inizializando el estado en 1, de ahí se partirá
    boolean salir = false;
    StringTokenizer t;
    
    public void arit(String lexema) {
        String val = lexema.substring(5,lexema.length());
        caracter = val.toCharArray();
        boolean ban = false;
        boolean ban2 = false;
        boolean ban3 = false;
        //boolean ban4 = false;
        String token = "";
        String id = "";
        String valor = "";
        String tipo = "arit";
        int n;
        
        
        //Primer caso
        t = new StringTokenizer(val);
        token = t.nextToken(";");
        ban = valId(token);
        if (ban) {
            id = token;
        }
        //----------------------------

        //Segundo caso
        val = borEsp(val);
        t = new StringTokenizer(val);
        token = borEsp(token);
        try{
            
            token = t.nextToken("=");
            ban2 = valId(token);
            token = t.nextToken(";");
            ban2 = valValor(token);
        }catch(NoSuchElementException e){
            
        }
        //----------------------------
        
        
        //Tercer caso
        //val = borEsp(val);
        t = new StringTokenizer(val);
        token = borEsp(token);
        try{
            
            token = t.nextToken("=");
            ban3 = valId(token);
            token = t.nextToken(";");
            ban3 = valOtroId(token);
        }catch(NoSuchElementException e){
            
        }
        //----------------------------
        
        if(ban)
            System.out.println("caso 1 correcto");
        else if(ban2)
            System.out.println("caso 2 correcto");
        else if(ban3)
            System.out.println("caso 3 correcto");
                    
    }
     
    
    //Evaluar tipo caracter
    public void epi(String lexema) {
        String val = lexema.substring(5,lexema.length());
        caracter = val.toCharArray();
        boolean ban = false;
        boolean ban2 = false;
        boolean ban3 = false;
        //boolean ban4 = false;
        String token = "";
        String id = "";
        String valor = "";
        String tipo = "epi";
        int n;
        
        
                    
    }
    
    
    
    
    
        
    public String borEsp(String c){
        String c1 = "";
        char aux;
        for (int i = 0; i < c.length(); i++) {
            aux = c.charAt(i);
            if(aux == ' '){
                
            }else{
                c1 = c1+  c.charAt(i);
            }
        }
           return c1;
   }    
    
    
    public boolean valId(String c){
           Pattern p = Pattern.compile("[a-zA-Z][a-zA-Z0-9]*");
           Matcher m = p.matcher(c);
           
           if(m.matches())
              return true;
           else
               return false;
   }
    
    public boolean valValor(String c){
           Pattern p = Pattern.compile("=[0-9]*");
           Matcher m = p.matcher(c);
           
           if(m.matches())
              return true;
           else
               return false;
   }
    
    public boolean valOtroId(String c){
           Pattern p = Pattern.compile("=[a-zA-Z][a-zA-Z0-9]*");
           Matcher m = p.matcher(c);
           
           if(m.matches())
              return true;
           else
               return false;
   }
    
    public boolean valCar(String c){
           Pattern p = Pattern.compile("[a-zA-Z]");
           Matcher m = p.matcher(c);
           
           if(m.matches())
              return true;
           else
               return false;
   }
}
