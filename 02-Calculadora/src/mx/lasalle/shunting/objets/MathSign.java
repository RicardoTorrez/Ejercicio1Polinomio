/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.lasalle.shunting.objets;

/**
 *
 * @author karimnot
 */
public enum MathSign {
    PARENTESISIZQ(0,'('),
    PARENTESISDER(4,')'),
    EXPONENTE(3,'^'),
    MULTIPLICACION(2,'*'),
    DIVISION(2,'/'),
    SUMA(1,'+'),
    RESTA(1,'-');
    
    private int level;
    private char character;
    
    private MathSign(int lv, char c){
        level = lv;
        character = c;
    }
    
    public int getLevel(){
        return level;
    }
    
    public String toString(){
        return String.valueOf(character);
    }
    
}
