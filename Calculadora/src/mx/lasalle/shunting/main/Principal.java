/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.lasalle.shunting.main;

import mx.lasalle.shunting.exception.ArithmeticExpresionException;
import mx.lasalle.shunting.gui.Pantalla;
import mx.lasalle.shunting.objets.MathSign;
import mx.lasalle.shunting.objets.Numero;
import mx.lasalle.shunting.objets.Operation;
import mx.lasalle.shunting.objets.ShuntingYard;


/**
 *
 * @author karimnot
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ArithmeticExpresionException {
            
        ShuntingYard sy = new ShuntingYard();
        sy.addElement(new Operation(MathSign.PARENTESISIZQ));
        sy.addElement(new Numero('Z'));
        sy.addElement(new Operation(MathSign.MULTIPLICACION));
        sy.addElement(new Operation(MathSign.PARENTESISIZQ));
        sy.addElement(new Numero('K'));
        sy.addElement(new Operation(MathSign.RESTA));
        sy.addElement(new Numero('W'));
        sy.addElement(new Operation(MathSign.PARENTESISDER));
        sy.addElement(new Operation(MathSign.SUMA));
        sy.addElement(new Numero('X'));
        sy.addElement(new Operation(MathSign.PARENTESISDER));
        sy.addElement(new Operation(MathSign.EXPONENTE));
        sy.addElement(new Numero('Y'));
        sy.addElement(new Operation(MathSign.RESTA));
        sy.addElement(new Numero('T'));
        
//        sy.addElement(new Numero<>('X'));
//        sy.addElement(new Operation(MathSign.MULTIPLICACION));
//        sy.addElement(new Operation(MathSign.PARENTESISIZQ));
//        sy.addElement(new Numero<>('Z'));
//        sy.addElement(new Operation(MathSign.SUMA));
//        sy.addElement(new Numero<>('W'));
//        sy.addElement(new Operation(MathSign.PARENTESISDER));
//        sy.addElement(new Operation(MathSign.DIVISION));
//        sy.addElement(new Operation(MathSign.PARENTESISIZQ));
//        sy.addElement(new Numero<>('T'));
//        sy.addElement(new Operation(MathSign.RESTA));
//        sy.addElement(new Numero<>('V'));
//        sy.addElement(new Operation(MathSign.PARENTESISDER));
        
        
        sy.evaluate();
        //sy.mostrar();
        
        
        Pantalla p = new Pantalla();
        

    }

}
