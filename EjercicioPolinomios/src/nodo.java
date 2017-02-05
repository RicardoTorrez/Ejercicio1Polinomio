
public class nodo {
	monomio dato;
	nodo siguiente;
	
	public nodo(){
		
	}
	
	public nodo(monomio monomio, nodo siguiente){
		this.dato=monomio;
		this.siguiente=null;
	}
	
	public nodo(monomio monomio){
		this.dato=monomio;
	}
	

	public monomio getDato() {
		return dato;
	}

	public void setDato(monomio dato) {
		this.dato = dato;
	}

	public nodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(nodo siguiente) {
		this.siguiente = siguiente;
	}
	
}
