package clasePila;

public class Pila <T> {
	private Lista<T> lista;
	private Integer tope;
	private Integer elementos;

	public Pila(){
		this(0);
		
	}

	public Pila(Integer tope) throws@ valortopeException() {
		if(tope<0){
			throw new valortopeException();
			
		}
		lista = new Lista();
		this.tope=tope;
		elementos=0;
		
	}
}
