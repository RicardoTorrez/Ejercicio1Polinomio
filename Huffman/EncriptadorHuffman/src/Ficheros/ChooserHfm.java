package Ficheros;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class ChooserHfm extends FileFilter{
    final static String hfm = "hfm";
    public ChooserHfm() {
    }
 
    
    
	public boolean accept(File f) {
        if (f.isDirectory()) { 
            return true; 
        } 
        String nomb = f.getName(); 
        int num = nomb.lastIndexOf('.'); 
        if (num > 0 &&  num < nomb.length() - 1) { 
            String extension = nomb.substring(num+1).toLowerCase(); //a minusculas
            if (hfm.equals(extension)) { 
                    return true; 
            } else { 
                return false; 
            } 
        } 
        return false;
	}

    @Override
    public String getDescription() {
        
        return ".hfm";
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}