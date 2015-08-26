package compilador;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class expVariables {
    StringTokenizer t;
    //Tabla de identificadores declarados
    identificadores ident = new identificadores();
    int n = 0;
    //Arreglo de palabras reservadas
    palabrasReservadas pr = new palabrasReservadas();
    
    
    public void arit(String lexema, int linea) {
        
        String val = lexema.substring(5,lexema.length());
        String token = "";
        String nom = "";
        String valor = "0";
        String tipo = "arit";
        
        
        
        //---------------------------------------------------------------------
        if (valCaso1(val)) {
            t = new StringTokenizer(val);
            token = t.nextToken(";");
            //EL identificador no debe ser una palabra reservada
            if (!pr.buscarPalabra(token)) {
            //El identificador no debe exister en la tabla de identificadores
            if (!ident.buscarId(token)) {
                //nombre del identificador
                nom = token;
                //agregar identificador a la tabla de identificadores
                ident.nuevo(new nodo(nom, tipo, valor, (String)("id")+n));
                n++;
            }else{
                System.out.println("Error - El identificador " + token + " ya existe(linea " + linea + ")");   
            }
            }else{
                System.out.println("Error - El identificador no puede ser una palabra reservada (linea " + linea + ")");
            }
        }
        //---------------------------------------------------------------------
        
        //---------------------------------------------------------------------
        if(valCaso2(val)){
            t = new StringTokenizer(val);
            token = t.nextToken("=");
            token = borEsp(token);
            nom = token;
            if (!pr.buscarPalabra(token)) {
            if (!ident.buscarId(token)){
                token = t.nextToken(";");
                token = borEsp(token);
                valor = token;
                if(num(valor)){
                    ident.nuevo(new nodo(nom, tipo, valor, (String)("id")+n));
                    n++;
                }else{
                    System.out.println("Valor incorrecto");
                }
            }else{
                System.out.println("Error - El identificador " + token + " ya existe(linea " + linea + ")");
                
            }
            }else{System.out.println("Error - El identificador no puede ser una palabra reservada (linea " + linea + ")");}
            
        }
        //---------------------------------------------------------------------
        
        //---------------------------------------------------------------------
        if(valCaso3(val)){
            t = new StringTokenizer(val);
            token = t.nextToken("=");
            token = borEsp(token);
            nom = token;
            if (!pr.buscarPalabra(token)) {
            if (!ident.buscarId(token)){
                token = t.nextToken(";");
                token = borEsp(token);
                valor = ident.valorId(token);
                if(valor == null){
                    System.out.println(val + " identificador no valido");
                }else{
                    ident.nuevo(new nodo(nom, tipo, valor, (String)("id")+n));
                    n++;
                }
            }else{
                System.out.println("Error - El identificador " + token + " ya existe(linea " + linea + ")");
            }
            }else{System.out.println("Error - El identificador no puede ser una palabra reservada (linea " + linea + ")");}
}
        //---------------------------------------------------------------------

        
        if(!valCaso1(val) && !valCaso2(val) && !valCaso3(val)){
                System.out.println("Error - Sintaxis Incorrecta" + val + "(linea " + linea + ")");
        }
        
}
    
    
    public void epi(String lexema, int linea){
        lexema = lexema.replaceAll(" ", "");
        String val = lexema.substring(3,lexema.length());
        String token = "";
        String nom = "";
        String valor = "";
        String tipo = "epi";
        
        if (c1Epi(val)) {
            t = new StringTokenizer(val);
            token = t.nextToken(";");
            if (!pr.buscarPalabra(token)) {
            if (!ident.buscarId(token)) {
                nom = token;
                ident.nuevo(new nodo(nom, tipo, valor, (String)("id")+n));
                n++;
            }else{
                System.out.println("Error - El identificador " + token + " ya existe(linea " + linea + ")");
            }
            }else{System.out.println("Error - El identificador no puede ser una palabra reservada (linea " + linea + ")");}
        }
        
        //---------------------------------------------------------------------
        if(c2Epi(val)){
            t = new StringTokenizer(val);
            token = t.nextToken("=");
            token = borEsp(token);
            nom = token;
            if (!pr.buscarPalabra(token)) {
            if (!ident.buscarId(token)){
                token = t.nextToken("\'");
                token = t.nextToken("\'");
                valor = token;
                    ident.nuevo(new nodo(nom, tipo, valor, (String)("id")+n));
                    n++;
            }else{
                System.out.println("Error - El identificador " + token + " ya existe(linea " + linea + ")");
                
            }
            }else{System.out.println("Error - El identificador no puede ser una palabra reservada(linea " + linea + ")");}
            
            
            
        }
        //---------------------------------------------------------------------
        
        
        if(c3Epi(val)){
            t = new StringTokenizer(val);
            token = t.nextToken("=");
            token = borEsp(token);
            nom = token;
            if (!pr.buscarPalabra(token)) {
            if (!ident.buscarId(token)) {
            token = t.nextToken(";");
            token = borEsp(token);
            valor = ident.valorId(token);
            if(valor == null){
                System.out.println("Error - " + val + " identificador no valido" + "(en la linea " + linea +")");
            }else{
                ident.nuevo(new nodo(nom, tipo, valor, (String)("id")+n));
                n++;
            }
            }else{System.out.println("Error - El Identificador ya existe(linea " + linea + ")");}
        }else{System.out.println("Error - El identificador no puede ser una palabra reservada" + "(en la linea " + linea + ")");}
        }
        if(!c3Epi(val) && !c2Epi(val) && !c1Epi(val)){
                System.out.println("Error - Sintaxis incorrecta" + val + "(en la linea " + linea + ")");
        }
    }
    
    
    public void lexi(String lexema, int linea){
        lexema = lexema.replaceAll(" ", "");
        String val = lexema.substring(4,lexema.length());
        String token = "";
        String nom = "";
        String valor = "";
        String tipo = "lexi";
        
        if (c1Lexi(val)) {
            t = new StringTokenizer(val);
            token = t.nextToken(";");
            if (!pr.buscarPalabra(token)) {
            if (!ident.buscarId(token)) {
                nom = token;
                ident.nuevo(new nodo(nom, tipo, valor, (String)("id")+n));
                n++;
            }else{
                System.out.println("Error - El identificador " + token + " ya existe(linea " + linea + ")");   
            }
        }else{System.out.println("El identificador no puede ser una palabra reservada");}
        }
        
        //---------------------------------------------------------------------
        if(c2Lexi(val)){
            t = new StringTokenizer(val);
            token = t.nextToken("=");
            token = borEsp(token);
            if (!pr.buscarPalabra(token)) {
            if (!ident.buscarId(token)){
                nom = token;
                token = t.nextToken("\"");
                token = t.nextToken("\"");
                valor = token;
                    ident.nuevo(new nodo(nom, tipo, valor, (String)("id")+n));
                    n++;
            }else{
                System.out.println("El identificador " + token + " ya existe");
                
            }
            
        }else{System.out.println("El identificador no puede ser una palabra reservada");}
        }
        //---------------------------------------------------------------------
        
        
        if(c3Lexi(val)){
            t = new StringTokenizer(val);
            token = t.nextToken("=");
            token = borEsp(token);
            nom = token;
            if (!pr.buscarPalabra(token)) {
            if (ident.buscarId(token)) {
            token = t.nextToken(";");
            token = borEsp(token);
            valor = ident.valorId(token);
            if(valor == null){
               System.out.println("Error - " + val + " identificador no valido(en la linea " + linea + ")");
            }else{
                ident.nuevo(new nodo(nom, tipo, valor, (String)("id")+n));
                n++;
            }
            }
            }else{System.out.println("El identificador no puede ser una palabra reservada");}
        }
        
        if(!c3Lexi(val) && !c2Lexi(val) && !c1Lexi(val)){
                System.out.println("Error de sintaxis " + val);
        }
            
    }
    
    public void diplo(String lexema, int linea){
        lexema = lexema.replaceAll(" ", "");
        String val = lexema.substring(5,lexema.length());
        String token = "";
        String nom = "";
        String valor = "";
        String tipo = "diplo";
        
        //---------------------------------------------------------------------
        if (c1Diplo(val)) {
            t = new StringTokenizer(val);
            token = t.nextToken(";");
            token = borEsp(token);
            nom = token;
            if (!pr.buscarPalabra(token)) {
            if (!ident.buscarId(token)) {
                ident.nuevo(new nodo(nom, tipo, valor, (String)("id")+n));
                n++;
            }else{
                System.out.println("Error - El identificador " + token + " ya existe (linea " + linea +")");   
            }
            }
        }
        //---------------------------------------------------------------------
        
        //---------------------------------------------------------------------
        if(c2Diplo(val)){
            t = new StringTokenizer(val);
            token = t.nextToken("=");
            token = borEsp(token);
            if (!pr.buscarPalabra(token)) {
            if (!ident.buscarId(token)){
                nom = token;
                token = t.nextToken(";");
                token = borEsp(token);
                valor = token;
                if(num(valor)){
                    ident.nuevo(new nodo(nom, tipo, valor, (String)("id")+n));
                    n++;
                }else{
                    System.out.println("Valor incorrecto");
                }
            }else{
                System.out.println("Error - El identificador " + token + " ya existe (linea " + linea +")");
                
            }
            }
            
        }
        //---------------------------------------------------------------------
        
        //---------------------------------------------------------------------
        if(c3Diplo(val)){
            t = new StringTokenizer(val);
            token = t.nextToken("=");
            token = borEsp(token);
            nom = token;
            if (!pr.buscarPalabra(token)) {
            if(!ident.buscarId(nom)){
                token = t.nextToken(";");
                token = borEsp(token);
                valor = ident.valorId(token);
                if(valor == null){
                System.out.println("Error - " + val + " identificador no valido(en la linea " + linea + ")");
                }else{
                    ident.nuevo(new nodo(nom, tipo, valor, (String)("id")+n));
                    n++;
                }
            }else{
               System.out.println("Error - El identificador " + token + " ya existe (linea " + linea +")");
            }
            }
            
            
        }
        //---------------------------------------------------------------------
        if(!c3Diplo(val) && !c2Diplo(val) && !c1Diplo(val)){
                System.out.println("Error de sintaxis " + val);
        }
    }
    
    public boolean c1Diplo(String c){
        Pattern p = Pattern.compile(" *[a-zA-Z]([a-zA-Z0-9]*) *; *\n*");
        Matcher m = p.matcher(c);
        boolean b = m.matches();
        return m.matches();
    }
    
    public boolean c2Diplo(String c){
        Pattern p = Pattern.compile(" *[a-zA-Z]([a-zA-Z0-9]*) *= [0-1]+; *");
        Matcher m = p.matcher(c);
        return m.matches();
    }
    
    public boolean c3Diplo(String c){
        Pattern p = Pattern.compile(" *[a-zA-Z]([a-zA-Z0-9]*) *= *[a-zA-Z]([a-zA-Z0-9]*) *; *");
        Matcher m = p.matcher(c);
        return m.matches();
    }
    
    public boolean c1Lexi(String c){
        Pattern p = Pattern.compile(" *[a-zA-Z]([a-zA-Z0-9]*) *; *");
        Matcher m = p.matcher(c);
        return m.matches();
    }
    
    public boolean c2Lexi(String c){
        Pattern p = Pattern.compile(" *[a-zA-Z]([a-zA-Z0-9]*) *= *\"[a-zA-ZñÑ ]+\" *; *");
        Matcher m = p.matcher(c);
        return m.matches();
    }
    
    public boolean c3Lexi(String c){
        Pattern p = Pattern.compile(" *[a-zA-Z]([a-zA-Z0-9]*) *= *[a-zA-Z]([a-zA-Z0-9]*) *; *");
        Matcher m = p.matcher(c);
        return m.matches();
    }
    
    public boolean c1Epi(String c){
        Pattern p = Pattern.compile(" *[a-zA-Z]([a-zA-Z0-9]*) *; *");
        Matcher m = p.matcher(c);
        return m.matches();
    }
    
    public boolean c2Epi(String c){
        Pattern p = Pattern.compile(" *[a-zA-Z]([a-zA-Z0-9]*) *= *\'[a-zA-Z]\' *; *");
        Matcher m = p.matcher(c);
        return m.matches();
    }
    
    public boolean c3Epi(String c){
        Pattern p = Pattern.compile(" *[a-zA-Z]([a-zA-Z0-9]*) *= *[a-zA-Z]([a-zA-Z0-9]*) *; *");
        Matcher m = p.matcher(c);
        return m.matches();
    }
    
    public boolean valCaso1(String a){
        String c = a;
        Pattern p = Pattern.compile(" *[a-zA-Z]([a-zA-Z0-9]*) *; *");
        Matcher m = p.matcher(c);
        
        return m.matches();
    }
    
    public boolean valCaso2(String a){
        String c = a;
        Pattern p = Pattern.compile(" *[a-zA-Z]([a-zA-Z0-9]*) *= *[0-9]+ *; *");
        Matcher m = p.matcher(c);
        return m.matches();
    }
    
    public boolean valCaso3(String a){
        String c = a;
        Pattern p = Pattern.compile(" *[a-zA-Z]([a-zA-Z0-9]*) *= *[a-zA-Z]([a-zA-Z0-9]*) *; *");
        Matcher m = p.matcher(c);
        return m.matches();
    }
        
    public String borEsp(String c){
        
            c = c.replaceAll("\\s","");
            c = c.replaceAll("=","");//!!!separar en otro metodo
        
           return c;
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
           Pattern p = Pattern.compile("[0-9]*");
           Matcher m = p.matcher(c);
           
           if(m.matches())
              return true;
           else
               return false;
   }
    
    public boolean num(String v){
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(v);
        return m.matches();
    }
    
    public boolean car(String v){
        Pattern p = Pattern.compile("\'[\\u0000-\\u00FF]\'");
        Matcher m = p.matcher(v);
        return m.matches();
    }
    
    public boolean cad(String v){
        Pattern p = Pattern.compile("\"[\\u0000-\\u00FF]+\"");
        Matcher m = p.matcher(v);
        return m.matches();
    }

    public boolean dip(String v){
        Pattern p = Pattern.compile("[0|1]");
        Matcher m = p.matcher(v);
        return m.matches();
    }
}