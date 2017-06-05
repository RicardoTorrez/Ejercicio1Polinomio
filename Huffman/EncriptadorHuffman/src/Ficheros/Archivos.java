package Ficheros;

import java.io.*;

public class Archivos {

    public void crear(String texsto,String ubic){
        
        
		texsto = texsto.replaceAll("\n","EOL");
		  Writer write = null;
	        try {
				File f = new File (ubic);
	            write = new BufferedWriter(new OutputStreamWriter(
	                    new FileOutputStream(f),"utf-8"));
	            write.write(texsto);
	             
	        }
	        catch(Exception e){
	         e.printStackTrace();
	        }
	        finally{
				try{                    
					if( null != write ){   
						write.close();     
					}                  
				}catch (Exception ex){ 
					ex.printStackTrace();
				}
	        }
	}
	public String leer(String ubi){
		File f = null;
		FileReader fr = null;
		BufferedReader br = null;
		String tecsto = "";
		try {
			f = new File (ubi);
			br  = new BufferedReader (new InputStreamReader (new FileInputStream (f), "utf-8"));//utf hará que accedamos al unicode del txt   
			fr = new FileReader (f);
			String renglon;
			while((renglon=br.readLine())!=null)
				tecsto += renglon;
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			try{                    
				if( null != fr ){   
					fr.close();     
					br.close();
				}                  
			}catch (Exception ex){ 
				ex.printStackTrace();
			}
		}
		//System.out.println("Abierto antes replace: "+tecsto);
		tecsto = tecsto.replaceAll("EOL", "\n");
		//System.out.println("abierto despues repalceal: "+tecsto);
		return tecsto;
	}
	
	

}
