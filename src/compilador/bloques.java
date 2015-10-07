/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Paola y Jesús
 */
public class bloques {
    
    tablaSLRlogico tblLogica = new tablaSLRlogico();
    tablaNumeros tblNum = new tablaNumeros();
    int idNum;
    
    public void nai(String lexema, int linea){
        StringTokenizer t = new StringTokenizer(lexema);
        String expresion = t.nextToken("(");
        expresion = t.nextToken("{");
        expresion = expresion.replaceAll(" ", "");
        ArrayList cadena = obtenerCadena(expresion);
        int[] cadNum = aregloCadena(cadena);
        if (tblLogica.analizar(cadNum)) {
            System.out.println("Fue valido " + lexema);
        }else{
            System.out.println("Error - la gramatica es incorrecta " + lexema + "(linea " + linea + ")");
        }
        
    }
    
    public void eno(String lexema, int linea){
        StringTokenizer t = new StringTokenizer(lexema);
        String expresion = t.nextToken("(");
        expresion = t.nextToken("{");
        expresion = expresion.replaceAll(" ", "");
        ArrayList cadena = obtenerCadena(expresion);
        int[] cadNum = aregloCadena(cadena);
        if (tblLogica.analizar(cadNum)) {
            System.out.println("Fue valido " + lexema);
        }else{
            System.out.println("Error - la gramatica es incorrecta " + lexema + "(linea " + linea + ")");
        }
        
    }
    
    
    
    public ArrayList<String> obtenerCadena(String cad){
        char p;
        String aux = "";
        ArrayList<String> cadena = new ArrayList();
        for (int i = 0; i < cad.length(); i++) {
            p = cad.charAt(i);
            if ((p >= '0' && p<= '9')||Character.isLetter(p)) {
                aux = aux.concat(Character.toString(p));
            }else{
                
                if(!"".equals(aux)){
                    cadena.add(aux);
                    aux="";
                }
                if (p == '=') {
                    aux = aux.concat(Character.toString(p));
                    i++;
                    p = cad.charAt(i);
                    aux = aux.concat(Character.toString(p));
                    cadena.add(aux);
                    aux = "";
                }else{
                    cadena.add(Character.toString(p));
                }
                
                
                
            }
        }
        if(!"".equals(aux)){
                    cadena.add(aux);
                    aux="";
        }
        cadena.add("$");
        return cadena;
    }
    
    
    public int[] aregloCadena(ArrayList<String> cad){
        int[] cadNum = new int[cad.size()];
        String p;
        for (int i = 0; i < cad.size(); i++) {
            p = cad.get(i);
            if (!(num(p)) & !valId(p)) {
                switch(p){
                    case "0":
                        cadNum[i] = 2;
                    break;
                        
                    case "1":
                        cadNum[i] = 3;
                    break;
                        
                    case "&":
                        cadNum[i] = 4;
                    break;
                        
                    case "|":
                        cadNum[i] = 5;
                    break;
                    
                    case "!":
                        cadNum[i] = 6;
                    break;
                    
                    case "==":
                        cadNum[i] = 7;
                    break;
                        
                    case "¬":
                        cadNum[i] = 8;
                    break;
                    
                    case ">":
                        cadNum[i] = 9;
                    break;
                        
                    case "<":
                        cadNum[i] = 10;
                    break;
                        
                    case "(":
                        cadNum[i] = 11;
                    break;
                        
                    case ")":
                        cadNum[i] = 12;
                    break;
                        
                    case "$":
                        cadNum[i] = 13;
                    break;
                }
            }else if(p.equals("pol")){
                cadNum[i] = 4;
            }else if(p.equals("at")){
                cadNum[i] = 5;
            }else if(p.equals("ar")){
                cadNum[i] = 6;
            }else if(num(p)){
                tblNum.nuevo(new nodoNum(p, "num"+String.valueOf(idNum)));
                idNum++;
                cadNum[i] = 0;
            }else if(valId(p)){
                
                if(Compilador.l.exp.ident.buscarId(p)){
                    cadNum[i] = 1;
                }else{
                    System.out.println("Error - El identificador " + p + " no esta definido");
                    return null;
                }
            }
        }
        return cadNum;
    }
    
    public boolean num(String v){
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(v);
        return m.matches();
    }
    
    public boolean valId(String c){
           Pattern p = Pattern.compile("[a-zA-Z][a-zA-Z0-9]*");
           Matcher m = p.matcher(c);
           
           if(m.matches())
              return true;
           else
               return false;
   }
}