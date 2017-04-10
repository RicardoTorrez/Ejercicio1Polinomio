/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.lasalle.shunting.exception;

/**
 *
 * @author karimnot
 */
public class ArithmeticExpresionException extends Exception {

    /**
     * Creates a new instance of <code>ArithmeticExpresionException</code>
     * without detail message.
     */
    public ArithmeticExpresionException() {
    }

    /**
     * Constructs an instance of <code>ArithmeticExpresionException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ArithmeticExpresionException(String msg) {
        super(msg);
    }
}
