/*
 * tablaSLRlogico
 *  Contiene lo necesario para poder realizar el análisis sintáctico, como parte
 *  del compilador Katarti.
 *  Contiene
 *    -tablaLogica[][]
 *    -tablaElimiacion
 */
package compilador;

/**
 *
 * @author Pahola y Jesús
 */
public class tablaSLRlogico {
    /*
    tablaAritmetica
        Contiene los valores de la tabla SLR que se necesitan para poder realizar
        el análisis sintáctico del código Katarti con extención .gri
    */
    static String tablaLogica[][] = {
        {"s9","s10","s11","s12",null,null,"s6",null,null,null,null,"s8",null,null,"1","2","3","4","5","7"},
        {null,null,null,null,null,null,null,null,null,null,null,null,null,"acep",null,null,null,null,null,null},
        {null,null,null,null,"r2","s15",null,null,null,null,null,null,"r2","r2",null,null,null,null,null,null},
        {null,null,null,null,"r4","r4",null,"s15","s16",null,null,null,"r4","r4",null,null,null,null,null,null},
        {null,null,null,null,"r7","r7",null,"r7","r7","s17","s18",null,"r7","r7",null,null,null,null,null,null},
        {null,null,null,null,"r10","r10",null,"r10","r10","r10","r10",null,"r10","r10",null,null,null,null,null,null},
        {"s9","s10","s11","s12",null,null,"s6",null,null,null,null,"s8",null,null,"19","2","3","4","5","7"},
        {null,null,null,null,"r12","r12",null,"r12","r12","r12","r12",null,"r12","r12",null,null,null,null,null,null},
        {"s9","s10","s11","s12",null,null,"s6",null,null,null,null,"s8",null,null,"20","2","3","4","5","7"},
        {null,null,null,null,"r14","r17",null,"r14","r14","r14","r14",null,"r14","r14",null,null,null,null,null,null},
        {null,null,null,null,"r15","r15",null,"r15","r15","r15","r15",null,"r15","r15",null,null,null,null,null,null},
        {null,null,null,null,"r16","r16",null,"r16","r16","r16","r16",null,"r16","r16",null,null,null,null,null,null},
        {null,null,null,null,"r17","r17",null,"r17","r17","r17","r17",null,"r17","r17",null,null,null,null,null,null},
        {"s9","s10","s11","s12",null,null,"s6",null,null,null,null,"s8",null,null,null,"21","3","4","5","7"},
        {"s9","s10","s11","s12",null,null,"s6",null,null,null,null,"s8",null,null,null,null,"22","4","5","7"},
        {"s9","s10","s11","s12",null,null,"s6",null,null,null,null,"s8",null,null,null,null,null,"23","5","7"},
        {"s9","s10","s11","s12",null,null,"s6",null,null,null,null,"s8",null,null,null,null,null,"24","5","7"},
        {"s9","s10","s11","s12",null,null,"s6",null,null,null,null,"s8",null,null,null,null,null,null,"25","7"},
        {"s9","s10","s11","s12",null,null,"s6",null,null,null,null,"s8",null,null,null,null,null,null,"26","7"},
        {null,null,null,null,"r11","r11",null,"r11","r11","r11","r11",null,"r11","r11",null,null,null,null,null,null},
        {null,null,null,null,"s13",null,null,"r17","r17","r17","r17",null,"s27",null,null,null,null,null,null,null},
        {null,null,null,null,"r1","s14",null,null,null,null,null,null,"r1","r1",null,null,null,null,null,null},
        {null,null,null,null,"r3","r3",null,"s15","s16",null,null,null,"r3","r3",null,null,null,null,null,null},
        {null,null,null,null,"r5","r5",null,"r5","r5","r5","r5",null,"r5","r5",null,null,null,null,null,null},
        {null,null,null,null,"r6","r6",null,"r6","r6","r6","r6",null,"r6","r6",null,null,null,null,null,null},
        {null,null,null,null,"r8","r8",null,"r8","r8","r8","r8",null,"r8","r8",null,null,null,null,null,null},
        {null,null,null,null,"r9","r9",null,"r9","r9","r9","r9",null,"r9","r9",null,null,null,null,null,null},
        {null,null,null,null,"r13","r13",null,"r13","r13","r13","r13",null,"r13","r13",null,null,null,null,null,null},        
    };
    
    
    
    
    
    /*
    tablaReducLogica
    Contiene (representados con números) de izquierda a derecha:
        -Número de grámatica:
            1.E->EpolT
            2.E->T
            3.T->TatF
            4.T->F
            5.F->F==G
            6.F->!=G
            7.F->G
            8.G->G>H
            9.G->G<H
            10.G->H
            11.H->arE
            12.H->I
            13.I->(E)
            14.I->num
            15.I->id
            16.I->0
            17.I->1
        -Número de elementos que se eliminarán de la pila
        -Número de columna que representa a las letras de las producciones en 
        la tabla SLR aritmetica ó el arreglo tablaAritmetica
            E: 14
            T: 15
            F: 16
            G: 17
            H: 18
            I: 19
    */
    static int tablaReduArit[][] = {
        {1,3,14},
        {2,1,14},
        {3,3,15},
        {4,1,15},
        {5,3,16},
        {6,3,16},
        {7,1,16},
        {8,3,17},
        {9,3,17},
        {10,1,17},
        {11,2,18},
        {12,1,18},
        {13,3,19},
        {14,1,19},
        {15,1,19},
        {16,1,19}, 
        {17,1,19},       
    };
}
