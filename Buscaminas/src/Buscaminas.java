import java.util.Random;

public class Buscaminas {
private celda[][] tablero;
private Integer Sizex;
private Integer Sizey;

public Buscaminas(Integer x, Integer y ){
	Sizex= x;
	Sizey= y;
	
	tablero= new celda[Sizex][Sizey];
	
	for(int i=0; i<Sizex; i++){
		for(int j=0; j<Sizey; j++){
			tablero[i][j] = new celda[][];
		}
	}
	
	
	
	while(bandera){
		bandera= ! tablero[aleatorio[sizex]] [aleatorio[sizey]].ponerMina();
	}
	
	
	for(int i=0; i<minas;i++){
		
	}
}

public void mostrar(){
	for(int i=0; i<Sizex; i++){
		for(int j=0; j<Sizey; j++){
			System.out.println(tablero[i][j] ); 
		}
	}	
}

private void colocarMinas(){
	int contador = 0;
	
	do{
		boolean bandera= true;
		
	}
}

private Integer aleatorio(int size){
	Random random = new Random();
	return random.nextInt(size);
}
}
