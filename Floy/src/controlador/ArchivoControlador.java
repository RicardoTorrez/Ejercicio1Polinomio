package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class ArchivoControlador {

	public static void guardar(String contenido) {
		File archivo = null;
		FileWriter fw = null;
		try {
			archivo = new File("resultado.txt");
			fw = new FileWriter(archivo);
			fw.write(contenido);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fw != null)
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}