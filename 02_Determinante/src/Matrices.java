
public class Matrices {
	public static void main(String[] args){
		double[][] matriz={{1,1,1,1}, {2,4,6,8}, {4,16,36,64}, {8,64,216,512}};
		
		Cmatrices mat= new Cmatrices();
		
		
		
		try{
			System.out.println("La determinante de la matriz es:" + mat.Determinante(0, matriz));
		}catch(Exception e){
			System.out.println("Todo esta mal");	
		}
	}
}
