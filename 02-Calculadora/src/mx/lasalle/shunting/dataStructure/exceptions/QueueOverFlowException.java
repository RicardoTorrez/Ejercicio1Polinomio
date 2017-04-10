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
public class QueueOverFlowException extends Exception {

    /**
     * Creates a new instance of <code>QueueOverFlowException</code> without
     * detail message.
     */
    public QueueOverFlowException() {
    }

    /**
     * Constructs an instance of <code>QueueOverFlowException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public QueueOverFlowException(String msg) {
        super(msg);
    }
}
