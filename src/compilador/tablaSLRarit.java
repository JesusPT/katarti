/*
 * tablaSLRarit
 *  Contiene lo necesario para poder realizar el análisis sintáctico, como parte
 *  del compilador Katarti.
 *  Contiene
 *    -tablaAritmetica[][]
 *    -tablaElimiacion
 */
package compilador;

import java.util.ArrayList;

/**
 *
 * @author Pahola y Jesús
 */
public class tablaSLRarit {
    /*
    tablaAritmetica
        Contiene los valores de la tabla SLR que se necesitan para poder realizar
        el análisis sintáctico del código Katarti con extención .gri
    */
    String tablaAritmetica[][] = {
        {"s6","s5",null,null,null,null,"s4",null,null,"1","2","3"},
        {null,null,"s7","s8",null,null,null,null,"acep",null,null,null},
        {null,null,"r3","r3","s9","s10",null,"r3","r3",null,null,null},
        {null,null,"r6","r6","r6","r6",null,"r6","r6",null,null,null},
        {"s6","s5",null,null,null,null,"s4",null,null,"11","2","3"},
        {"s6","s5","r8","r8","r8","r8",null,"r8","r8",null,null,null},
        {null,null,"r9","r9","r9","r9",null,"r9","r9",null,null,null},
        {"s6","s5",null,null,null,null,"s4",null,null,null,"12","3"},
        {"s6","s5",null,null,null,null,"s4",null,null,null,"13","3"},
        {"s6","s5",null,null,null,null,"s4",null,null,null,null,"14"},
        {"s6","s5",null,null,null,null,"s4",null,null,null,null,"15"},
        {"s6","s5","s7","s8",null,null,"s4","s16",null,"16",null,null},
        {null,null,"r1","r1","s9","s10",null,"r1","r1",null,null,null},
        {null,null,"r2","r2","s9","s10",null,"r2","r2",null,null,null},
        {null,null,"r4","r4","r4","r4",null,"r4","r4",null,null,null},
        {null,null,"r5","r5","r5","r5",null,"r5","r5",null,null,null},
        {null,null,"r7","r7","r7","r7",null,"r7","r7",null,null,null},
    };
    
    /*
    tablaReducArit
    Contiene (representados con números) de izquierda a derecha:
        -Número de grámatica:
            1.E->E+T
            2.E->E-T
            3.E->T
            4.T->T*F
            5.T->T/F
            6.T->F
            7.F->(E)
            8.F->id
            9.F->num
        -Número de elementos que se eliminarán de la pila
        -Número de columna que representa a las letras de las producciones en 
        la tabla SLR aritmetica ó el arreglo tablaAritmetica
            E: 9
            T: 10
            F: 11
    */
    int tablaReduArit[][] = {
        {1,3,9},
        {2,3,9},
        {3,1,9},
        {4,3,10},
        {5,3,10},
        {6,1,10},
        {7,3,11},
        {8,1,11},
        {9,1,11}
    };
    
    ArrayList pila = new ArrayList();
    
    public void desplazar(){
        
    }
    
}
