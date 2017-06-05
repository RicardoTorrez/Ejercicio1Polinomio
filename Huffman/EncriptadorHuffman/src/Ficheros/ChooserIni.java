package Ficheros;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class ChooserIni extends FileFilter{
    final static String ini = "ini";
    
    
	public boolean accept(File f) {
        if (f.isDirectory()) { 
            return true; 
        } 
        String nomb = f.getName(); 
        int num = nomb.lastIndexOf('.'); 
        if (num > 0 &&  num < nomb.length() - 1) { 
            String extension = nomb.substring(num+1).toLowerCase(); //a minusculas
            
            if (ini.equals(extension)) { 
                    return true; 
            } else { 
                return false; 
            } 
        } 
		return false;
	}
        
        /*public void multi (int t){
            setMultiSelectionEnabled(boolean)
            boolean f.isMultiSelectionEnabled()
        }
*/

	@Override
	public String getDescription() {
            
		return ".ini";
                
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
}
