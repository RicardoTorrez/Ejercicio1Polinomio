
public class celda {
	private boolean mina;
	
	private Estado estado;
	
	public celda(){
		mina= false;
		estado= Estado.CERRADO;
	}
	
	public boolean ponerMina(){
		if(!mina){
			mina=true;
			return true;
		}
		
		return false;
	}
	
	public boolean abrirCelda(){
		switch (estado){
		case ABIERTO:
			throw new CeldaAbiertaException();
		case INTERROGACION:
		case MINADO:
			throw new CeldaBloqueadaEsception();
		case CERRADO:
			estado= Estado.ABIERTO;
			return mina;	
			
		}
		return true;
		
	}
	
	public Estado getEstado(){
		return estado;
	}
	
	public String toString(){
		switch (estado){
		case ABIERTO:
		case ABIERTO:
		case ABIERTO:
		case CERRADO:
		}
		
	}
}
