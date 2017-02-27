
public class multiplicacionTest {


	public static void main(String[] args){
		//Datos del primer polinomio
		lista lista1 = new lista();
		
		lista1.insertar(2, 2);
		lista1.insertar(2,1);
		lista1.insertar(-3, 0);
		lista1.insertar(-1,1);
		lista1.insertar(3,2);
		//datos del segundo polinomio
		lista lista2 = new lista();

		lista2.insertar(-3, 2);
		lista2.insertar(1,1);
		/**
		lista2.insertar(-5,1);
		lista2.insertar(-3,0);
		lista2.insertar(5, 0);
		*/
		System.out.println("Polinomio 1");
		
		lista1.recorrer();
		
		System.out.println("Polinomio 2");
		
		lista2.recorrer();
		lista1.simplificarlistas(lista1);
		lista2.simplificarlistas(lista2);	
		System.out.println("SIMPLIFICACION");
		
		System.out.println("Polinomio 1");
		lista1.recorrer();
		System.out.println("Polinomio 2");
		lista2.recorrer();
		lista1.multiplicacion(lista1, lista2);
	}


}
