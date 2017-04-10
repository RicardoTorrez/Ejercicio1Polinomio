/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.lasalle.shunting.objets;

import java.text.DecimalFormat;

/**
 *
 * @author karimnot
 */
public class Numero implements Arithmeticable {

    private Character dato;
    
    public Numero(Character dato){
        this.dato = dato;
    }
    
    @Override
    public boolean isOperator() {
        return false;
    }
    
    public String toString(){
        return String.valueOf(dato);
    }
    
    public Character getDato(){
        return dato;
    }



}
