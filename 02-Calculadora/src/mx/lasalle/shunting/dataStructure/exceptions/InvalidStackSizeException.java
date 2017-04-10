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
public class InvalidStackSizeException extends Exception {

    /**
     * Creates a new instance of <code>InvalidStackSizeException</code> without
     * detail message.
     */
    public InvalidStackSizeException() {
    }

    /**
     * Constructs an instance of <code>InvalidStackSizeException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidStackSizeException(String msg) {
        super(msg);
    }
}
