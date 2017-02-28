import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


public class ListaDoble {
	
	private NodoDoble inicio;
	
	public ListaDoble(){
		
		inicio=null;

	}
        
        public NodoDoble getFinal(){
            NodoDoble aux = this.getInicio();
            while(aux.getSiguiente()!=null){
						
			aux=aux.getSiguiente();	
			

		}
            return aux;
        }

    public NodoDoble getInicio() {
        return inicio;
    }

    public void setInicio(NodoDoble inicio) {
        this.inicio = inicio;
    }
	
	public void insertarF (int elem){
		
		NodoDoble nuevo=new NodoDoble(elem);
		
		if(inicio==null){
			
			inicio=nuevo;
			
		}else{
		NodoDoble aux=inicio;
		while(aux.getSiguiente()!=null){
			
			aux=aux.getSiguiente();
		}
		
		aux.setSiguiente(nuevo);
		nuevo.setAnterior(aux);
		}	

	}
        
        public void insertarCharF (char elem){
		
		NodoDoble nuevo=new NodoDoble(elem);
		
		if(inicio==null){
			
			inicio=nuevo;
			
		}else{
		NodoDoble aux=inicio;
		while(aux.getSiguiente()!=null){
			
			aux=aux.getSiguiente();
		}
		
		aux.setSiguiente(nuevo);
		nuevo.setAnterior(aux);
		}	

	}
	
	public void insertarI (int elem){
		
		
	NodoDoble nuevo=new NodoDoble(elem);
	
	if(inicio==null){
		
		inicio=nuevo;
	}else{
		
		nuevo.setSiguiente(inicio);
		inicio.setAnterior(nuevo);
		inicio=nuevo;
		
		
		}	
	}
	
	public void mostrarDatos(){

		NodoDoble aux=inicio;
		NodoDoble ant=null;
		
		
		while(aux!=null){
			
			System.out.printf("%s",aux.getDato());
			
			ant=aux;
			aux=aux.getSiguiente();	
			
		}
		while(aux!=null){
			
			System.out.printf("%s",ant.getDato());

			ant=ant.getSiguiente();
		}

	}
	
	
	
	public int contarDatos(){

		NodoDoble aux=inicio;
		NodoDoble ant=null;
		int conta=0;
		while(aux!=null){
						
			ant=aux;
			aux=aux.getSiguiente();	
			
			conta++;

		}
		while(ant!=null){
			

			ant=ant.getSiguiente();
			
			conta++;

		}
		
		
		return conta-1;

	}
        
        public int ListaMayor(ListaDoble lista1, ListaDoble lista2){

            try{
                
                
                int mayor=0;
                NodoDoble aux1=lista1.getInicio();
                //System.out.println(aux1.getDato());
                NodoDoble aux2=lista2.getInicio();

                while (aux1 != null && mayor>=0) {

                      

                    if (aux1.getDato() > aux2.getDato()) {
                        
                        mayor=2;
                    }else if(aux1.getDato() < aux2.getDato()){
                        
                        mayor=1;
                    }
                        

                    
                    
                    aux1 = aux1.getSiguiente();

                    aux2 = aux2.getSiguiente();


                }
		
                
                return mayor;

	}catch(Exception ex){
            ex.printStackTrace();
            return -1;
        }
            
            
                
    }

        
        public void Suma(ListaDoble lista1, ListaCircular lista2){
            
            try{
                
                ListaDoble lista3= new ListaDoble();
                NodoDoble aux1=lista1.getInicio();
                NodoCircular aux2=lista2.getActual();

                while (aux1 != null) {
//System.out.println(aux1.getDato());
//System.out.println(aux2.getDato());
                    int resultado = aux1.getDato() + aux2.getDato();

                    if (resultado >= 256) {

                        resultado = resultado-255;
                       // llevar=1;

                    }
                     //   llevar=0;
                    lista3.insertarF(resultado);
                    
                  
                    //ant1 = aux1;
                    aux1 = aux1.getSiguiente();
                    //ant2 = aux2;
                    aux2 = aux2.getSiguiente();
                    /*if(llevar!=0){
				aux1.setDato(aux1.getDato()+1);
				
				llevar--;
			}*/

                }

                this.setInicio(lista3.getInicio());
            
            
            }
            catch(Exception ex){
                //return null;
            }
            
 	
	}

	
        
