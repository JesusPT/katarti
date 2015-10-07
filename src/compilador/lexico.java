package compilador;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Pahola
 */
public class lexico {
    
    
    palabrasReservadas pr = new palabrasReservadas();//Arreglo de palabras reservadas
    StringTokenizer t;//Objeto tokenizer del lexema
    StringTokenizer t2;//Objeto tokenizer, situacion para el token
    String token = "";//
    String lexema = ""; 
    expVariables exp = new expVariables();
    bloques bloque = new bloques();
    String ints;
    int linea = 0;//indicador de la liena en analisis
    
    
    
    public void compara(ficheroDestino d) throws IOException{
        //Obtiene 
        lexema = d.l.readLine();//Leer linea del fichero destino(archivo depurado)
        linea++;
        
        //Recorremos el archivo linea por linea, analizando estas para
        //determinar que tarea se realizara
        while (lexema != null) {
            t = new StringTokenizer(lexema);
            try {
                token = t.nextToken();
                //System.out.println(token);
            } catch (NoSuchElementException e) {
                lexema = d.l.readLine();
                linea++;
                
                t = new StringTokenizer(lexema);
                
                
                if(!"".equals(lexema)){
                    try{
                        token = t.nextToken();
                    //System.out.println(token);
                    }catch(NoSuchElementException ex){
                        //!!!Problema con los espacios
                    }
                    
                }
            }
            if(!"".equals(lexema)){
                    //try{
                        t2 = new StringTokenizer(token);
                        token = t2.nextToken("(");
                    //}catch(){
                        llamada();
                    //}
                    
                    //System.out.println(token);
                }
            
            if("}allios{".equals(token)){
                
                //token = token.replaceAll("}", "");//!!!Revisar
                //token = token.replaceAll("{", "");
                llamada();
            }
            
            
            lexema = d.l.readLine();
            linea++;
        }
    }
    
    public void llamada(){
        boolean ban = false;
        boolean ban2 = false;
        
        //Buscar si el token es una palabra reservada
        ban = pr.buscarPalabra(token);
        //Buscar si el token es un identificador
        ban2 = exp.ident.buscarId(token);
           
        //Identificar el tipo de declaracion
            if (ban && token.equals("arit")) {
                exp.arit(lexema, linea);
            }
            else if (ban && token.equals("epi")){
                exp.epi(lexema, linea);
            }
            else if (ban && token.equals("lexi")){
                exp.lexi(lexema, linea);
            }
            else if (ban && token.equals("diplo")){
                exp.diplo(lexema, linea);
            }
            else if (ban && token.equals("exo")){
                if (!impLex()) {
                    System.out.println("Error - " + lexema + "(Sintaxis incorrecta en la linea " + linea + ")");
                }
            }
            else if (ban && token.equals("se")){
                if (!leerLex()) {
                    System.out.println("Error - " + lexema + "(Sintaxis incorrecta en la linea " + linea + ")");
                }
                
            //Estructura iterativa
            }else if(ban && token.equals("na")){
            
                
            //Estructura condicional
            }else if(ban && token.equals("nai")){
                
                bloque.nai(lexema,linea);
                
            }else if(ban && token.equals("eno")){
                
                bloque.eno(lexema,linea);
                
            }else if(ban && token.equals("odigi")){
            
            }
            else if(token.equals("}")){
            
            }else if (ban2){//En caso de ser un identificador
                StringTokenizer t = new StringTokenizer(lexema);
                String val = t.nextToken("=");//!!!cuando no tenga =
                val = t.nextToken(";");
                val = val.replaceAll("=","");
                val = val.replaceAll(" ","");
                
                //si el valor a asignar es entero, exp.num se asegura de que val
                //sean solo numero y se obtiene el tipo de la tabla de identificadores
                //con el identificador en token, el cual debe corresponder ha "arit"
                if (exp.num(val) && exp.ident.obtTipo(token).equals("arit")) {
                    exp.ident.asigVal(val,token);
                    
                //si el valor a asignar es un caracter, exp.car se asegura de que en val
                //exista exclusivamente un caracter y se obtiene el tipo de la tabla de 
                //identificadores con el identificador token, el cual debe corresponder a "epi"
                }else if(exp.ident.obtTipo(token).equals("arit") && exp.SLRArit.analizar(exp.aregloCadena(exp.obtenerCadena(val)))){
                    exp.ident.asigVal(val,token);
                }else if(exp.car(val) && exp.ident.obtTipo(token).equals("epi")){
                    t = new StringTokenizer(lexema);
                    //Se remueve las comillas simples del valor a asignar y se asigna
                    val = t.nextToken("\'");
                    val = t.nextToken("\'");
                    exp.ident.asigVal(val , token);
                }
                
                
                //si el valor a asignar es una cadena, exp.cad se asegura de que en val
                //exista una cadena de caracteres y se obtiene el tipo de la tabla de 
                //identificadores con el identificador token, el cual debe corresponder a "lexi"
                else if(exp.cad(val) && exp.ident.obtTipo(token).equals("lexi")){
                    t = new StringTokenizer(lexema);
                    //Se remueven las comillas del valor a asignary se asigna
                    val = t.nextToken("\"");
                    val = t.nextToken("\"");
                    exp.ident.asigVal(val , token);
                }
                
                //si el valor a asignar es un booleano, exp.dip se asegura de que en val
                //exista exclusivamente cero o uno y se obtiene el tipo de la tabla de 
                //identificadores con el identificador token, el cual debe corresponder a "diplo"
                else if(exp.dip(val) && exp.ident.obtTipo(token).equals("diplo")){
                    exp.ident.asigVal(val , token);
                    
                //Mensajes de error
                }else{
                    System.out.println("Error - " + lexema + " (Los tipos no coinciden(en la linea " + linea + ")");
                }
                
            }else{
                System.out.println("Error " + lexema + " (Instruccion no comprendida en la linea " + linea + ")");
            }
            
    }
    
    //Lexico exo(imprimir)
    public boolean impLex(){
        Pattern p = Pattern.compile(" *exo *[(]((\"[\\u0000-\u00FF]*\")|([a-zA-Z][a-zA-Z0-9]*))[)] *; *");
        Matcher m = p.matcher(lexema);
        if (!lexema.contains("\"")) {
            StringTokenizer token = new StringTokenizer(lexema);
            String t = token.nextToken("(");
            t = token.nextToken(")");
            t = t.replaceAll("[(]","");
            if (exp.ident.buscarId(t)) {
                
            }else{System.out.println("Error - El identificador " + t + " no existe(linea " + linea + ")");}
            
        }
        return m.matches();
    }
    //!!!No se por que puse este metodo
/*    public String tipoVal(String S){
        String val = null;
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(lexema);
        if (m.matches()) {
            val = "arit";
        }
        p = Pattern.compile("[0-9]+");
        m = p.matcher(lexema);
        if (m.matches()) {
            val = "arit";
        }
        return val;
    }
*/
    
    
    //Lexico se(leer)
    public boolean leerLex(){
        StringTokenizer t = new StringTokenizer(lexema);
        String token2;
        Pattern p = Pattern.compile(" *se *([(] *[a-zA-Z][a-zA-Z0-9]* *[)]) *;");
        Matcher m = p.matcher(lexema);
        token2 = t.nextToken("(");
        token2 = t.nextToken(")");
        token2 = token2.substring(1);
        if(m.matches() && !exp.ident.buscarId(token2)){
            System.out.println("Error - El identificador " + lexema + " no existe el identificador(linea " + linea + ")");
        }
        return m.matches();
    }
}
