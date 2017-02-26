
public class Nodo {
	Integer dato;
	Nodo siguiente;

	 public Nodo(Integer elemento){
		 this.dato= elemento;
	 }
	 
	 public Nodo(Integer dato, Nodo siguiente){
		this.dato=dato;
		this.siguiente=null;
	}

	public Integer getDato() {
		return dato;
	}

	public void setDato(Integer dato) {
		this.dato = dato;
	}

	public Nodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}



}
