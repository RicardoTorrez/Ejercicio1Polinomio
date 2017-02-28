import java.io.File;
import java.io.FileReader;

public class ListaCircular {
	

	private NodoCircular actual;//es el equivalente a inicio
	
	public ListaCircular(){
		
		actual=null;
	}

    public NodoCircular getActual() {
        return actual;
    }

    public void setActual(NodoCircular actual) {
        this.actual = actual;
    }
	
	
	public void insertar(int elem){
		
		NodoCircular nuevo= new NodoCircular (elem);
		nuevo.setSiguiente(nuevo);
		
		if(actual==null){
			actual=nuevo;
		}else{
			nuevo.setSiguiente(actual.getSiguiente());
			actual.setSiguiente(nuevo);
		}	

	}
        
            public void InsertarInicio (int d){
      
       NodoCircular nuevo =new NodoCircular(d);
         if(actual==null){
         actual=nuevo;
         nuevo.setSiguiente(nuevo);
       }else{
         NodoCircular aux=actual;
         while(aux.getSiguiente()!=actual){
                   aux=aux.getSiguiente();
         }
         aux.setSiguiente(nuevo);
         nuevo.setSiguiente(actual);
        
       }
            }
	
	
	public void recorrer(){
		
		if(actual!=null){
                        System.out.printf("%s",actual.getDato());
			NodoCircular aux=actual.getSiguiente();
                       

			do{
				
				System.out.printf("%s",aux.getDato());
			
				aux=aux.getSiguiente();
			}while(aux!=actual);
		
		}
	}

        
        
        public int MostrarElemento()throws ListaVaciaException{
		
		if(actual==null)
		throw new ListaVaciaException();
		int salida=actual.getDato();
		actual=actual.getSiguiente();
		
		return salida;
		
	}
                
        public void imprimir ()
    {
        if (actual!=null) {
            NodoCircular reco=actual;
            do {
                System.out.printf("%s",reco.getDato());
                reco = reco.getSiguiente();                
            } while (reco!=actual);
        }    
    }  
        
        
        public int contarDatos(){
//acabarlo
		NodoCircular aux=null;
                NodoCircular ini=actual;
		NodoCircular ant=null;
		int conta=0;
		while(aux!=ini){
			
                        
			ant=ini;
			aux=ant.getSiguiente();	
			
			conta++;

		}
		while(ant!=null){
			

			ant=ant.getSiguiente();
			
			conta++;

		}
		
		
		return conta-1;

	}
        
        
        public ListaCircular LeerPass(String passWord) {
            
            ListaCircular contraSe= new ListaCircular();
    
        try{
            
           String sCadena = passWord;


                for (int x=0;x<sCadena.length();x++){
               
                    
                           int nie= sCadena.codePointAt(x);

                
                 //System.out.println(/*sCadena.charAt(x) +*/ " = " + sCadena.codePointAt(x));
                
                
                    contraSe.InsertarInicio(nie);
     
                }
                //caract = fr.read();
            
   
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    return contraSe;
}
    
        
	
        
	
//Llave de la clase	
}
