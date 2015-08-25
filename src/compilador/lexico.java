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
    
    boolean existe;
    palabrasReservadas pr = new palabrasReservadas();
    StringTokenizer t;
    StringTokenizer t2;
    String token = "";
    String lexema = ""; 
    expVariables exp = new expVariables();
    String ints;
    int linea = 0;
    
    
    
    public void compara(ficheroDestino d) throws IOException{
        lexema = d.l.readLine();
        linea++;
        
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
                    token = t.nextToken();
                    //System.out.println(token);
                    
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
            
            
            lexema = d.l.readLine();
            linea++;
        }
    }
    
    public void llamada(){
        boolean ban = false;
        boolean ban2 = false;
        
        ban = pr.buscarPalabra(token);
        ban2 = exp.ident.buscarId(token);
            
            if (ban && token.equals("arit")) {
                exp.arit(lexema);
            }
            else if (ban && token.equals("epi")){
                exp.epi(lexema);
            }
            else if (ban && token.equals("lexi")){
                exp.lexi(lexema);
            }
            else if (ban && token.equals("diplo")){
                exp.diplo(lexema);
            }
            else if (ban && token.equals("exo")){
                if (impLex()) {
                    
                }else{
                    System.out.println("Error de sintaxis " + lexema + "en la linea " + linea);
                }
            }
            else if (ban && token.equals("se")){
                if (leerLex()) {
                    
                }else{
                    System.out.println("Error de sintaxis " + lexema + "en la linea " + linea);
                }
            }else if (ban2){
                StringTokenizer t = new StringTokenizer(lexema);
                String val = t.nextToken("=");
                val = t.nextToken(";");
                val = val.replaceAll("=","");
                val = val.replaceAll(" ","");
                if (exp.num(val) && exp.ident.obtTipo(token).equals("arit")) {
                    exp.ident.asigVal(val , token);
                }else if(exp.car(val) && exp.ident.obtTipo(token).equals("epi")){
                    t = new StringTokenizer(lexema);
                    val = t.nextToken("\'");
                    val = t.nextToken("\'");
                    exp.ident.asigVal(val , token);
                }
                else if(exp.cad(val) && exp.ident.obtTipo(token).equals("lexi")){
                    t = new StringTokenizer(lexema);
                    val = t.nextToken("\"");
                    val = t.nextToken("\"");
                    exp.ident.asigVal(val , token);
                }
                else if(exp.dip(val) && exp.ident.obtTipo(token).equals("diplo")){
                    exp.ident.asigVal(val , token);
                }else{
                    System.out.println(lexema + " Los tipos no coinciden" + "en la linea " + linea);
                }
                
                
            }else{
                System.out.println(lexema + " Instruccion no comprendida"  + "en la linea " + linea);
            }
            
    }
    
    
    public boolean impLex(){
        Pattern p = Pattern.compile("exo *\\(*( *([a-zA-Z][a-zA-Z0-9]* *~))* *\"[\\u0000-\\u00FF]*\" *(~ *([a-zA-Z][a-zA-Z0-9]*))*\\) *; *");
        Matcher m = p.matcher(lexema);
        return m.matches();
    }
    
    public String tipoVal(String S){
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
    
    
    public boolean leerLex(){
        StringTokenizer t = new StringTokenizer(lexema);
        String token;
        Pattern p = Pattern.compile("se\\([a-zA-Z][a-zA-Z0-9]*\\);");
        Matcher m = p.matcher(lexema);
        token = t.nextToken("(");
        token = t.nextToken(")");
        token = token.substring(1);
        if(m.matches() && exp.ident.buscarId(token)){
            return true;
        }
        return false;
    }
}
