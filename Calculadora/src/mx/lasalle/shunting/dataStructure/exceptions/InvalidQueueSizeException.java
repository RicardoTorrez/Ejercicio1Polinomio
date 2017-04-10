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
public class InvalidQueueSizeException extends Exception {

    /**
     * Creates a new instance of <code>InvalidQueueSizeException</code> without
     * detail message.
     */
    public InvalidQueueSizeException() {
    }

    /**
     * Constructs an instance of <code>InvalidQueueSizeException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidQueueSizeException(String msg) {
        super(msg);
    }
}
