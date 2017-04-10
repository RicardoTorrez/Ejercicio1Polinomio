/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.lasalle.shunting.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import mx.lasalle.shunting.dataStructure.Lista;
import mx.lasalle.shunting.objets.Arithmeticable;

/**
 *
 * @author karimnot
 */
public class Boton extends JButton implements ActionListener {
    
    private Arithmeticable valor;
    private Pantalla frame;
    
    public Boton(Arithmeticable valor, Pantalla fr){
        super(valor.toString());
        this.valor = valor;
        this.frame = fr;
        this.addActionListener(this);
    }
    
    public Arithmeticable getValor(){
        return valor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getLista().add(valor);
        frame.displayList();
    }
    
}
