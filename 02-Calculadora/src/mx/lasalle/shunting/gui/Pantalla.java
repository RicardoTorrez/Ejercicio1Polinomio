/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.lasalle.shunting.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mx.lasalle.shunting.dataStructure.Lista;
import mx.lasalle.shunting.dataStructure.exceptions.ListaVaciaException;
import mx.lasalle.shunting.exception.ArithmeticExpresionException;
import mx.lasalle.shunting.objets.Arithmeticable;
import mx.lasalle.shunting.objets.MathSign;
import mx.lasalle.shunting.objets.Numero;
import mx.lasalle.shunting.objets.Operation;
import mx.lasalle.shunting.objets.ShuntingYard;

/**
 *
 * @author karimnot
 */
public class Pantalla extends JFrame {

    private JButton btnAC;
    private JButton btnC;
    private JButton btnIgual;

    private Boton btnParentesisDer;
    private Boton btnParentesisIzq;
    private Boton btnMultiplicacion;
    private Boton btnDivision;
    private Boton btnSuma;
    private Boton btnResta;
    private Boton btnExponente;

    private Boton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btn0;

    private JTextField edtPantalla;
    private JTextField edtExpresion;

    Lista<Arithmeticable> lista;
    Lista<Arithmeticable> resultado;

    public Pantalla() {
        super("Calculadora");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLocation(100, 100);
        super.setSize(250, 300);
        super.setLayout(new BorderLayout());

        lista = new Lista();
        resultado = new Lista();

        super.add(pnlPantalla(), BorderLayout.NORTH);
        super.add(pnlBotones(), BorderLayout.CENTER);

        super.setVisible(true);
    }

    private JPanel pnlBotones() {
        JPanel pnlBotones = new JPanel();
        //pnlBotones.setBackground(Color.BLUE);
        pnlBotones.setLayout(new GridLayout(5, 4));

        btnAC = new JButton("AC");
        btnAC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lista.empty();
                displayList();
            }
        });

        btnC = new JButton("C");
        btnC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    lista.drop();
                } catch (ListaVaciaException ex) {
                } finally {
                    displayList();
                }
            }
        });

        btnIgual = new JButton("=");
        btnIgual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evaluar();
            }
        });

        btnExponente = new Boton(new Operation(MathSign.EXPONENTE), this);
        btnSuma = new Boton(new Operation(MathSign.SUMA), this);
        btnResta = new Boton(new Operation(MathSign.RESTA), this);
        btnMultiplicacion = new Boton(new Operation(MathSign.MULTIPLICACION), this);
        btnDivision = new Boton(new Operation(MathSign.DIVISION), this);
        btnParentesisDer = new Boton(new Operation(MathSign.PARENTESISDER), this);
        btnParentesisIzq = new Boton(new Operation(MathSign.PARENTESISIZQ), this);

        btn1 = new Boton(new Numero('A'), this);
        btn2 = new Boton(new Numero('B'), this);
        btn3 = new Boton(new Numero('C'), this);
        btn4 = new Boton(new Numero('V'), this);
        btn5 = new Boton(new Numero('K'), this);
        btn6 = new Boton(new Numero('T'), this);
        btn7 = new Boton(new Numero('X'), this);
        btn8 = new Boton(new Numero('W'), this);
        btn9 = new Boton(new Numero('Y'), this);
        btn0 = new Boton(new Numero('Z'), this);

        pnlBotones.add(btnAC);
        pnlBotones.add(btnC);
        pnlBotones.add(btnParentesisIzq);
        pnlBotones.add(btnParentesisDer);

        pnlBotones.add(btn7);
        pnlBotones.add(btn8);
        pnlBotones.add(btn9);
        pnlBotones.add(btnSuma);

        pnlBotones.add(btn4);
        pnlBotones.add(btn5);
        pnlBotones.add(btn6);
        pnlBotones.add(btnResta);

        pnlBotones.add(btn1);
        pnlBotones.add(btn2);
        pnlBotones.add(btn3);
        pnlBotones.add(btnMultiplicacion);

        pnlBotones.add(btn0);
        pnlBotones.add(btnDivision);
        pnlBotones.add(btnExponente);
        pnlBotones.add(btnIgual);

        return pnlBotones;
    }

    private JPanel pnlPantalla() {
        JPanel pnlPantalla = new JPanel();
        //pnlPantalla.setBackground(Color.RED);
        pnlPantalla.setLayout(new BorderLayout());

        edtPantalla = new JTextField();
        //edtPantalla.setEditable(false);
        edtPantalla.setFont(new Font("Arial", Font.BOLD, 24));
        edtPantalla.setHorizontalAlignment(JTextField.RIGHT);

        edtExpresion = new JTextField();
        edtExpresion.setBackground(Color.DARK_GRAY);
        //edtExpresion.setEditable(false);
        edtExpresion.setFont(new Font("Arial", Font.PLAIN, 16));
        edtExpresion.setForeground(Color.WHITE);

        pnlPantalla.add(edtExpresion, BorderLayout.NORTH);
        pnlPantalla.add(edtPantalla, BorderLayout.CENTER);

        return pnlPantalla;
    }

    public void displayList() {
        edtExpresion.setText("");
        for (Iterator<Arithmeticable> iterator = lista.iterator(); iterator.hasNext();) {
            Arithmeticable next = (Arithmeticable) iterator.next();
            edtExpresion.setText(edtExpresion.getText() + next);
        }
        edtPantalla.setText("");
        for (Iterator<Arithmeticable> iterator = resultado.iterator(); iterator.hasNext();) {
            Arithmeticable next = iterator.next();
            edtPantalla.setText(edtPantalla.getText() + next);
        }
    }

    public Lista<Arithmeticable> getLista() {
        return lista;
    }

    public void setLista(Lista<Arithmeticable> lista) {
        this.lista = lista;
    }

    public void evaluar() {
        try {
            ShuntingYard shunting = new ShuntingYard();
            for (Iterator<Arithmeticable> iterator = lista.iterator(); iterator.hasNext();) {
                Arithmeticable next = iterator.next();
                shunting.addElement(next);
            }
            resultado = shunting.evaluate();
            displayList();
        } catch (ArithmeticExpresionException ex) {
            edtExpresion.setText("Error!");
        }
    }

}
