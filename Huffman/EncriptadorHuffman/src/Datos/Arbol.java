package Datos;

public class Arbol {
    
	private NodoArbol raiz;
	private Arbol siguiente;
	public String temp;
	private Lista mapa;

    public Arbol(char cha, int valu) {
    	raiz = new NodoArbol(cha, valu);
    	temp="";
        siguiente = null;
    	
    	mapa= new Lista();
    }

        	public String eliminar(String tem){
		return tem.substring(0, tem.length()-1);
	}

     public void inOrder(NodoArbol r){
    	if (r!=null){
    		preOrder(r.getIzquierda());
                System.out.print("("+r.getCaracter()+", "+r.getDato()+"),");
    		preOrder(r.getDerecha());
    	}
    }

    public void preOrder(NodoArbol r){
    	if (r!=null){
    		System.out.print("("+r.getCaracter()+", "+r.getDato()+"),");
    		preOrder(r.getIzquierda());
    		preOrder(r.getDerecha());
    	}
    }
    
    	public void Mapeo(String chara, NodoArbol roo){
 		temp+=chara;
    	if (roo!=null){
    		if( roo.getCaracter()!='\0'){ //blank space
                    
    			mapa.insertarF(roo.getCaracter(), temp);
    		}
    		Mapeo("0", roo.getIzquierda());
                
			if(roo.getIzquierda()!=null){
				temp = eliminar(temp);
			}
    		Mapeo("1", roo.getDerecha());
                
    		if( roo.getDerecha()!=null){ 
                    
	    		temp = eliminar(temp);
			}
    	} else {
    		temp = eliminar(temp);
    	}
    }

    public Lista getMapa() {
        return mapa;
    }
    
    public void setMapa(Lista mapa) {
        this.mapa = mapa;
    }
    
     public String comprimirBinario(String texto, Lista mapita){
    	NodoLista aux;
         String linea = "";
    	
    	for(int i=0; i<texto.length(); i++){ 
    		aux = mapita.posicionElem(mapita.buscarElemento(texto.charAt(i)));
			linea+=aux.getDato()+"";
    	}
    	return linea;
    }

    public Arbol getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Arbol siguiente) {
        this.siguiente = siguiente;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }
}