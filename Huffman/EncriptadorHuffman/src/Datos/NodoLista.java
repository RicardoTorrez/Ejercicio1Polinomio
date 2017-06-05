package Datos;

public class NodoLista {

	private String dato;
	private char caracter;
	private NodoLista siguiente;
        
    public NodoLista(char ch, String cad) {
    	siguiente = null;
    	caracter=ch;
    	dato = cad;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public NodoLista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLista sig) {
        this.siguiente = sig;
    }


    
    
}