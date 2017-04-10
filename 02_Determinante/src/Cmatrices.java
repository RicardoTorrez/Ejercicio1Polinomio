
public class Cmatrices {

	public double Determinante(int i, double [][] matriz){
		if(matriz.length==2){
			double deter= (matriz[0][0] * matriz[1][1]) - (matriz[0][1] * matriz[1][0]);
			return deter;
		}
		else{
			double deter=0;
			
			for(int j=0; j<matriz.length; j++){
				double[][] temp = this.SubMatriz(i,j,matriz);
				
				deter= deter + Math.pow(-1, i+j) * matriz[i][j] * this.Determinante(i, temp);
			}
			return deter;
		}
		
	}

	private double[][] SubMatriz(int i, int j, double[][] matriz) {
		double[][] temp = new double[matriz.length-1][matriz.length-1];
		int count1=0;
		int count2=0;
		
		for(int k=0; k<matriz.length;k++){
			if(k!=i){
				count2=0;
				for(int l=0; l<matriz.length; l++){
					if(l!=j){
						temp[count1][count2]= matriz[k][l];
						count2++;
					}
				}

				count1++;
			}
		}
		return temp;
	}
}
