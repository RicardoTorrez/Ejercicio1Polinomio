package Datos;

public class ListaArbol {
	public Arbol inicio;
	public int cont;

    public ListaArbol() {
    	inicio = null;
    	cont = 0;
    }

    public void recorrer(){
        
    	Arbol aux= inicio;
    	while (aux != null){
            
    		aux.preOrder(aux.getRaiz());
    		aux = aux.getSiguiente();
    	}
    }

    public void insertarOrd (Arbol tempo){
    	if (inicio==null){
    		inicio=tempo;
    	} else {
    		Arbol aux=inicio;
    		Arbol ant= null;
    		while ((aux!=null)&&(tempo.getRaiz().getDato()>=aux.getRaiz().getDato())){
    			ant=aux;
    			aux=aux.getSiguiente();
    		}
    		if (ant!=null){ 
                    ant.setSiguiente(tempo);
    			tempo.setSiguiente(aux);
    			
    		} else {
    			tempo.setSiguiente(inicio);
    			inicio=tempo;
    		}
    	}
    	cont++;
    }
    
     public void eliminar(int pos){
    	Arbol aux = this.inicio;
    	Arbol ant = null;
        
    	if(aux!=null){
    		int conta = 0;
    		while (aux!=null){
    			conta++;
    			if (conta==pos){
    				if (ant!=null){
    				ant.setSiguiente(aux.getSiguiente());
    					aux.setSiguiente(null);
    					aux=null;	
                                    
    				} else {
    					this.inicio = aux.getSiguiente();
    					aux.setSiguiente(null);
    					aux=null;
    				}
    				cont--;
    			} else {
    				ant = aux;
    				aux = aux.getSiguiente();
    			}

    		}
    	}
    }
  public int buscar(char car){
    	Arbol aux = inicio;
    	int posi = 0;
    	int contad = 1;
    	while (aux != null && posi == 0){
    		if (aux.getRaiz().getCaracter() == car){
    			posi = contad;
    			break;
    		} else {
    			aux = aux.getSiguiente();
    			contad++;
    		}
    	}
    	return posi;
    }

	public void crearArbol(){
		while (cont>1){
			Arbol union = enlazar(ubicarArbol(1), ubicarArbol(2));
			insertarOrd(union);
			eliminar(1);
			if(cont!=1){
				eliminar(1);
			}
		}
	}

    public Arbol enlazar(Arbol A, Arbol B){
    	Arbol result = new Arbol('\0', A.getRaiz().getDato()+B.getRaiz().getDato());
    	result.getRaiz().setIzquierda(A.getRaiz());
        
    	result.getRaiz().setDerecha(B.getRaiz());
    	return result;
    }


   public Arbol ubicarArbol(int num){
    	Arbol aux= inicio;
    	Arbol elemen=null;
    	int contado=0;

    	while (aux != null && elemen==null){
    		if (contado==num-1){
                    
    			elemen=aux;
    		} else {
    			aux = aux.getSiguiente();
    			contado++;
    		}
    	}
		return elemen;//devolvemos un numero
    }

    public void enlistarArbol(String txto){
        int cntador;
    	for(int i=0; i<txto.length(); i++){
			if(buscar(txto.charAt(i))==0){
				cntador = 0;
				for (int j=0; j<txto.length(); j++){
					if(txto.charAt(j)==txto.charAt(i)){
						cntador++;
					}
				}
				Arbol arbol= new Arbol(txto.charAt(i), cntador);
				insertarOrd(arbol);
			}
    	}
    }

   
}