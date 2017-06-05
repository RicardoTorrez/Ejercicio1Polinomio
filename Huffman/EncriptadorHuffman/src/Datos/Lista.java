package Datos;

public class Lista {

    public NodoLista inicio;
    public Lista() {
    	inicio = null;
    }

    public String recorrer(){
        
    	NodoLista aux= inicio;
    	String lisTex = "";
        String res="";
    	while (aux != null){
    		lisTex+=aux.getCaracter()+aux.getDato()+"<";
    		aux = aux.getSiguiente();
                res=lisTex.substring(0,lisTex.length()-1);
    	}
        
    	return res;
    }
    
               public void insertarI(char ch, String st){
		
		NodoLista nuevo=new NodoLista(ch,st);
		
		if(inicio==null){
			inicio=nuevo;
			
			}else{
				nuevo.setSiguiente(inicio);
				inicio=nuevo;
		}
}

   public void insertarF(char ch, String st){
    	NodoLista nuevo = new NodoLista(ch, st);
    	if (inicio==null){
    		inicio = nuevo;
    	} else {
    		NodoLista aux=inicio;
    		while (aux.getSiguiente() != null){
    			aux = aux.getSiguiente();
    		}

    		aux.setSiguiente(nuevo);
    	}
        
    }
    
    public int buscarElemento(char ele){
    	NodoLista aux = inicio;
    	int pos = 0;
    	int cont = 1;
    	while (aux != null && pos==0){
    		if (aux.getCaracter()==ele){
    			pos = cont;
    		} else {
    			aux = aux.getSiguiente();
    			cont++;
    		}
    	}
    	return pos;
    }

    public NodoLista posicionElem(int elem){
    	NodoLista aux = inicio;
    	NodoLista element = null;
    	int cont = 1;
    	while (aux != null && element==null){
    		if (cont==elem){
    			element = aux;
    		} else {
    			aux = aux.getSiguiente();
    			cont++;
    		}
    	}
		return element;
    }
    
       


           }