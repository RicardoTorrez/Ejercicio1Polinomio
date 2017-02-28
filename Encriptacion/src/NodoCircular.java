
public class NodoCircular {

	private int dato;
	
	private NodoCircular siguiente;{
		
	}
	
	public NodoCircular(int d) {
	
		dato=d;
		siguiente=null;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	public NodoCircular getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoCircular siguiente) {
		this.siguiente = siguiente;
	}
	
	
	
}
