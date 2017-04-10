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
public class StackUnderFlowException extends Exception {

    /**
     * Creates a new instance of <code>StackUnderFlowException</code> without
     * detail message.
     */
    public StackUnderFlowException() {
    }

    /**
     * Constructs an instance of <code>StackUnderFlowException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public StackUnderFlowException(String msg) {
        super(msg);
    }
}
