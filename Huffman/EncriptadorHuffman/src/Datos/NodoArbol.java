package Datos;

public class NodoArbol {
	private int dato;
	private char caracter;
	private NodoArbol derecha;
	private NodoArbol izquierda;

    public NodoArbol(char ch,int cad) {
    	dato=cad;
    	caracter=ch;
    	derecha=null;
    	izquierda=null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public NodoArbol getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoArbol derecha) {
        this.derecha = derecha;
    }

    public NodoArbol getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoArbol izquierda) {
        this.izquierda = izquierda;
    }
    
}