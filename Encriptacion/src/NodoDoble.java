public class NodoDoble {
	
	private NodoDoble siguiente;
	private int numero;
	private NodoDoble anterior;
	
	
	public NodoDoble (int n){
		
		numero=n;
		siguiente=null;
		anterior=null;
	}

	
	public int getDato() {
		return numero;
	}

	public void setDato(int numero) {
		this.numero = numero;
	}

	public NodoDoble getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoDoble siguiente) {
		this.siguiente = siguiente;
	}
	
	
	public NodoDoble getAnterior() {
		return anterior;
	}

	public void setAnterior(NodoDoble anterior) {
		this.anterior = anterior;
	}
}