        	public void borrarArhivo() {

		File file;
		//file = new File("output.txt");
                file=new File(new File ("").getAbsolutePath ()+"\\src\\archivos\\output.txt");
		try {
			FileWriter fw = new FileWriter(file, false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			pw.write("");
			pw.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void insertarDatoEnArchivo(int dato) {

		File file;
		//file = new File("output.txt");
                file=new File(new File ("").getAbsolutePath ()+"\\src\\archivos\\output.txt");
		try {
		FileWriter fw = new FileWriter(file, false);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		pw.write("" + dato + "\r\n");
		pw.close();
		bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
                }
        public void insertarDatoVacioEnArchivo(String n) {

		File file;
		//file = new File("output.txt");
                file=new File(new File ("").getAbsolutePath ()+"\\src\\archivos\\output.txt");
		try {
		FileWriter fw = new FileWriter(file, false);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		pw.write(n);
		pw.close();
		bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
                }

	public void insertarListaEnArchivo(ListaDoble lista4) {
		NodoDoble aux = lista4.inicio;
		File file;
		//file = new File("output.txt");
                file=new File("C:\\Users\\Alester\\Desktop\\desenc.txt");
		try {
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			while (aux != null) {
				String x = "" + aux.getDato();
				pw.append(x);
				aux = aux.getSiguiente();
			}

			pw.write("\n");
			pw.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
        

    public ListaDoble LeerArchivo(ListaDoble ListaDatos) {

        
        // TODO code application logic here
        try{
            
            FileReader fr;
            int caract;
            fr = new FileReader(new File ("").getAbsolutePath ()+"\\src\\archivos\\input.txt");
            caract = fr.read();
            while(caract != -1) {

                    //System.out.println(caract+" : "+(char)caract);
                    
                   // System.out.printf("%d ", caract);
                    ListaDatos.insertarF(caract);

                caract = fr.read();
                
            }
            
   
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    return ListaDatos;
}
    
    
    


public ListaDoble LeerStream(ListaDoble ListaBytes) throws IOException {

      
      InputStream is = null;
      
      
      try{
         // new input stream created
         //                file=new File(new File ("").getAbsolutePath ()+"\\src\\archivos\\asd.txt");
         
                 
        // is = new FileInputStream("D:\\Java\\WorkSpaceEscuela\\03Encriptador\\src\\archivos\\archi.txt");
         is = new FileInputStream("archi.txt");
         int i;
         //char c;
         //System.out.println("Characters printed:");
         //i= is.read();
         // reads till the end of the stream
         while((i=is.read())!=-1)
         {
             
            // converts integer to character
             //System.out.print(i);
            //c=(char)i;
            
            //prints character
           //System.out.print(c);
                        //System.out.print(i+" ");
                      ListaBytes.insertarF(i);


         }
      }catch(Exception e){
         
         // if any I/O error occurs
         e.printStackTrace();
      }finally{
         
         // releases system resources associated with this stream
         if(is!=null){
            is.close();
      }
   }
   
    return ListaBytes;

}



/*
		NodoDoble aux=inicio;
		//NodoDoble ant=null;
		while(aux!=null){
						
			//ant=aux;
                        char letra=(char)(aux.getDato());
                        
                        tempo.insertarCharF(letra);
			aux=aux.getSiguiente();	    


		}
		//while(ant!=null){
			
			//ant=ant.getSiguiente();
                        // char letra=(char)(ant.getDato());
                      //  tempo.insertarF(letra);


		//}
		

	}*/


    
      public void Casteando(ListaDoble tempo){
            //Corregir
            try{
                
                ListaDoble listaEntre= new ListaDoble();
                NodoDoble aux1=tempo.getInicio();
              

                while (aux1 != null) {
//System.out.println(aux1.getDato());
//System.out.println(aux2.getDato());
                    char letra=(char)(aux1.getDato());

                    
                     //   llevar=0;
                    listaEntre.insertarCharF(letra);
                    
                  
                    //ant1 = aux1;
                    aux1 = aux1.getSiguiente();
                    //ant2 = aux2;
                    
                    
                    
                }

                this.setInicio(listaEntre.getInicio());
            
            
            }
            catch(Exception ex){
                //return null;
            }
            
 	
	}
      
      
      
      public void SacarStream(ListaDoble ListaBytes2) throws IOException {
      
          
       NodoDoble aux1=ListaBytes2.getInicio();
      OutputStream out = null;
      //InputStream is = null;
      
      
      try{
        //
         //out = new FileOutputStream("D:\\Java\\WorkSpaceEscuela\\03Encriptador\\src\\archivos\\archi.txt");
         out = new FileOutputStream("archi.txt");
         //int i;
         // reads till the end of the stream
         while (aux1 != null) {
                     

                    char let= (char) (aux1.getDato());

                   out.write(let);
                  
                    aux1 = aux1.getSiguiente();
                   
                }
             
           
      }catch(Exception e){
      
         e.printStackTrace();
      }finally{
         
         // releases system resources associated with this stream
         if(out!=null){
            out.close();
      }
   }
      
      }
   
   
   public void Resta(ListaDoble listaI1, ListaCircular listaI2){
            
            try{
                
                ListaDoble listaI3= new ListaDoble();
                NodoDoble aux1=listaI1.getInicio();
                NodoCircular aux2=listaI2.getActual();

                while (aux1 != null) {
//System.out.println(aux1.getDato());
//System.out.println(aux2.getDato());
                    int resultado = aux1.getDato() - aux2.getDato();

                    if (resultado < 0) {

                        resultado = resultado+255;
                       // llevar=1;

                    }
                     //   llevar=0;
                    listaI3.insertarF(resultado);
                    
                  
                    //ant1 = aux1;
                    aux1 = aux1.getSiguiente();
                    //ant2 = aux2;
                    aux2 = aux2.getSiguiente();
                    /*if(llevar!=0){
				aux1.setDato(aux1.getDato()+1);
				
				llevar--;
			}*/

                }

                this.setInicio(listaI3.getInicio());
            
            
            }
            catch(Exception ee){
                //return null;
            }
            
 	
	}

      


}
   