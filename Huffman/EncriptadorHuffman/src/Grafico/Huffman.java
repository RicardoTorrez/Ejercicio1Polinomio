package Grafico;

import Datos.Arbol;
import Datos.Lista;
import Datos.ListaArbol;

public class Huffman {
	String tecxto;
        String binaryo;
        
        char resul=0;
	int par=1;
        
        ListaArbol listaArbolito;
	
        Arbol arbolito;
	Lista mapita;
	
        
	public Huffman(){

	}
	public Huffman(String huff){
		this.comprimir(huff);
	}

	public String aChar(String caracs){
		int size = 0;
		if((caracs.length()%8)!=0){
			do{
				caracs+='0';
				size++;
			}while(caracs.length()%8!=0);
		}
		
		String auxi = caracs;
		caracs = "";
		while(auxi.length()>0){
			caracs = caracs+aBinario(auxi.substring(0,8));
                        
                        
			auxi = auxi.substring(8);
		}
		return caracs+"////"+size;
	}	

	public char aBinario(String caracs){
		int n = 0;
		int cont = 0;
                
		for(int i=7;i>=0;i--){
			n = (int) (n+(Integer.parseInt(caracs.charAt(cont)+"")*Math.pow(2, i)));
			cont++;
                        resul= (char)n;
		}
		return resul;
	}

	public String aDecimal(int dec){
		String auxBin = "";
		while ( dec!=0 && dec >0 ) {
			auxBin = dec % 2 + auxBin;
			dec /= 2;
		}

			while(auxBin.length()<8){
				auxBin = "0"+auxBin;
			}
		return auxBin; 
	}
        
        
        public String comprimir(String orig) { 
            
		tecxto = orig;
		listaArbolito = new ListaArbol();
		listaArbolito.enlistarArbol(tecxto);
                
		listaArbolito.crearArbol();
		arbolito = listaArbolito.ubicarArbol(par);
		listaArbolito.eliminar(par);
		arbolito.Mapeo("", arbolito.getRaiz());
                
		mapita = arbolito.getMapa();
		binaryo = arbolito.comprimirBinario(tecxto, mapita);

		return binaryo;
	}

	public String desComprimir(String orig){
            
		String textoOrig = "";
                
		String[] auxTex = orig.split("////");
		String temp = auxTex[par];
                
                par++;
	
		for(int i=0;i<temp.length();i++){
			textoOrig+=aDecimal((int)temp.charAt(i));
		}
		
		textoOrig = textoOrig.substring(0,textoOrig.length()-Integer.parseInt(auxTex[par]));
		
		String[] letras = auxTex[0].split("<");
		
		temp = textoOrig;
		textoOrig = "";
                par--;
		while(temp.length()>0){
			for(int i = 0;i<letras.length;i++){
				if(temp.startsWith(letras[i].substring(par))){
					textoOrig+=letras[i].charAt(0);
					temp = temp.substring(letras[i].length()-1);
					break;
				}
			}
		}
		return textoOrig;
	}
}