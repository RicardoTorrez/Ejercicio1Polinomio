/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.lasalle.shunting.dataStructure.exceptions;

/**
 *
 * @author karimnot
 */
public class StackOverFlowException extends Exception {

    /**
     * Creates a new instance of <code>StackOverFlowException</code> without
     * detail message.
     */
    public StackOverFlowException() {
    }

    /**
     * Constructs an instance of <code>StackOverFlowException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public StackOverFlowException(String msg) {
        super(msg);
    }
}
