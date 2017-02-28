
public class resolverRuffiniTest {
	public static void main(String[] args){
		//Datos del primer polinomio
		lista lista1 = new lista();
		
		/**
		 * Dato agregar todos los elementos del polinomio
		 * sin faltar un numero ejemplo
		 * 
		 * 3x^2 + 2x^1 + 12x^0 forma correcta
		 * 
		 * 3x^2 + 12x^0 forma incorrecta
		 * 
		 * Este método solo funciona si 
		 * el divisor es un binomio de la forma x — a
		 */
		
		
		//EJEMPLO 1 
		
		lista1.insertar(1,3);
		lista1.insertar(-4,2);
		lista1.insertar(1,1);
		lista1.insertar(6,0);
		
		
		// EJEMPLO2
		/**
		lista1.insertar(2, 4);
		lista1.insertar(1, 3);
		lista1.insertar(-8, 2);
		lista1.insertar(-1, 1);
		lista1.insertar(6, 0);
		*/

		
		
		System.out.println("Polinomio 1");
		
		lista1.recorrer();
		

		lista1.simplificarlistas(lista1);
		System.out.println("SIMPLIFICACION");
		System.out.println("Polinomio 1");
		lista1.recorrer();
		System.out.println("  ");
		System.out.println("Posibles Soluciones a la incognita x con el polinomio =0 ");
		System.out.println("En un rango de 10,-10 ");
		lista1.resolverMetodoRuffini(lista1);
		
	}
}
