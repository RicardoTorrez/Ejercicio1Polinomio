import java.io.*;
import java.util.*;
import javax.swing.*;
import java.net.*;
class ThreadCliente extends Thread {
	private BufferedReader entrada;
	public ThreadCliente (BufferedReader entrada) throws IOException {
		this.entrada=entrada;
		start(); // Se arranca el hilo.
	}
	public void run() {
		// Última línea del aviso de desconexión por falta de actividad.
		String fin1 = "> *****************ADIOS*****************";
		// Última línea del aviso de desconexión por uso de la orden DESCONECTAR.
		String fin2 = "> ***********HASTA LA VISTA****************";
		String linea = null;
		try {
			while( ( linea=entrada.readLine() ) != null ) {
				System.out.println(linea);
				if ( linea.equals(fin1) || linea.equals(fin2) )
					break;
			}
		}	
		catch (IOException e1) {
			e1.printStackTrace();
		}
		finally {
			if (entrada !=null) {
				try {
					entrada.close();
				}
				catch (IOException e2) {} // No se hace nada con la excepción
			}
			System.exit(-1);
		}
	} 
}

