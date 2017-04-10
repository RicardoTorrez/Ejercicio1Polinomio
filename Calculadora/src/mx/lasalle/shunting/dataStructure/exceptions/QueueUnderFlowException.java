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
public class QueueUnderFlowException extends Exception {

    /**
     * Creates a new instance of <code>QueueUnderFlowException</code> without
     * detail message.
     */
    public QueueUnderFlowException() {
    }

    /**
     * Constructs an instance of <code>QueueUnderFlowException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public QueueUnderFlowException(String msg) {
        super(msg);
    }
}
